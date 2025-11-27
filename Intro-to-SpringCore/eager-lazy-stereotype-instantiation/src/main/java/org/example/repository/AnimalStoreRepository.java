package org.example.repository;

import org.example.model.Animal;

import java.util.List;

public interface AnimalStoreRepository {
    void getAnimalsAndUpdate(List<Animal> animals);
}
