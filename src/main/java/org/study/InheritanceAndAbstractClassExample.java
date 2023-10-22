package org.study;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.study.model.animals.Animal;
import org.study.model.animals.Cat;
import org.study.model.animals.Dog;
import org.study.model.animals.Puppy;
import org.study.model.owners.Owner;
import org.study.model.owners.PremiumOwner;
import org.study.model.owners.RegularOwner;
import org.study.services.AnimalService;
import org.study.services.FileService;
import org.study.services.OwnerService;

public class InheritanceAndAbstractClassExample {

    public static void main(String[] args) {
        //This is an example about how to use inheritance

        //Let's talk about inheritance
        //Inheritance is a mechanism in which one object acquires all the properties and behaviors of a parent object
        //It is an important part of OOPs (Object Oriented programming system)

        Owner owner = new Owner("Juan",
            "Juan_2342",
            "email_2342@example.com",
            "Password_!!789",
            21,
            "0123456789",
    "Calle 1234",
            "Cali",
            "Valle del Cauca",
            "Colombia",
            "12354");

        //The idea behind inheritance in Java is that you can create new classes that are built upon existing classes
        //When you inherit from an existing class, you can reuse methods and fields of the parent class

        Owner regularOwner = new RegularOwner(
            "Andres",
            "Andres_1245",
            "email_2343@example.com",
            "Password_!!789",
            25,
            "0123456789",
            "Calle 1234",
            "Cali",
            "Valle del Cauca",
            "Colombia",
            "110131"
        );

        Owner premiumOwner = new PremiumOwner(
            "Ana",
            "Ana_maria_1245",
            "email_2443@example.com",
            "Password_!!789",
            25,
            "0123456789",
            "Calle 1234",
            "Cali",
            "Valle del Cauca",
            "Colombia",
            "110131"
        );

        List<Owner> owners = List.of(owner, regularOwner, premiumOwner);

        System.out.println("""
        
            Printing the owners discount:""");
        owners.stream()
            .forEach(ownerFromList -> System.out.println(ownerFromList.getDiscount()));

        System.out.println("""
        
            Printing the owners type:""");
        owners.stream()
            .forEach(ownerFromList -> System.out.println(ownerFromList.getType()));

        //We call this process of calling a method with the same name but different implementations polymorphism


        //We will create a class called Animal that is abstract, this means that we cannot instantiate it
        //Animal pancracio = new Animal("Pancracio",5);

        //Then we will create a class called Dog that extends Animal
        Dog justiniano = new Dog("Justiniano",4,"pug");

        //Then we will create a class called Cat that extends Animal
        Cat anacleto = new Cat("Anacleto",6);

        //Then we will create a class called Puppy that extends Dog
        //Puppy is a subclass of Dog, and Dog is a subclass of Animal
        //This means that Puppy is a subclass of Animal

        Puppy brandon = new Puppy("Brandon",1,"chihuahua");

        //Even when we can't instantiate an Animal, we can have a list of Animals or even create an animal that is a dog or a cat
        Animal pancracio = new Dog("Pancracio",5,"labrador");

        //We can have a list of Animals, it doesn't matter if they are Dogs or Cats
        List<Animal> animals = List.of(pancracio,justiniano,anacleto,brandon);

        //We can print the name of the animals as we know that all animals have a name
        System.out.println("""
        
            Printing the names of the animals:""");
        animals.stream().forEach(a -> System.out.println(a.getName()));

        //We can print the age of the animals as we know that all animals have an age
        System.out.println("""
        
            Printing the ages of the animals:""");
        animals.stream().forEach(a -> System.out.println(a.getAge()));

        //We can print the breed of the animals that are dogs
        System.out.println("""
        
            Printing the breeds of the dogs:""");

        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                Dog dog = (Dog) animal;
                System.out.println(dog.getBreed());
            }
        }

        animals.stream()
            .filter(animal -> animal instanceof Dog)
            .map(animal -> (Dog) animal)
            .forEach(dog -> System.out.println(dog.getBreed()));

        //We can print the lives of the animals that are cats
        System.out.println("""
        
            Printing the lives of the cats:""");

        for (Animal animal : animals) {
            if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                System.out.println(cat.getLives());
            }
        }
        animals.stream()
            .filter(animal -> animal instanceof Cat)
            .map(animal -> (Cat) animal)
            .forEach(cat -> System.out.println(cat.getLives()));

        //Now we are going to talk about polymorphism
        //Polymorphism means "many forms", and it occurs when we have many classes that are related to each other by inheritance
        //Inheritance lets us inherit attributes and methods from another class
        //Polymorphism uses those methods to perform different tasks
        //This allows us to perform a single action in different ways
        //For example, think about a superclass called Animal that has a method called speak
        //The speak method can be different for each subclass, such as Dog, Cat, Bird, etc.
        //However, it is common for all of them to make a sound
        //We can use polymorphism to perform different actions for each animal, such as eating, sleeping, making a sound, etc.
        System.out.println("""
            
            Printing the animals using the speak method:""");
        animals.stream().forEach(animal -> System.out.println(animal.speak()));

        //We can also override the toString method
        System.out.println("""
            
            Printing the animals using the toString method: """);
        animals.stream().forEach(System.out::println);

        //We will write a file with the animals using the toTextLine method

        try{

            List<String> lines = new ArrayList<>();
            for(Animal animal : animals) {
                lines.add(animal.toTextLine(";"));
            }
            Files.write(Path.of("animals.txt"),lines);


        } catch (IOException e) {
            System.out.println("Something went wrong when writing to the file");
        }

        //And we will read the file and print the animals

        try {
            List<String> lines = Files.readAllLines(Path.of("animals.txt"));
            List<Animal> animalsFromFile = new ArrayList<>();
            for(String line : lines) {
                String [] animalData = line.split(";");
                /*
                String type = animalData[0];
                String name = animalData[1];
                int age = Integer.parseInt(animalData[2]);
                if (type.equals("Dog")) {
                    String breed = animalData[3];
                    Dog dog = new Dog(name, age, breed);
                    animalsFromFile.add(dog);
                } else if (type.equals("Cat")) {
                    Cat cat = new Cat(name, age);
                    animalsFromFile.add(cat);
                } else if (type.equals("Puppy")) {
                    String breed = animalData[3];
                    Puppy puppy = new Puppy(name, age, breed);
                    animals.add(puppy);
                }

                 */

                Animal animal = getAnimalFromLine(animalData);
                animalsFromFile.add(animal);
            }
            System.out.println("""
            
                Printing the animals from the file:""");
            animalsFromFile.stream().forEach(System.out::println);

            System.out.println("""
            
                Printing the animals from the file using the getAnimalFromLine method:""");
            lines.stream()
                .map(line -> line.split(";"))
                .map(InheritanceAndAbstractClassExample::getAnimalFromLine)
                .forEach(System.out::println);



        } catch (IOException e) {
            System.out.println("Something went wrong when reading the file");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }




    }

    private static Animal getAnimalFromLine(String[] animalData) {

        return switch (animalData[0]) {
            case "Dog" -> new Dog(animalData[1], Integer.parseInt(animalData[2]), animalData[3]);
            case "Cat" -> new Cat(animalData[1], Integer.parseInt(animalData[2]));
            case "Puppy" -> new Puppy(animalData[1], Integer.parseInt(animalData[2]), animalData[3]);
            default -> throw new IllegalArgumentException("Invalid animal type");
        };

    }


}
