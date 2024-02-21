package br.com.will.controller.impl;

import br.com.will.controller.PeriodoQualifierController;
import br.com.will.service.PeriodoQualifierService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.constraints.NotBlank;

@ApplicationScoped
public class PeriodoQualifierControllerImpl implements PeriodoQualifierController {

    @Inject
    PeriodoQualifierService periodoQualifierService;

    @Override
    public String periodo(@NotBlank String periodo) {
        return "O periodo selecionado é: " + periodoQualifierService.periodo(periodo);
    }

}
