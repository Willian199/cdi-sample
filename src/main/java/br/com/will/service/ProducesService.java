package br.com.will.service;

import br.com.will.record.SistemaRecord;
import io.quarkus.logging.Log;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;

@RequestScoped
public class ProducesService {

    @PostConstruct
    public void init() {
        Log.info("Inicinado o bean ProducesService");

    }

    @PreDestroy
    public void destroy() {
        Log.info("Destruindo o bean ProducesService");

    }

    /**
     * 
     * Como está sendo usado @Produces, será executado apenas uma vez, mesmo sendo
     * usado @RequestScoped
     * Pois o objetivo é instanciar o objeto, tornando um beacn que pode ser
     * injetado
     */
    @Produces
    SistemaRecord definirSistema() {

        return new SistemaRecord(System.getProperty("os.name"));
    }

}
