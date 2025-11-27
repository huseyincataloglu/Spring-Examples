package org.example.config;


import org.example.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

// Configuration annotation indicates the class where to define the beans. In this class beans objects are defined and
// stored in Spring application context.
// Spring manages these objects
@Configuration
public class ProjectConfig {
    //Eager instantiation of bean
    // Spring will instantiate the cat instance and wrap it with bean when it loads its context
    // It doest not require us to use that bean in order to instantiate it.
    @Bean
    Cat cat(){
        Cat cat = new Cat();
        cat.setName("Boncuk");
        return cat;
    }

    //Lazy annotation states the spring that you should always create the bean of parrot class only when it is required.
    @Bean
    @Lazy
    Parrot parrot(){
        Parrot parrot = new Parrot();
        parrot.setName("Pam");
        return parrot;
    }

//    @Bean
//    Person person(Parrot parrot){
//        Person person =  new Person();
//        person.setCat(cat());
//        person.setParrot(parrot);
//        return person;
//    }

}
