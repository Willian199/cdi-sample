package br.com.will.annotation;

import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.inject.Qualifier;

@Target({TYPE_USE })
@Retention(RUNTIME)
@Qualifier
public @interface Selector {
    String value();

}
