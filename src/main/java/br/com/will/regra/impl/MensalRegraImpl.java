package br.com.will.regra.impl;

import br.com.will.annotation.Mensal;
import br.com.will.regra.PeriodoRegra;
import jakarta.enterprise.context.ApplicationScoped;

@Mensal
@ApplicationScoped
public class MensalRegraImpl implements PeriodoRegra {

    @Override
    public String periodo() {
        return "Mensal";
    }

}
