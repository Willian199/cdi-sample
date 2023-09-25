package br.com.will.service.impl;

import br.com.will.annotation.Diario;
import br.com.will.annotation.LogMe;
import br.com.will.annotation.Mensal;
import br.com.will.annotation.Semanal;
import br.com.will.service.BasePeriodoService;
import br.com.will.service.PeriodoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;

@ApplicationScoped
@LogMe
public class PeriodoServiceImpl implements PeriodoService {

    @Inject
    @Diario
    BasePeriodoService periodoRegraDiario;

    @Inject
    @Semanal
    BasePeriodoService periodoRegraSemanal;

    @Inject
    @Mensal
    BasePeriodoService periodoRegraMensal;

    @Override
    public String periodo(String periodo) {

        return switch (periodo) {
            case "diario" -> periodoRegraDiario.periodo();
            case "semanal" -> periodoRegraSemanal.periodo();
            case "mensal" -> periodoRegraMensal.periodo();
            default -> throw new BadRequestException();
        };

    }

}
