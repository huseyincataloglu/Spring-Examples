package org.example.services;


import org.example.model.Animal;
import org.example.model.Person;
import org.example.proxy.AnimalStoreProxy;
import org.example.repository.AnimalStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class PurchaseAnimalService {


    private final AnimalStoreProxy animalStoreProxy;
    private final AnimalStoreRepository animalStoreRepository;

    @Autowired
    public PurchaseAnimalService(
            AnimalStoreRepository animalStoreRepository,
            AnimalStoreProxy animalStoreProxy
    ){
        this.animalStoreProxy = animalStoreProxy;
        this.animalStoreRepository = animalStoreRepository;
        System.out.println("Services is created");
    }

    // Defining use case
    public void purchaseAnimal(Person person){
        animalStoreRepository.getAnimalsAndUpdate(person.getAnimals());
        animalStoreProxy.sendPurchaseNotification(person.getAnimals().toString());
    }
}
