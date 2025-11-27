package org.example.model;

import org.springframework.stereotype.Component;

@Component
public class Hamster {
    private String name;

    public Hamster(){
        System.out.println("Hamster is created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hamster: %s".formatted(this.name);
    }
}
