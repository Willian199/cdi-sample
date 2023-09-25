package br.com.will.service.impl;

import br.com.will.annotation.LogMe;
import br.com.will.service.NamedService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Vetoed;
import jakarta.inject.Named;

/**
 * @Vetoed Ignora essa classe como sendo um Bean, se tentar fazer o Inject dessa
 *         classe, resultará em erro.
 *         Para teste, no NamedController editar o valor de @Named
 */
@Vetoed
@Named("named")
@ApplicationScoped
@LogMe
public class NamedServiceImpl implements NamedService {

    @Override
    public String get() {
        return "Hey " + Thread.currentThread().getName();
    }

}
