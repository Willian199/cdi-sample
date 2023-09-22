package br.com.will.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;

import br.com.will.service.RequestScopedService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("requestScopedController")
public class RequestScopedController {

    @Inject
    RequestScopedService sequestScopedService;

    @Operation(description = "O contador de retorno do servico será sempre 1. Pois cria uma nova instância a cada requisicao")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String count() {
        return "Contador atual: " + sequestScopedService.getCount();
    }

}
