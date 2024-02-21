package br.com.will.controller.impl;

import br.com.will.controller.RequestScopedController;
import br.com.will.service.RequestScopedService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RequestScopedControllerImpl implements RequestScopedController {

    @Inject
    RequestScopedService sequestScopedService;

    @Override
    public String count() {
        return "Contador atual: " + sequestScopedService.getCount();
    }

}
