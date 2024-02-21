package br.com.will.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("applicationScopedControllerClone")
@RegisterForReflection
public interface ApplicationScopedControllerClone {

    @Operation(description = "O contador de retorno do servico será incrementado em 1 toda vez que for chamado. A diferenca para Singleton consiste em que o ApplicationScoped é Thread safe.")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String count();
}
