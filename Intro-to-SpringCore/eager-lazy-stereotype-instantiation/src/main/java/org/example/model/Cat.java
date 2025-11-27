package org.example.model;

import org.springframework.stereotype.Component;


public class Cat extends Animal {

    public Cat(String name,String sound){
        super(name,sound);
        System.out.println("Cat is created");
    }


    @Override
    public String toString() {
        return "Cat: %s".formatted(this.getName());
    }
}
