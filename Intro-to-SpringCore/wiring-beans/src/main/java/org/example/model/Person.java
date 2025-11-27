package org.example.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// We will define has-A relationship between Person and Parrot instances

public class Person {
    private String name;
    private Parrot parrot;
    private Cat cat;

    // the field based dependency injection is not good for practice it has some downgrades
    // For ex, unable to use final
    @Autowired
    private Dog dog;
    // we simply said the spring that ı want you to add dog bean from the Aplicaiton context

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot(){
        return parrot;
    }
    public void setParrot(Parrot parrot){
        this.parrot = parrot;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }


}
