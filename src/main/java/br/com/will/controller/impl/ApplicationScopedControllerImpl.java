package br.com.will.controller.impl;

import br.com.will.controller.ApplicationScopedController;
import br.com.will.service.ApplicationScopedService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ApplicationScopedControllerImpl implements ApplicationScopedController {

    @Inject
    ApplicationScopedService applicationScopedService;

    @Override
    public String count() {
        return "Contador atual: " + applicationScopedService.getCount();
    }
}
