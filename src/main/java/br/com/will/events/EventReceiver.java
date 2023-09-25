package br.com.will.events;

import br.com.will.record.EventoRecord;
import io.quarkus.logging.Log;
import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.ObservesAsync;

@ApplicationScoped
public class EventReceiver {

    @RunOnVirtualThread // Ainda não altera para Thread Virtual
    // void onEvent(@Observes EventoRecord task) { // Sincrono
    void onEvent(@ObservesAsync EventoRecord task) { // Assincrono
        Log.infov("Tipo Thread: {0} - Identificado o evento {0} - {1}", Thread.currentThread().getName(), task.id(),
                task.nome());

    }

}
