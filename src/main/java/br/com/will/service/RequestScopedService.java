package br.com.will.service;

import io.quarkus.logging.Log;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class RequestScopedService {

     private Long count = 0L;

    @PostConstruct
    public void init() {
        Log.info("Inicinado o bean RequestScopedService");
        count++;
    }

    @PreDestroy
    public void destroy() {
        Log.info("Destruindo o bean RequestScopedService");
        count = 0L;
    }

    public Long getCount() {
        Log.infov("Contado atual: {0}", count);
        return count++;
    }
}
