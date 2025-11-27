package org.example;

import org.example.config.ProjectConfig;
import org.example.model.Cat;
import org.example.model.Parrot;
import org.example.model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = context.getBean("person1",Person.class);
        Person person2 = context.getBean("person2",Person.class);

        System.out.println(
                "Person's name: " + person.getName());
        System.out.println(
                "Person's parrot: " + person.getParrot()
        );

        System.out.println("Person's cat: "+ person.getCat());
        System.out.println("Person's dog: "+ person.getDog());

        System.out.println("--------------------------------");
        System.out.println(
                "Person's name: " + person2.getName());
        System.out.println(
                "Person's parrot: " + person2.getParrot()
        );

        System.out.println("Person's cat: "+ person2.getCat());
        System.out.println("Person's dog: "+ person2.getDog());

    }
}