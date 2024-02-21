package br.com.will.rest;

import java.lang.reflect.Method;

import org.jboss.resteasy.reactive.server.ServerRequestFilter;

import br.com.will.annotation.Validar;
import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.container.ResourceInfo;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

@Provider
public class RestValidator {

    @Context
    ResourceInfo resourceInfo;

    @ServerRequestFilter()
    public Uni<Response> filter() {

        try {
            Method method = resourceInfo.getResourceMethod();

            // Obtém todas as interfaces implementadas pela classe do recurso
            Class<?>[] interfaces = method.getDeclaringClass().getInterfaces();

            Method interfaceMethod = interfaces[0].getMethod(method.getName(), method.getParameterTypes());

            if (interfaceMethod.isAnnotationPresent(Validar.class)) {
                Log.info("Possui annotation Validar");

            }
        } catch (NoSuchMethodException | SecurityException e) {

            e.printStackTrace();
        }

        return Uni.createFrom().nullItem();

    }
}
