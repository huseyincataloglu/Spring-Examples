package org.example;

import org.example.config.ProjectConfig;
import org.example.model.Cat;
import org.example.model.Parrot;
import org.example.model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        System.out.println(context.getBean("cat"));
        System.out.println(context.containsBean("parrot")); // returns true but spring context doesnt have parrot bean
        // when the applicaiton context starts, all the beans with eager instantiation created and added applicaiton context immediately
        System.out.println(context.getBean("parrot")); // now the constructor of parrot class works and bean is added to context

    }
}