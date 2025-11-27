package org.example.model;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;



public class Parrot {
    private String name;

    public Parrot(){
        System.out.println("Parrot is created");
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return "Parrot: %s".formatted(this.name);
    }
}
