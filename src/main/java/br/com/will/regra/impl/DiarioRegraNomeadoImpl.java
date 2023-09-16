package br.com.will.regra.impl;

import br.com.will.annotation.Selector;
import br.com.will.regra.PeriodoRegraNomeado;
import jakarta.enterprise.context.ApplicationScoped;

@Selector("diario")
@ApplicationScoped
public class DiarioRegraNomeadoImpl implements PeriodoRegraNomeado {

    @Override
    public String periodo() {
        return "Diario";
    }

}
