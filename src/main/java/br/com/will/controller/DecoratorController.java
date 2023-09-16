package br.com.will.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.ExampleObject;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import br.com.will.regra.NomeRegra;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("decoratorController")
public class DecoratorController {

    @Inject
    NomeRegra nomeRegra;

    @Operation(description = "O Decorator permite estender ou modificar o comportamento de uma classe original. <br> Sendo útil quando deseja adicionar funcionalidades específicas a uma classe que pertence a alguma biblioteca de terceiros. Podendo adicionar regras ntes ou após a execução.")
    @Parameter(name = "periodo", required = true, examples = { @ExampleObject(value = "diario, semanal, mensal") })
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String produce() {
        return "Desenvolvido por: " + nomeRegra.nome();
    }

}
