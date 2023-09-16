package br.com.will.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DecoratorService {

    public String name() {
        throw new UnsupportedOperationException("Unimplemented method 'log'");
    }
}
