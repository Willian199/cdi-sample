package br.com.will.controller.impl;

import br.com.will.controller.AlternativeController;
import br.com.will.service.VersaoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AlternativeControllerImpl implements AlternativeController {

    @Inject
    VersaoService versaoService;

    @Override
    public String versao() {
        return "Versão do projeto: " + versaoService.versao();
    }

}
