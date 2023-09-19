package br.com.will.service;

import br.com.will.record.SistemaRecord;

public abstract interface ProducesService {

    public abstract SistemaRecord definirSistema();

    public abstract void close(SistemaRecord sistemaRecord);

}
