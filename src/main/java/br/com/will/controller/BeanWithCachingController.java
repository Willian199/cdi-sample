package br.com.will.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;

import io.quarkus.arc.WithCaching;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Exemplo presente na documentação do Quarkus.
 * 
 */
@Path("beanWithCachingController")
public class BeanWithCachingController {

    @Inject
    @WithCaching
    Instance<Integer> integerInstance;

    @Inject
    Instance<Long> longInstance;

    @Operation(description = "Como o @Inject está annotado com @WithCaching, o resultado sempre será True. Pois será criada apenas uma instância.")
    @GET
    @Path("integer")
    @Produces(MediaType.TEXT_PLAIN)
    public Boolean pingInt() {
        return integerInstance.get().equals(integerInstance.get());
    }

    @Operation(description = "Por ser um @Inject normal, o resultado sempre será False. Pois sempre será criado uma instância nova.")
    @GET
    @Path("long")
    @Produces(MediaType.TEXT_PLAIN)
    public Boolean pingLong() {
        return longInstance.get().equals(longInstance.get());
    }

}
