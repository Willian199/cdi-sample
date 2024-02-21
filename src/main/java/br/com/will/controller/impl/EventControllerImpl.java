package br.com.will.controller.impl;

import br.com.will.controller.EventController;
import br.com.will.service.EventService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EventControllerImpl implements EventController {

    @Inject
    EventService eventService;

    @Override
    public String emitirEvento() {
        eventService.emitirEvento();
        return "O evento foi emitido";
    }

}
