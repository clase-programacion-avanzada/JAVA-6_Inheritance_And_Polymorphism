package org.study.model;

public class Puppy extends Dog {

    public Puppy(String name, int age, String breed) {
        super(name, age, breed);
    }

    public String play() {
        return "I'm playing!";
    }

    @Override
    public String speak() {
        return "Yip!";
    }

}
