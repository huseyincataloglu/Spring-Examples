package org.example;

import org.example.config.ProjectConfig;
import org.example.model.Animal;
import org.example.model.Cat;
import org.example.model.Parrot;
import org.example.model.Person;
import org.example.proxy.EmailNotificationProxy;
import org.example.repository.DbAnimalStoreRepository;
import org.example.services.PurchaseAnimalService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = new Person("Huseyin");
        person.setAnimals(new ArrayList<Animal>(List.of(new Cat("Boncuk","Meow"),new Parrot("Kako","Bırra"))));

        PurchaseAnimalService purchaseAnimalService = context.getBean(PurchaseAnimalService.class);
    }
}