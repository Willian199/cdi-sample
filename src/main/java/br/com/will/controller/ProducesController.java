package br.com.will.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("producesController")
@RegisterForReflection
public interface ProducesController {

    @Operation(description = "Anotando com Producer, o objeto será criado na primeira vez que for feito o Inject, ficando disponivel para demais acessos")

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String produce();
}
