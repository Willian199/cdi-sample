package br.com.will.controller.impl;

import br.com.will.controller.ThreadController;
import br.com.will.service.ThreadService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ThreadControllerImpl implements ThreadController {

    @Inject
    ThreadService threadService;

    @Override
    public String runVirtual() {
        return threadService.run("virtual");
    }

    @Override
    public String runPlatform() {
        return threadService.run("");
    }

}
