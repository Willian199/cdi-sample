package br.com.will.service.impl;

import br.com.will.service.RequestScopedService;
import io.quarkus.logging.Log;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class RequestScopedServiceImpl implements RequestScopedService {

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

    @Override
    public Long getCount() {
        Log.infov("Contado atual: {0}", count);
        return count++;
    }
}
