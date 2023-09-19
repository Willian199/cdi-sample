package br.com.will.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.ExampleObject;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import br.com.will.service.VersaoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("alternativeController")
public class AlternativeController {

    @Inject
    VersaoService versaoService;

    @Operation(description = "Ao usar Alternative permite modificar o comportamento de uma classe original. <br> Sendo útil quando deseja alterar funcionalidades específicas de uma classe que pertence a alguma biblioteca de terceiros.")
    @Parameter(name = "periodo", required = true, examples = { @ExampleObject(value = "diario, semanal, mensal") })
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String versao() {
        return "Versão do projeto: " + versaoService.versao();
    }

}
