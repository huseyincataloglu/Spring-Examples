package org.example.config;


import org.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

// Configuration annotation indicates the class where to define the beans. In this class beans objects are defined and
// stored in Spring application context.
// Spring manages these objects
@Configuration
@ComponentScan(basePackages = "model")
public class ProjectConfig {

    //Spring add the object instance return from the bean annotated method. We have created the object inside the method
    //Remember : Bean gets its name with the method name which is parrot ib the example below.
    @Bean(name = "parrot1")
    public Parrot parrot1() {
        Parrot parrot = new Parrot();
        parrot.setName("Koko");
        return parrot;
    }

    @Bean(name = "parrot2")
    public Parrot parrot2() {
        Parrot parrot = new Parrot();
        parrot.setName("Maviş");
        return parrot;
    }

    @Bean(name = "cat1")
    public Cat cat1() {
        Cat cat = new Cat();
        cat.setName("Boncuk");
        return cat;
    }

    @Bean(name = "cat2")
    public Cat cat2() {
        Cat cat = new Cat();
        cat.setName("Duman");
        return cat;
    }


    // We have injected the dog bean into person object bean with autowired annotation
    // But to be able to do this , we have at least one Dog bean in our application context
    // we didnt use component, componentscan streotype annotation in this project so we have created dog object by hand
    @Bean
    public Dog dog(){
        Dog dog = new Dog();
        dog.setName("Karabas");
        return dog;
    }



    /*
      We exposes many ways of wiring beans this is also called DI (dependency injection)
      First we called bean method inside person because we have launced has a relation between person and parrot
      But spring didnt create a new bean object , it is smart to give the existing one

      Another way is passing the parameter
        We passed the cat to the person bean constructor.
        What spring understands is it should pass the existing cat bean to the person bean

     */
    //Setting bean names differently
    // This provied benefits when we initilaize multiple beans of SAME type

    // These people will pet the same dog but we have specified their cat and parrot beans with Qualifier annotiation and
    // different bean methods of parrot
    @Bean(name = "person1")
    public Person person(@Qualifier("cat1") Cat cat) {
        Person p = new Person();
        p.setName("Ella");
        p.setParrot(parrot1());
        p.setCat(cat);
        return p;
    }

    @Bean(name = "person2")
    public Person person2(@Qualifier("cat2") Cat cat){
        Person p = new Person();
        p.setName("Hüseyin");
        p.setParrot(parrot2());
        p.setCat(cat);
        return p;
    }
}
