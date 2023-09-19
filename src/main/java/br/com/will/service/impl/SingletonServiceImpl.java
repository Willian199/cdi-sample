package br.com.will.service.impl;

import br.com.will.service.SingletonService;
import io.quarkus.logging.Log;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Singleton;

@Singleton
public class SingletonServiceImpl implements SingletonService {

    private Long count = 0L;

    @PostConstruct
    public void init() {
        Log.info("Inicinado o bean SingletonService");
        count++;
    }

    @PreDestroy
    public void destroy() {
        Log.info("Destruindo o bean SingletonService");
        count = 0L;
    }

    /**
     * Com Singleton é safe ler e escrever valores
     * 
     */
    @Override
    public Long getCount() {
        Log.infov("Contado atual: {0}", count);
        return count++;
    }

}
