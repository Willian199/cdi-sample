package br.com.will.events;

import io.quarkus.logging.Log;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class ServerEvent {

    void onStart(@Observes StartupEvent ev) {
        Log.info("O servidor foi iniciado com sucesso...");
    }

    void onStop(@Observes ShutdownEvent ev) {
        Log.info("O servidor será desativado...");
    }

}
