package br.com.will.events;

import br.com.will.record.EventoRecord;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.ObservesAsync;

@ApplicationScoped
public class EventReceiver {

    // void onEvent(@Observes EventoRecord task) { // Sincrono
    void onEvent(@ObservesAsync EventoRecord task) { // Assincrono

        Log.infov("Identificado o evento {0} - {1}", task.id(), task.nome());

    }

}
