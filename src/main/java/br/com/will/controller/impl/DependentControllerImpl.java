package br.com.will.controller.impl;

import br.com.will.controller.DependentController;
import br.com.will.service.DependentService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class DependentControllerImpl implements DependentController {

    @Inject
    DependentService dependentService;

    @Override
    public String getRandom() {
        return "Valor gerado: " + dependentService.getRandom();
    }

}
