package br.com.will.service.impl;

import br.com.will.annotation.LogMe;
import br.com.will.annotation.Mensal;
import br.com.will.service.BasePeriodoService;
import jakarta.enterprise.context.ApplicationScoped;

@Mensal
@ApplicationScoped
@LogMe
public class MensalRegraImpl implements BasePeriodoService {

    @Override
    public String periodo() {
        return "Mensal";
    }

}
