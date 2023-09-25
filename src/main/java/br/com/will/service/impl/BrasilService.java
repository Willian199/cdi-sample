package br.com.will.service.impl;

import br.com.will.annotation.LogMe;
import br.com.will.service.PaisService;
import io.quarkus.arc.lookup.LookupIfProperty;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@LogMe
@LookupIfProperty(name = "custom.pais.nome", stringValue = "Brasil")
public class BrasilService implements PaisService {

    @Override
    public String getNome() {
        return "Pais do servidor é: Brasil";
    }

}
