package org.example.model;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


public class Parrot extends Animal{

    public Parrot(String name,String sound){
        super(name,sound);
        System.out.println("Parrot is created");
    }


    @Override
    public String toString() {
        return "Parrot: %s".formatted(this.getName());
    }
}
