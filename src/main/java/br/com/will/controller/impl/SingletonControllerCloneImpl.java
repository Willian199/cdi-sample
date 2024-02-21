package br.com.will.controller.impl;

import br.com.will.controller.SingletonControllerClone;
import br.com.will.service.SingletonService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class SingletonControllerCloneImpl implements SingletonControllerClone {

    @Inject
    SingletonService singletonService;

    @Override
    public String count() {
        return "Contador atual: " + singletonService.getCount();
    }

}
