package br.com.will.regra.impl;

import br.com.will.annotation.Semanal;
import br.com.will.regra.PeriodoRegra;
import jakarta.enterprise.context.ApplicationScoped;

@Semanal
@ApplicationScoped
public class SemanalRegraImpl implements PeriodoRegra {

    @Override
    public String periodo() {
        return "Semanal";
    }

}
