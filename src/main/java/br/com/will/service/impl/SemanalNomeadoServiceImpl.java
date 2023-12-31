package br.com.will.service.impl;

import br.com.will.annotation.LogMe;
import br.com.will.annotation.Selector;
import br.com.will.service.PeriodoNomeadoService;
import jakarta.enterprise.context.ApplicationScoped;

@Selector("semanal")
@ApplicationScoped
@LogMe
public class SemanalNomeadoServiceImpl implements PeriodoNomeadoService {

    @Override
    public String periodo() {
        return "Semanal";
    }

}
