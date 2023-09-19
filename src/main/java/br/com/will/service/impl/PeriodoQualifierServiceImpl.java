package br.com.will.service.impl;

import br.com.will.literal.SelectorLiteral;
import br.com.will.service.PeriodoNomeadoService;
import br.com.will.service.PeriodoQualifierService;
import io.quarkus.runtime.util.StringUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;

@ApplicationScoped
public class PeriodoQualifierServiceImpl implements PeriodoQualifierService {

    @Any
    @Inject
    Instance<PeriodoNomeadoService> instances;

    @Override
    public String periodo(String periodo) {
        if (StringUtil.isNullOrEmpty(periodo)) {
            throw new BadRequestException();
        }

        return instances.select(new SelectorLiteral(periodo)).get().periodo();
    }

}
