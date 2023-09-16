package br.com.will.regra.impl;

import br.com.will.regra.NomeRegra;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NomeRegraImpl implements NomeRegra {

    @Override
    public String nome() {
        return "Willian";
    }

}
