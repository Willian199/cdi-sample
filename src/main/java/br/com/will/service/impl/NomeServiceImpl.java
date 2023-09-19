package br.com.will.service.impl;

import br.com.will.service.NomeService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NomeServiceImpl implements NomeService {

    @Override
    public String nome() {
        return "Willian";
    }

}
