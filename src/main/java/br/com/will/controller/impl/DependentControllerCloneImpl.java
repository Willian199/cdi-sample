package br.com.will.controller.impl;

import br.com.will.controller.DependentControllerClone;
import br.com.will.service.DependentService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class DependentControllerCloneImpl implements DependentControllerClone {

    @Inject
    DependentService dependentService;

    @Override
    public String getRandom() {
        return "Valor gerado: " + dependentService.getRandom();
    }

}
