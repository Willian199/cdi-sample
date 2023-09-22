package br.com.will.service.impl;

import java.util.Random;

import br.com.will.service.DependentService;
import io.quarkus.logging.Log;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.Dependent;

@Dependent
public class DependentServiceImpl implements DependentService {

    private Integer value;

    @PostConstruct
    public void init() {
        Random rand = new Random();
        value = rand.nextInt(25);
        Log.info("Inicinado o bean DependentService");

    }

    @PreDestroy
    public void destroy() {
        Log.info("Destruindo o bean DependentService");

    }

    @Override
    public Integer getRandom() {

        return value;
    }

}
