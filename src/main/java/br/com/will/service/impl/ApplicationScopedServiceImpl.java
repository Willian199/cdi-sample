package br.com.will.service.impl;

import br.com.will.service.ApplicationScopedService;
import io.quarkus.logging.Log;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApplicationScopedServiceImpl implements ApplicationScopedService {

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

    /**
     * Por mais que nesse caso funcione, nunca deve ser lido ou escrito um valor
     * usando ApplicationScoped, pois pode estar obsoleto.
     * Somente use com Singleton.
     * 
     */
    @Override
    public Long getCount() {
        Log.infov("Contado atual: {0}", count);
        return count++;
    }

}
