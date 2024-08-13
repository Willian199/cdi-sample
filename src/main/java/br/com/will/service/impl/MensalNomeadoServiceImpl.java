package br.com.will.service.impl;

import br.com.will.annotation.LogMe;
import br.com.will.service.PeriodoNomeadoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named("mensal")
@ApplicationScoped
@LogMe
public class MensalNomeadoServiceImpl implements PeriodoNomeadoService {

    @Override
    public String periodo() {
        return "Mensal";
    }

}
