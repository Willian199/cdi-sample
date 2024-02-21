package br.com.will.controller.impl;

import br.com.will.controller.DecoratorController;
import br.com.will.service.NomeService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DecoratorControllerImpl implements DecoratorController {

    @Inject
    NomeService nomeService;

    @Override
    public String produce() {
        return "Desenvolvido por: " + nomeService.nome();
    }

}
