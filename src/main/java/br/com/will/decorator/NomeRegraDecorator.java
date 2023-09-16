package br.com.will.decorator;

import br.com.will.regra.NomeRegra;
import jakarta.annotation.Priority;
import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.enterprise.inject.Any;
import jakarta.inject.Inject;

@Decorator
@Priority(jakarta.interceptor.Interceptor.Priority.APPLICATION)
public class NomeRegraDecorator implements NomeRegra {

    @Inject
    @Delegate
    @Any
    NomeRegra nomeRegra;

    @Override
    public String nome() {
        return nomeRegra.nome().toUpperCase();
    }

}