package br.com.will.service.impl;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.stream.LongStream;

import br.com.will.annotation.LogMe;
import br.com.will.service.ThreadService;
import br.com.will.thread.queue.manager.runtime.annotation.Virtual;
import br.com.will.thread.queue.manager.runtime.service.impl.PlatformThreadQueueManager;
import br.com.will.thread.queue.manager.runtime.service.impl.VirtualThreadQueueManager;
import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
@LogMe
public class ThreadServiceImpl implements ThreadService {

    private final Random random = new Random();

    @Inject
    @Virtual
    VirtualThreadQueueManager virtualThreadQueueManager;

    @Inject
    PlatformThreadQueueManager platformThreadQueueManager;

    @Override
    public String run(String tipo) {

        long startTime = System.nanoTime();

        LongStream randomNumbers = random.longs(10000, 100, 1001);

        final List<CompletionStage<Long>> exec;
        if ("virtual".equals(tipo)) {

            exec = randomNumbers.boxed().map(number -> virtualThreadQueueManager.executeTasks(() -> this.delay(number)))
                    .toList();

        } else {
            exec = randomNumbers.boxed()
                    .map(number -> platformThreadQueueManager.executeTasks(() -> this.delay(number))).toList();

        }

        for (CompletionStage<Long> virtual : exec) {

            try {
                // Aguarda o retorno de todas as Threads
                virtual.toCompletableFuture().get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        return "Tempo de execução: " + duration / 1_000_000 + " ms";

    }

    private Long delay(Long number) {

        Log.info(Thread.currentThread().getName());

        return Uni.createFrom().item(number).onItem().delayIt().by(Duration.ofMillis(number * 5)).await()
                .indefinitely();
    }

}
