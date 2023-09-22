package br.com.will.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;

import br.com.will.service.DependentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("dependentController")
public class DependentController {

    @Inject
    DependentService dependentService;

    @Operation(description = "Permite adicionar um nome ao Bean selecionado. Pode ser usado como um @Qualifier")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getRandom() {
        return "Valor gerado: " + dependentService.getRandom();
    }

}
