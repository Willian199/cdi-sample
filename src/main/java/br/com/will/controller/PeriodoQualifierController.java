package br.com.will.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.ExampleObject;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.validation.constraints.NotBlank;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("periodoQualifierController")
@RegisterForReflection
public interface PeriodoQualifierController {

    @Operation(description = "Conforme o periodo passado será executado a regra referente. <br> Parâmetros aceitos: diario, semanal, mensal. <br> Possibilita anotar cada classe com um nome (Qualifier) identificar através de parametros")
    @Parameter(name = "periodo", required = true, examples = { @ExampleObject(value = "diario, semanal, mensal") })
    @GET
    @Path("{periodo}")
    @Produces(MediaType.TEXT_PLAIN)
    public String periodo(@NotBlank String periodo);

}
