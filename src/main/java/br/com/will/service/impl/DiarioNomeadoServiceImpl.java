package br.com.will.service.impl;

import br.com.will.annotation.Selector;
import br.com.will.service.PeriodoNomeadoService;
import jakarta.enterprise.context.ApplicationScoped;

@Selector("diario")
@ApplicationScoped
public class DiarioNomeadoServiceImpl implements PeriodoNomeadoService {

    @Override
    public String periodo() {
        return "Diario";
    }

}
