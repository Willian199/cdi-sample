package br.com.will.service;

import br.com.will.annotation.Diario;
import br.com.will.annotation.Mensal;
import br.com.will.annotation.Semanal;
import br.com.will.regra.PeriodoRegra;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;

@ApplicationScoped
public class PeriodoService {

    @Inject
    @Diario
    PeriodoRegra periodoRegraDiario;

    @Inject
    @Semanal
    PeriodoRegra periodoRegraSemanal;

    @Inject
    @Mensal
    PeriodoRegra periodoRegraMensal;

    public String periodo(String periodo) {

        return switch (periodo) {
            case "diario" -> periodoRegraDiario.periodo();
            case "semanal" -> periodoRegraSemanal.periodo();
            case "mensal" -> periodoRegraMensal.periodo();
            default -> throw new BadRequestException();
        };

    }

}
