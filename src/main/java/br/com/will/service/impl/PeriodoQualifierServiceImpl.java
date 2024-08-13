package br.com.will.service.impl;

import br.com.will.annotation.LogMe;
import br.com.will.service.PeriodoNomeadoService;
import br.com.will.service.PeriodoQualifierService;
import io.quarkus.arc.Arc;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@LogMe
public class PeriodoQualifierServiceImpl implements PeriodoQualifierService {

    @Override
    public String periodo(String periodo) {

        PeriodoNomeadoService periodoNomeadoService = (PeriodoNomeadoService) Arc.container().instance(periodo).get();

        return periodoNomeadoService.periodo();
    }

}
