package org.study;

import java.io.File;
import org.study.services.AnimalService;
import org.study.services.FileService;
import org.study.services.OwnerService;

public class EcampleUsingServices {

    public static void main(String[] args) {

        FileService fileService = new FileService();
        AnimalService animalService = new AnimalService();
        OwnerService ownerService = new OwnerService();

        try {
            animalService.loadAnimalsFromCSVFile(
                "src/main/resources/animals.csv",
                ";",
                fileService);
            animalService.loadAnimalsFromCSVFile(
                "src/main/resources/vaccines.csv",
                ";",
                fileService);
            ownerService.loadOwnersFromCSVFile(
                "src/main/resources/owners.csv",
                ";",
                fileService);

            System.out.println(animalService.getAnimals());
            System.out.println(ownerService.getOwners());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        


    }
}
