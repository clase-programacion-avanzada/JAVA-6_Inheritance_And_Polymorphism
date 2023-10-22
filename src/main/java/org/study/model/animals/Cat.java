package org.study.model;
/*
 * Inheritance is a mechanism in which one object acquires all the properties and behaviors of a parent object.
 * It is an important part of OOPs (Object Oriented programming system).
 * The idea behind inheritance in Java is that you can create new classes that are built upon existing classes.
 * When you inherit from an existing class, you can reuse methods and fields of the parent class.
 * Moreover, you can add new methods and fields in your current class also.
 * Inheritance represents the IS-A relationship, also known as a parent-child relationship.
 *
 * Reference: https://www.javatpoint.com/inheritance-in-java
 * Reference: https://www.geeksforgeeks.org/inheritance-in-java/
 * */
public class Cat extends Animal {

    private int lives;


    public Cat(String name, int age) {
        super(name, age);

        this.lives = 9;
    }

    @Override
    public String speak() {
        return "Meow!";
    }

    @Override
    public String toString() {
        return "Cat{" + super.getName() + " has " + super.getAge() + " old " +
            "and has " + lives + " lives left" +
            '}';
    }

    public int getLives() {
        return lives;
    }



}
