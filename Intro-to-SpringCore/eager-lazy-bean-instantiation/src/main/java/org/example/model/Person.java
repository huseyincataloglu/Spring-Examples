package org.example.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// We will define has-A relationship between Person and other types


public class Person {
    private String name;

    private Parrot parrot;

    private Cat cat;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot(){
        return parrot;
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }




}
