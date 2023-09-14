package br.com.will.service;

import br.com.will.annotation.Diario;
import br.com.will.annotation.Mensal;
import br.com.will.annotation.Semanal;
import br.com.will.regra.PeriodoRegra;
import io.quarkus.runtime.util.StringUtil;
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
        if (StringUtil.isNullOrEmpty(periodo)) {
            throw new BadRequestException();
        }

        switch (periodo) {
            case "diario":
                return periodoRegraDiario.periodo();
            case "semanal":
                return periodoRegraSemanal.periodo();
            case "mensal":
                return periodoRegraDiario.periodo();

            default:
                throw new BadRequestException();
        }

    }

}
