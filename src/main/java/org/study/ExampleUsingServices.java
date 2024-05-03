package org.study;

import java.io.IOException;
import org.study.controllers.FileController;
import org.study.services.AnimalService;
import org.study.services.FileService;
import org.study.services.OwnerService;
import org.study.services.VaccineService;

public class ExampleUsingServices {

    public static void main(String[] args) {

        FileService fileService = new FileService();
        AnimalService animalService = new AnimalService();
        OwnerService ownerService = new OwnerService();
        VaccineService vaccineService = new VaccineService();

        FileController fileController = new FileController(fileService, animalService, ownerService,
            vaccineService);


        try {
            fileController.loadCSVFiles(
                "src/main/resources/",
                ";",
                "vaccines.csv",
                "animals.csv",
                "owners.csv"
                );

            System.out.println("Animals loaded: " + animalService.getAnimals().size());
            animalService.getAnimals().stream()
                .forEach(animal -> System.out.println(animal.toCSV(";")));

            System.out.println("Owners loaded: " + ownerService.getOwners().size());
            ownerService.getOwners().stream()
                .forEach(owner -> System.out.println(owner.toCSV(";")));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Cats in the system: " );
        animalService.getCats().stream()
            .forEach(System.out::println);

        try {

            fileController.saveAnimalsToBinaryFile("src/main/resources/","animals.dat");
            fileController.loadAnimalsFromBinaryFile("src/main/resources/","animals.dat");

            System.out.println("Animals loaded from binary file: " + animalService.getAnimals().size());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
