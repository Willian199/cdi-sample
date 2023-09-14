package br.com.will.service;

import io.quarkus.logging.Log;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApplicationScopedService {

    private Long count = 0L;

    @PostConstruct
    public void init() {
        Log.info("Inicinado o bean ApplicationScopedService");
        count++;
    }

    @PreDestroy
    public void destroy() {
        Log.info("Destruindo o bean ApplicationScopedService");
        count = 0L;
    }

    public Long getCount() {
        Log.infov("Contado atual: {0}", count);
        return count++;
    }

}
