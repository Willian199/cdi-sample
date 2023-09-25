package br.com.will.service.impl;

import br.com.will.annotation.Diario;
import br.com.will.annotation.LogMe;
import br.com.will.service.BasePeriodoService;
import jakarta.enterprise.context.ApplicationScoped;

@Diario
@LogMe
@ApplicationScoped
public class DiarioRegraImpl implements BasePeriodoService {

    @Override
    public String periodo() {
        return "Diario";
    }

}
