package br.com.will.events;

import br.com.will.record.EventoRecord;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

@ApplicationScoped
public class EventEmitter {

    @Inject
    Event<EventoRecord> event;

    public void sendEvent() {

        // event.fire(new EventoRecord(1L, "Evento de teste")); // Sincrono
        event.fireAsync(new EventoRecord(1L, "Evento de teste"))
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
