package br.com.will.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.ExampleObject;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import br.com.will.record.SistemaRecord;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("producesController")
public class ProducesController {

    @Inject
    SistemaRecord sistemaRecord;

    @Operation(description = "Anotando com Producer, o objeto será criado na primeira vez que for feito o Inject, ficando disponivel para demais acessos")
    @Parameter(name = "periodo", required = true, examples = { @ExampleObject(value = "diario, semanal, mensal") })
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String produce() {
        return "O sistema operacional é: " + sistemaRecord.sistema();
    }

}
