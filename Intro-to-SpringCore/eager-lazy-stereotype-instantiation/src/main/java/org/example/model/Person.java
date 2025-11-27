package org.example.model;




import java.util.ArrayList;
import java.util.List;


public class Person {

    private String name;
    public Person(String name){
        this.name = name;
    }
    private List<Animal> animals = new ArrayList<>();

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void petAnimal(Animal animal){
        animals.add(animal);
    }

    @Override
    public String toString() {
        return "%s has %d amount of animals".formatted(name,animals.size());
    }
}
