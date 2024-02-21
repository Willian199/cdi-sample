package br.com.will.controller.impl;

import br.com.will.controller.ProducesController;
import br.com.will.record.SistemaRecord;
import jakarta.inject.Inject;

public class ProducesControllermpl implements ProducesController {

    @Inject
    SistemaRecord sistemaRecord;

    @Override
    public String produce() {
        return "O sistema operacional é: " + sistemaRecord.sistema();
    }
}
