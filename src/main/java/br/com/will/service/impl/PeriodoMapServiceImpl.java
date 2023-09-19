package br.com.will.service.impl;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

import br.com.will.annotation.Diario;
import br.com.will.annotation.Mensal;
import br.com.will.annotation.Semanal;
import br.com.will.service.BasePeriodoService;
import br.com.will.service.PeriodoMapService;
import io.quarkus.runtime.util.StringUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.util.AnnotationLiteral;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;

@ApplicationScoped
public class PeriodoMapServiceImpl implements PeriodoMapService{

    @Inject
    @Any
    private Instance<BasePeriodoService> anyPeriodoProcessor;

    private static final Map<String, Class<? extends Annotation>> QUALIFIER_MAP = new HashMap<>();

    static {
        QUALIFIER_MAP.put("diario", Diario.class);
        QUALIFIER_MAP.put("semanal", Semanal.class);
        QUALIFIER_MAP.put("mensal", Mensal.class);
    }

    @Override
    public String periodo(String periodo) {

        if (StringUtil.isNullOrEmpty(periodo)) {
            throw new BadRequestException();
        }
        Class<? extends Annotation> qualifierAnnotationClass = QUALIFIER_MAP.get(periodo);

        if (qualifierAnnotationClass == null) {
            throw new BadRequestException();
        }

        Annotation qualifierAnnotation = new AnnotationLiteral<Annotation>() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return qualifierAnnotationClass;
            }
        };

        return anyPeriodoProcessor.select(qualifierAnnotation).get().periodo();
    }

}
