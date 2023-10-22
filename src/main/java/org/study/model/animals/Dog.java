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
public class Dog extends Animal {
    //The class Dog extends the class Animal and will only
    // have the attributes and methods of the class Animal that are not private
    // In this case, the class Dog will have the attributes name and age but not the attribute vaccines, ownerIds or id.

    //We can add new attributes to the class, such as breed
    protected String breed;


    public Dog(String name, int age, String breed) {
        //We can call the constructor of the superclass using the super keyword
        //The superclass is the class that we are extending
        //In this case, the superclass is Animal
        super(name, age);


        this.breed = breed;

    }

    public String getBreed() {
        return breed;
    }

    //We can override the methods of the superclass using the @Override annotation
    //In this case, we are overriding the method speak() of the class Animal
    //We are changing the implementation of the method speak() for the class Dog
    @Override
    public String speak() {
        return "Woof!";
    }

    @Override
    public String toString() {
        return "Dog{" + this.name + " has " + this.age + " old " +
            //We can call the methods of the superclass using the super keyword
            //In this case, we are calling the method getVaccines() of the class Animal
            "and is a " + breed + " has " + super.getVaccines().size() + " vaccines" +
            '}';
    }
}
