package br.com.will.controller.impl;

import br.com.will.controller.NamedController;
import br.com.will.service.NamedService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class NamedControllerImpl implements NamedController {

    @Inject
    @Named("namedClass")
    NamedService namedService;

    @Override
    public String get() {
        return namedService.get();
    }

}
