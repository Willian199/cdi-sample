package br.com.will.decorator;

import br.com.will.service.NomeService;
import jakarta.annotation.Priority;
import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.enterprise.inject.Any;
import jakarta.inject.Inject;

@Decorator
@Priority(jakarta.interceptor.Interceptor.Priority.APPLICATION)
public class NomeRegraDecorator implements NomeService {

    @Inject
    @Delegate
    @Any
    NomeService nomeRegra;

    @Override
    public String nome() {
        return nomeRegra.nome().toUpperCase();
    }

}