package org.study.model.animals;

import org.study.model.animals.Dog;

public class Puppy extends Dog {

    public Puppy(String name, int age, String breed) {
        super(name, age, breed);
    }

    public Puppy(String id, String name, int age, String breed) {
        super(id, name, age, breed);
    }

    public Puppy(String id, String name, int age, String breed, String[] ownerIds) {
        super(id, name, age, breed, ownerIds);
    }
    public String play() {
        return "I'm playing!";
    }

    @Override
    public String speak() {
        return "Yip!";
    }


    public String toCSV(String delimiter) {

        return super.toCSV(delimiter).replace("Dog", "Puppy");
    }


}
