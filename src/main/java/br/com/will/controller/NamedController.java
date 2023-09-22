package br.com.will.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;

import br.com.will.service.NamedService;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("namedController")
public class NamedController {

    @Inject
    @Named("namedClass")
    NamedService namedService;

    @Operation(description = "Permite adicionar um nome ao Bean selecionado. Pode ser usado como um @Qualifier")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return namedService.get();
    }

}
