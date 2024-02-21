package br.com.will.controller.impl;

import br.com.will.controller.LookupPropertyController;
import br.com.will.service.PaisService;
import io.quarkus.arc.profile.IfBuildProfile;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

@IfBuildProfile("dev") // Somente existe em desenvolvimento
@ApplicationScoped
public class LookupPropertyControllerImpl implements LookupPropertyController {

    @Inject
    Instance<PaisService> paisService;

    @Override
    public String getPais() {
        return paisService.get().getNome();
    }

}
