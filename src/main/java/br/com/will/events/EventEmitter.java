package br.com.will.events;

import java.util.concurrent.ExecutorService;

import br.com.will.record.EventoRecord;
import io.quarkus.logging.Log;
import io.quarkus.virtual.threads.VirtualThreads;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.enterprise.event.NotificationOptions;
import jakarta.inject.Inject;

@ApplicationScoped
public class EventEmitter {

    @Inject
    Event<EventoRecord> event;

    @Inject
    @VirtualThreads
    ExecutorService executorService;

    public void sendEvent() {
        Log.infov("Tipo Thread: {0}", Thread.currentThread().getName());
        // event.fire(new EventoRecord(1L, "Evento de teste")); // Sincrono
        event.fireAsync(new EventoRecord(1L, "Evento de teste"), NotificationOptions.ofExecutor(executorService))
                // Adiciona callbacks para capturar o status da execução
                .handle((sucesso, erro) -> {
                    if (sucesso != null) {
                        return sucesso;
                    } else {
                        for (Throwable t : erro.getSuppressed()) {
                            Log.info(t.getMessage());
                        }

                        return null;
                    }
                });// Assincrono
    }

}
