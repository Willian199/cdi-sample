package br.com.will.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("singletonController")
@RegisterForReflection
public interface SingletonController {

    @Operation(description = "O contador de retorno do servico será incrementado em 1 toda vez que for chamado. A diferenca para ApplicationScoped consiste em que o ApplicationScoped é Thread safe."
            +
            "<br> Com Singleton é safe ler e escrever valores. Porém não possibilita usar QuarkusMock." +
            "<br> Como não possui um Client Proxy, tende a ter um desempenho levemente melhor comparado ao ApplicationScoped")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String count();

}
