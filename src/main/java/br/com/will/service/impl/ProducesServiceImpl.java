package br.com.will.service.impl;

import br.com.will.annotation.LogMe;
import br.com.will.record.SistemaRecord;
import br.com.will.service.ProducesService;
import io.quarkus.logging.Log;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;

@RequestScoped
@LogMe
public class ProducesServiceImpl implements ProducesService {

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
     * Pois o objetivo é instanciar o objeto, tornando um bean que pode ser
     * injetado
     */
    // @ApplicationScoped - Se for usar scopo, não pode ser record
    @Produces
    @Override
    public SistemaRecord definirSistema() {
        Log.info("Realizando o Produces do SistemaRecord");
        return new SistemaRecord(System.getProperty("os.name"));

    }

    /**
     * O @Dispose serve somente para descartar objetos que foram criados
     * com @Produces.
     */
    @Override
    public void close(@Disposes SistemaRecord sistemaRecord) {
        Log.info("Realizando o Dispose do SistemaRecord");

    }

}
