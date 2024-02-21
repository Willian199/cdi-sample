package br.com.will.controller.impl;

import br.com.will.controller.PeriodoController;
import br.com.will.service.PeriodoMapService;
import br.com.will.service.PeriodoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.constraints.NotBlank;

@ApplicationScoped
public class PeriodoControllerImpl implements PeriodoController {

    @Inject
    PeriodoService periodoService;

    @Inject
    PeriodoMapService periodoServiceMap;

    @Override
    public String periodo(@NotBlank String periodo) {
        return "O periodo selecionado é: " + periodoService.periodo(periodo);
    }

    @Override
    public String periodoMap(@NotBlank String periodo) {
        return "O periodo selecionado é: " + periodoServiceMap.periodo(periodo);
    }

}
