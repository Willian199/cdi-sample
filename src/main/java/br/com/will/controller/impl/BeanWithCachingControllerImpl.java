package br.com.will.controller.impl;

import br.com.will.controller.BeanWithCachingController;
import io.quarkus.arc.WithCaching;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

/**
 * Exemplo presente na documentação do Quarkus.
 * 
 */
@Dependent
public class BeanWithCachingControllerImpl implements BeanWithCachingController {

    @Inject
    @WithCaching
    Instance<Integer> integerInstance;

    @Inject
    Instance<Long> longInstance;

    @Override
    public Boolean pingInt() {
        return integerInstance.get().equals(integerInstance.get());
    }

    @Override
    public Boolean pingLong() {
        return longInstance.get().equals(longInstance.get());
    }

}
