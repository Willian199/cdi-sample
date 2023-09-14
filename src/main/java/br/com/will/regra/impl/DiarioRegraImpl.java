package br.com.will.regra.impl;

import br.com.will.annotation.Diario;
import br.com.will.regra.PeriodoRegra;
import jakarta.enterprise.context.ApplicationScoped;

@Diario
@ApplicationScoped
public class DiarioRegraImpl implements PeriodoRegra {

    @Override
    public String periodo() {
        return "Diario";
    }

}
