package br.com.will.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("namedController")
@RegisterForReflection
public interface NamedController {

    @Operation(description = "Permite adicionar um nome ao Bean selecionado. Pode ser usado como um @Qualifier")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get();

}
