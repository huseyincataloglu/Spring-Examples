package org.example.model;

public class Dog {
    private String name;

    public Dog(){
        System.out.println("Dog is created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog: %s".formatted(this.name);
    }
}
