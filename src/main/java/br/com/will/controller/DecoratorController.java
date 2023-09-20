package br.com.will.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;

import br.com.will.service.NomeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("decoratorController")
public class DecoratorController {

    @Inject
    NomeService nomeService;

    @Operation(description = "O Decorator permite estender ou modificar o comportamento de uma classe original. <br> Sendo útil quando deseja adicionar funcionalidades específicas a uma classe que pertence a alguma biblioteca de terceiros. Podendo adicionar regras antes ou após a execução.")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String produce() {
        return "Desenvolvido por: " + nomeService.nome();
    }

}
