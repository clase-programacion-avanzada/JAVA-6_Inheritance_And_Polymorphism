package org.study;

import org.study.services.AnimalService;
import org.study.services.FileService;
import org.study.services.OwnerService;

public class ExampleUsingServices {

    public static void main(String[] args) {

        FileService fileService = new FileService();
        AnimalService animalService = new AnimalService();
        OwnerService ownerService = new OwnerService();

        try {
            animalService.loadAnimalsFromCSVFile(
                "src/main/resources/animals.csv",
                ";",
                fileService);
            animalService.loadVaccinesFromCSVFile(
                "src/main/resources/vaccines.csv",
                ";",
                fileService);
            ownerService.loadOwnersFromCSVFile(
                "src/main/resources/owners.csv",
                ";",
                fileService);

            animalService.getAnimals().stream()
                .forEach(animal -> System.out.println(animal.toCSV(";")));
            ownerService.getOwners().stream()
                .forEach(owner -> System.out.println(owner.toCSV(";")));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        


    }
}
