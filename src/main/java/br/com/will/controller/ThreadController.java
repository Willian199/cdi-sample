package br.com.will.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("threadController")
@RegisterForReflection
public interface ThreadController {

    @Operation(description = "Cria 100 Virtual Threads, que serão executadas em fila concorrente.")
    @GET
    @Path("runVirtual")
    @Produces(MediaType.TEXT_PLAIN)
    public String runVirtual();

    @Operation(description = "Cria 100 Platform Threads, que serão executadas em fila concorrente.")
    @GET
    @Path("runPlatform")
    @Produces(MediaType.TEXT_PLAIN)
    public String runPlatform();

}
