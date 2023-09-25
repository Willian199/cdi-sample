package br.com.will.service.impl;

import br.com.will.annotation.LogMe;
import br.com.will.annotation.Semanal;
import br.com.will.service.BasePeriodoService;
import jakarta.enterprise.context.ApplicationScoped;

@Semanal
@ApplicationScoped
@LogMe
public class SemanalRegraImpl implements BasePeriodoService {

    @Override
    public String periodo() {
        return "Semanal";
    }

}
