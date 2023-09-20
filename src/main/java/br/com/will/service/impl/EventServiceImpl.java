package br.com.will.service.impl;

import br.com.will.events.EventEmitter;
import br.com.will.service.EventService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EventServiceImpl implements EventService {

    @Inject
    EventEmitter eventEmitter;

    @Override
    public void emitirEvento() {
        eventEmitter.sendEvent();
    }

}
