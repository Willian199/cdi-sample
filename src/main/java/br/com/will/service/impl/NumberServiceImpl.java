package br.com.will.service.impl;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import br.com.will.annotation.LogMe;
import br.com.will.service.NumberService;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;

@RequestScoped
@LogMe
public class NumberServiceImpl implements NumberService {

    AtomicLong nextLong = new AtomicLong();
    AtomicInteger nextInt = new AtomicInteger();

    @Dependent
    @Produces
    Integer produceInt() {
        return nextInt.incrementAndGet();
    }

    @Dependent
    @Produces
    Long produceLong() {
        return nextLong.incrementAndGet();
    }

}
