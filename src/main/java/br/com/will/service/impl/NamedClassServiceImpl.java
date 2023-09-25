package br.com.will.service.impl;

import br.com.will.annotation.LogMe;
import br.com.will.service.NamedService;
import io.quarkus.logging.Log;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named("namedClass")
@ApplicationScoped
@LogMe
public class NamedClassServiceImpl implements NamedService {

    @PostConstruct
    public void init() {
        Log.info("Inicinado o bean NamedClass");

    }

    @PreDestroy
    public void destroy() {
        Log.info("Destruindo o bean NamedClass");

    }

    @Override
    public String get() {
        return "Yo " + Thread.currentThread().getName();
    }

}
