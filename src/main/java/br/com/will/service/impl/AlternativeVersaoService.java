package br.com.will.service.impl;

import br.com.will.annotation.LogMe;
import br.com.will.service.VersaoService;
import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;


@ApplicationScoped
@Alternative
@LogMe
//@Priority(jakarta.interceptor.Interceptor.Priority.LIBRARY_BEFORE)    // Ao comentar essa linha, retorna o valor dessa classe: 2.00.00
@Priority(jakarta.interceptor.Interceptor.Priority.LIBRARY_AFTER)       // Ao comentar essa linha, retorna o valor Default: 1.00.00
public class AlternativeVersaoService implements VersaoService {

    @Override
    public String versao() {
        return "2.00.00";
    }

}
