package br.com.will.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Exemplo presente na documentação do Quarkus.
 * 
 */
@Path("beanWithCachingController")
@RegisterForReflection
public interface BeanWithCachingController {

    @Operation(description = "Como o @Inject está annotado com @WithCaching, o resultado sempre será True. Pois será criada apenas uma instância.")
    @GET
    @Path("integer")
    @Produces(MediaType.TEXT_PLAIN)
    public Boolean pingInt();

    @Operation(description = "Por ser um @Inject normal, o resultado sempre será False. Pois sempre será criado uma instância nova.")
    @GET
    @Path("long")
    @Produces(MediaType.TEXT_PLAIN)
    public Boolean pingLong();

}
