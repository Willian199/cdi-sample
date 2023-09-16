package br.com.will.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.ExampleObject;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import br.com.will.service.PeriodoService;
import br.com.will.service.PeriodoServiceMap;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("periodoController")
public class PeriodoController {

    @Inject
    PeriodoService periodoService;

    @Inject
    PeriodoServiceMap periodoServiceMap;

    @Operation(description = "Conforme o periodo passado será executado a regra referente. <br> Parâmetros aceitos: diario, semanal, mensal")
    @Parameter(name = "periodo", required = true, examples = { @ExampleObject(value = "diario, semanal, mensal") })
    @GET
    @Path("{periodo}")
    @Produces(MediaType.TEXT_PLAIN)
    public String periodo(String periodo) {
        return "O periodo selecionado é: " + periodoService.periodo(periodo);
    }

    @Operation(description = "Conforme o periodo passado será executado a regra referente. <br> Parâmetros aceitos: diario, semanal, mensal. <br> Utiliza um Map para identificar a Annotation desejada")
    @Parameter(name = "periodo", required = true, examples = { @ExampleObject(value = "diario, semanal, mensal") })
    @GET
    @Path("map/{periodo}")
    @Produces(MediaType.TEXT_PLAIN)
    public String periodoMap(String periodo) {
        return "O periodo selecionado é: " + periodoServiceMap.periodo(periodo);
    }

}
