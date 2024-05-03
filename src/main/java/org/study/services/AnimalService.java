package org.study.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import org.study.exceptions.NotFoundException;
import org.study.model.animals.Animal;
import org.study.model.animals.Cat;
import org.study.model.animals.Dog;
import org.study.model.animals.Puppy;
import org.study.model.Vaccine;


public class AnimalService {

    private List<Animal> animalList ;

    public AnimalService() {

        this.animalList = new ArrayList<>();

    }

    public List<Animal> getAnimals() {
        return new ArrayList<>(animalList);
    }

    public void loadAnimals(List<Animal> animals) {
        animalList.addAll(animals);
    }

    public Map<String, Animal> getAnimalsById() {
        return animalList.stream()
            .collect(Collectors.toMap(animal -> animal.getId().toString(),
                animal -> animal));
    }

    public List<Animal> getCats() {
        List<Animal> cats = new ArrayList<>();
        for (Animal animal : animalList) {
            if (animal instanceof Cat) {
                cats.add(animal);
            }
        }
        return cats;
    }
}
