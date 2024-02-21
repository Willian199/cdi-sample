package br.com.will.controller.impl;

import br.com.will.controller.SingletonController;
import br.com.will.service.SingletonService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class SingletonControllerImpl implements SingletonController {

    @Inject
    SingletonService singletonService;

    @Override
    public String count() {
        return "Contador atual: " + singletonService.getCount();
    }

}
