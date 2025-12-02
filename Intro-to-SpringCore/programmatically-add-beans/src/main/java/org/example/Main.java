package org.example;

import org.example.config.ProjectConfig;
import org.example.model.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        // we can create beans in context which is created by configuration class
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot parrot = new Parrot("Miki");

        Supplier<Parrot> parrotSupplier = () -> parrot;

        context.registerBean("parrot1",Parrot.class,parrotSupplier,bc -> bc.setPrimary(true));

        System.out.println(context.getBean("parrot1",Parrot.class).getName());

    }
}