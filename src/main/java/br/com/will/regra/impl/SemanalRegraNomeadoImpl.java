package br.com.will.regra.impl;

import br.com.will.annotation.Selector;
import br.com.will.regra.PeriodoRegraNomeado;
import jakarta.enterprise.context.ApplicationScoped;

@Selector("semanal")
@ApplicationScoped
public class SemanalRegraNomeadoImpl implements PeriodoRegraNomeado {

    @Override
    public String periodo() {
        return "Semanal";
    }

}
