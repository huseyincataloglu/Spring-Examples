package org.example.annotations;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// Retention and Target are Java's standart annotations.

@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.METHOD)
public @interface ToLog {

}


