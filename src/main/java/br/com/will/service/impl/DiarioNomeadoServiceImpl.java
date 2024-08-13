package br.com.will.service.impl;

import br.com.will.annotation.LogMe;
import br.com.will.service.PeriodoNomeadoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named("diario")
@LogMe
@ApplicationScoped
public class DiarioNomeadoServiceImpl implements PeriodoNomeadoService {

    @Override
    public String periodo() {
        return "Diario";
    }

}
