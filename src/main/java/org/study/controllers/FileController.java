package org.study.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.study.exceptions.NotFoundException;
import org.study.model.Vaccine;
import org.study.model.animals.Animal;
import org.study.model.owners.Owner;
import org.study.services.AnimalService;
import org.study.services.FileService;
import org.study.services.OwnerService;
import org.study.services.VaccineService;

public class FileController {

    private final FileService fileService;

    private final AnimalService animalService;

    private final OwnerService ownerService;

    private final VaccineService vaccineService;

    public FileController(FileService fileService, AnimalService animalService, OwnerService ownerService,
                          VaccineService vaccineService) {
        this.fileService = fileService;
        this.animalService = animalService;
        this.ownerService = ownerService;
        this.vaccineService = vaccineService;
    }

    public void loadAnimalsFromCSVFile(String path, String separator) {

    }


    public void loadCSVFiles(String path,
                             String delimiter,
                             String vaccinesFileName,
                             String animalsFileName,
                             String ownersFileName) throws NotFoundException, IOException {
        String vaccinesFile = path + vaccinesFileName;
        List<Vaccine> vaccines = fileService.loadVaccinesFromCSVFile(vaccinesFile, delimiter);
        vaccineService.loadVaccines(vaccines);
        Map<String, Vaccine> vaccinesById = vaccineService.getVaccinesById();

        String animalsFile = path + animalsFileName;
        List<Animal> animals = fileService.loadAnimalsFromCSVFile(animalsFile, delimiter, vaccinesById);
        animalService.loadAnimals(animals);
        Map<String, Animal> animalsById = animalService.getAnimalsById();

        String ownersFile = path + ownersFileName;
        List<Owner> owners = fileService.loadOwnersFromCSVFile(ownersFile, delimiter, animalsById);
        ownerService.loadOwners(owners);
    }

    public void writeCSVFiles(String path,
                              String delimiter,
                              String vaccinesFileName,
                              String animalsFileName,
                              String ownersFileName) throws IOException {
        String vaccinesFile = path + vaccinesFileName;
        List<Vaccine> vaccines = vaccineService.getVaccines();
        fileService.writeVaccinesToCSVFile(vaccinesFile, delimiter, vaccines);

        String animalsFile = path + animalsFileName;
        fileService.writeAnimalsToCSVFile(animalsFile, delimiter, animalService.getAnimals());

        String ownersFile = path + ownersFileName;
        fileService.writeOwnersToCSVFile(ownersFile, delimiter, ownerService.getOwners());
    }

    public void saveAnimalsToBinaryFile(String path, String animalsFileName) throws IOException {
        List<Animal> animals = animalService.getAnimals();
        fileService.saveAnimalsToBinaryFile(path, animalsFileName, animals);
    }

    public void loadAnimalsFromBinaryFile(String path, String animalsFileName) throws IOException, ClassNotFoundException {
        List<Animal> animals = fileService.loadAnimalsFromBinaryFile(path, animalsFileName);
        animalService.loadAnimals(animals);

    }
}
