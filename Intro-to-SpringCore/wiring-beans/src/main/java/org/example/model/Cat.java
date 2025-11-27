package org.example.model;

public class Cat {
    private String name;

    public Cat(){
        System.out.println("Cat is created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat: %s".formatted(this.name);
    }
}
