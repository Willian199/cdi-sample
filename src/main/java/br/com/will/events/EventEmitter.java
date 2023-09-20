package br.com.will.events;

import br.com.will.record.EventoRecord;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

@ApplicationScoped
public class EventEmitter {

    @Inject
    Event<EventoRecord> event;

    public void sendEvent() {

        // event.fire(new EventoRecord(1L, "Evento de teste")); // Sincrono
        event.fireAsync(new EventoRecord(1L, "Evento de teste")); // Assincrono
    }

}
