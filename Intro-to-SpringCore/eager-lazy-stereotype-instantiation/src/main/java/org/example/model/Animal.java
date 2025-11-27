package org.example.model;

public abstract class Animal {
    private  String name;
    private String sound;

    public Animal(String name,String sound) {
        this.name = name;
        this.sound = sound;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  void makeSound(){
        System.out.println(sound);
    };
}
