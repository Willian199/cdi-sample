package br.com.will.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;

import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@IfBuildProfile("dev") // Somente existe em desenvolvimento
@Path("lookupPropertyController")
@RegisterForReflection
public interface LookupPropertyController {

    @Operation(description = "O @Inject será baseado na configuração presente no arquivo de properties.<br>Se na property definir um valor que não existe ou configurar dois beans que contemplam o mesmo valor, vai resultar em erro.")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getPais();

}
