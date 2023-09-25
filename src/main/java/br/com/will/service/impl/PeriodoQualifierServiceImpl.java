package br.com.will.service.impl;

import br.com.will.annotation.LogMe;
import br.com.will.literal.SelectorLiteral;
import br.com.will.service.PeriodoNomeadoService;
import br.com.will.service.PeriodoQualifierService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

@ApplicationScoped
@LogMe
public class PeriodoQualifierServiceImpl implements PeriodoQualifierService {

    @Any
    @Inject
    Instance<PeriodoNomeadoService> instances;

    @Override
    public String periodo(String periodo) {

        return instances.select(new SelectorLiteral(periodo)).get().periodo();
    }

}
