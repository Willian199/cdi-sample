package br.com.will.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("dependentControllerClone")
@RegisterForReflection
public interface DependentControllerClone {

    @Operation(description = "Para cada @Inject de uma classe @Dependent, será criado uma nova instância dela. Cuidado com leak de memória.")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getRandom();

}
