package org.example.repository;

import org.example.model.Animal;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Lazy
public class DbAnimalStoreRepository implements AnimalStoreRepository{

    public DbAnimalStoreRepository(){
        System.out.println("DbAnimalStoreRepository is created");
    }
    @Override
    public void getAnimalsAndUpdate(List<Animal> animals) {
        System.out.println("%s are supplied by storage and status updated".formatted(animals));
    }
}
