package br.com.will.thread.queue.manager.runtime.service.impl;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.will.thread.queue.manager.runtime.service.ThreadQueueManager;
import io.quarkus.vertx.core.runtime.context.VertxContextSafetyToggle;
import io.smallrye.common.vertx.VertxContext;
import io.vertx.core.Context;
import io.vertx.core.Vertx;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PlatformThreadQueueManager implements ThreadQueueManager {

    @Inject
    Vertx vertx;

    private ExecutorService executorService;

    @PostConstruct
    public void init() {
        // Configurar o ExecutorService com threads virtuais
        executorService = Executors.newFixedThreadPool(500,
                Thread.ofPlatform().name("platform-thread-queue-", 0).factory());
    }

    @Override
    public <T> CompletionStage<T> executeTasks(Callable<T> task) {
        Context context = VertxContext.getOrCreateDuplicatedContext(vertx);
        VertxContextSafetyToggle.setContextSafe(context, true);

        CompletableFuture<T> future = new CompletableFuture<>();

        context.runOnContext(event -> executorService.submit(() -> {
            // Preservando o contexto Vert.x dentro da thread virtual
            try {
                T result = task.call();
                future.complete(result);
            } catch (Exception e) {
                future.completeExceptionally(e);
            }
        }));

        return future;
    }

    @Override
    public Boolean completed() {
        return executorService.isShutdown() && executorService.isTerminated();
    }

    @PreDestroy
    public void shutdown() {

        executorService.shutdown();

    }

}
