package br.com.will.controller.impl;

import br.com.will.controller.ApplicationScopedControllerClone;
import br.com.will.service.ApplicationScopedService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ApplicationScopedControllerCloneImpl implements ApplicationScopedControllerClone {

    @Inject
    ApplicationScopedService applicationScopedService;

    @Override
    public String count() {
        return "Contador atual: " + applicationScopedService.getCount();
    }
}
