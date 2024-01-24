package br.com.will.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;

import br.com.will.service.EventService;
import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("eventController")
public class EventController {

    @Inject
    EventService eventService;

    @Operation(description = "Emite um evento que vai disparar um log em outra classe que está configurada para observar o evento definido. Necessário fazer Inject do ExecutorService no emissor para permitir utilizar Virtual Threads.")
    @RunOnVirtualThread
    @GET
    @Path("emitirEvento")
    @Produces(MediaType.TEXT_PLAIN)
    public String emitirEvento() {
        eventService.emitirEvento();
        return "O evento foi emitido";
    }

}
