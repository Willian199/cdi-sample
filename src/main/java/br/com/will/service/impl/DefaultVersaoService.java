package br.com.will.service.impl;

import br.com.will.service.VersaoService;
import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative
@Priority(jakarta.interceptor.Interceptor.Priority.APPLICATION)
public class DefaultVersaoService implements VersaoService {

    @Override
    public String versao() {
        return "1.00.00";
    }

}
