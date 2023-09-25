package br.com.will.service.impl;

import br.com.will.annotation.LogMe;
import br.com.will.service.PaisService;
import io.quarkus.arc.lookup.LookupIfProperty;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@LogMe
@LookupIfProperty(name = "custom.pais.nome", stringValue = "USA")
public class UnitedStatesService implements PaisService {

    @Override
    public String getNome() {
        return "The server is hosted in: United States of America";
    }

}
