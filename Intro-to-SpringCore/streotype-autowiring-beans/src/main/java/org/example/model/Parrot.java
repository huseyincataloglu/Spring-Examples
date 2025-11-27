package org.example.model;

import org.springframework.stereotype.Component;

@Component
public class Parrot {
    private String name;


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
