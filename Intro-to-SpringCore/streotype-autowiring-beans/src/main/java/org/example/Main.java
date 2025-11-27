package org.example;

import org.example.config.ProjectConfig;
import org.example.model.Cat;
import org.example.model.Parrot;
import org.example.model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot parrot = context.getBean(Parrot.class);

        Person person = context.getBean(Person.class);

//        Cat cat = context.getBean(Cat.class);

        System.out.println(
                "Person's name: " + person.getName());
        System.out.println(
                "Parrot's name: " + parrot.getName());

        System.out.println(
                "Person's parrot: " + person.getParrot()
        );

//        System.out.println(cat);

        System.out.println("Person's cat: "+ person.getCat());
        System.out.println("Person's dog: "+ person.getDog());
        System.out.println("Person's hamster: " + person.getHamster());

    }
}