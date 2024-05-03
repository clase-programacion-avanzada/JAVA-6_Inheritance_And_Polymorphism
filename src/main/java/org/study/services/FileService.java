package org.study.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.study.model.animals.Animal;
import org.study.model.owners.Owner;
import org.study.model.Vaccine;

public class FileService {


    /**
     * Extracts IDs from a string and returns them as a list.
     *
     * The method does the following:
     * 1. Initializes an empty list to store the IDs.
     * 2. Splits the input string into an array using the comma as a separator.
     * 3. Loops through each ID in the array. For each ID, it:
     *    - Removes the curly braces from the ID.
     *    - Adds the cleaned ID to the list of IDs.
     * 4. Returns the list of IDs.
     *
     * @param ids The string containing the IDs.
     * @return A list of IDs.
     */
    private List<String> extractIds(String ids) {

        // Create a list to store the IDs
        List<String> idList = new ArrayList<>();

        // Split the string into an array using the comma as a separator
        String[] idArray = ids.split(",");

        // Loop through each ID in the array
        for (String id : idArray) {
            // Remove the curly braces and add the ID to the list
            idList.add(id.replace("{", "").replace("}", ""));
        }

        // Return the list of IDs
        return idList;
    }




    public List<Vaccine> loadVaccinesFromCSVFile(String vaccinesFile, String delimiter) throws IOException {

        File file = new File(vaccinesFile);

        // Reference: https://funnelgarden.com/java_read_file/#1b_FilesreadAllLines_Explicit_Encoding
        List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        List<Vaccine> vaccineList = new ArrayList<>();
        for (String line : lines) {
            // Split the line into values using the specified delimiter.
            String[] values = line.split(delimiter);

            // Extract vaccine data from the CSV line.
            String id = values[0];
            int volumeInMl = Integer.parseInt(values[1]);
            String brand = values[2];
            String type = values[3];

            // Create a new Vaccine object with the extracted data.
            Vaccine vaccine = new Vaccine(id, volumeInMl, brand, type);

            // Add the vaccine to the list.
            vaccineList.add(vaccine);
        }

        return vaccineList;

    }

    public List<Animal> loadAnimalsFromCSVFile(String animalsFile, String delimiter, Map<String, Vaccine> vaccinesById)
        throws IOException {

            File file = new File(animalsFile);

            // Reference: https://funnelgarden.com/java_read_file/#1b_FilesreadAllLines_Explicit_Encoding
            List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

            List<Animal> animalsList = new ArrayList<>();
            for (String line : lines) {
                // Split the line into values using the specified delimiter.
                String[] data = line.split(delimiter);

                // Extract animal data from the CSV line.
                String type = data[0];
                String id = data[1];
                String name = data[2];
                int age = Integer.parseInt(data[3]);
                String breed = type.equalsIgnoreCase("cat") ? "" : data[4];
                String vaccineIds = type.equalsIgnoreCase("cat") ? data[4] : data[5];

                List<String> vaccinesIds = extractIds(vaccineIds);
                List<Vaccine> vaccines = new ArrayList<>();

                for (String vaccineId : vaccinesIds) {
                    Vaccine vaccine = vaccinesById.get(vaccineId);
                    if (vaccine != null) {
                        vaccines.add(vaccine);
                    }
                }

                Animal animal = Animal.getAnimalFromType(type, id, name, age, breed, vaccines);
                animalsList.add(animal);

            }

            return animalsList;
    }

    public List<Owner> loadOwnersFromCSVFile(String ownersFile, String delimiter, Map<String, Animal> animalsById)
        throws IOException {

        File file = new File(ownersFile);

        // Reference: https://funnelgarden.com/java_read_file/#1b_FilesreadAllLines_Explicit_Encoding
        List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

        List<Owner> ownersList = new ArrayList<>();
        for (String line : lines) {
            // Split the line into values using the specified delimiter.
            String[] data = line.split(delimiter);

            // Extract owner data from the CSV line.
            String type = data[0];
            String id = data[1];
            String name = data[2];
            String username = data[3];
            String email = data[4];
            String password = data[5];
            int age = Integer.parseInt(data[6]);
            String phone = data[7];
            String address = data[8];
            String city = data[9];
            String state = data[10];
            String country = data[11];
            String zipcode = data[12];

            List<String> animalIds = extractIds(data[13]);
            List<Animal> animals = new ArrayList<>();

            for (String animalId : animalIds) {
                Animal animal = animalsById.get(animalId);
                if (animal != null) {
                    animals.add(animal);
                }
            }

            Owner owner = Owner.getOwnerFromType(type, id, name, username, email, password, age, phone, address, city, state, country, zipcode, animals);
            ownersList.add(owner);

        }

        return ownersList;
    }


    /**
     * Writes a list of strings to a text file.
     *
     * The method does the following:
     * 1. Creates a File object using the provided path.
     * 2. Deletes the file if it already exists.
     * 3. Creates a new file at the specified path.
     * 4. Loops through each line in the provided list. For each line, it:
     *    - Adds a newline character before the line if it's not the first line.
     *    - Writes the line to the file.
     *
     * @param path The path to the text file.
     * @param linesToWrite The list of strings to write to the file.
     * @throws IOException If an I/O error occurs writing to the file.
     */
    private void writeTextFile(String path,
                               List<String> linesToWrite)
        throws IOException {

        // Create a File object with the given path
        File file = new File(path);

        // Delete the file if it exists
        Files.deleteIfExists(file.toPath());
        // Create the file
        Files.createFile(file.toPath());

        // Loop through each line in the list
        for (int i = 0; i < linesToWrite.size(); i++) {

            // If it's not the first line, add a newline character
            if (i!=0) {
                Files.writeString(file.toPath(), "\n", StandardOpenOption.APPEND);
            }
            // Write the line to the file
            Files.writeString(file.toPath(), linesToWrite.get(i), StandardOpenOption.APPEND);
        }
    }

    public void writeVaccinesToCSVFile(String vaccinesFile, String delimiter, List<Vaccine> vaccines)
        throws IOException {

        List<String> vaccinesListToCSV = new ArrayList<>();
        for (Vaccine vaccine : vaccines) {
            // Create a CSV line with the vaccine data
            String line = vaccine.toCSV(delimiter);
            // Add the line to the list
            vaccinesListToCSV.add(line);
        }
        writeTextFile(vaccinesFile, vaccinesListToCSV);
    }

    public void writeAnimalsToCSVFile(String animalsFile, String delimiter, List<Animal> animals)
        throws IOException {

        List<String> animalsListToCSV = new ArrayList<>();
        for (Animal animal : animals) {
            // Create a CSV line with the animal data
            String line = animal.toCSV(delimiter);
            // Add the line to the list
            animalsListToCSV.add(line);
        }
        writeTextFile(animalsFile, animalsListToCSV);
    }

    public void writeOwnersToCSVFile(String ownersFile, String delimiter, List<Owner> owners)
        throws IOException {

        List<String> ownersListToCSV = new ArrayList<>();
        for (Owner owner : owners) {
            // Create a CSV line with the owner data
            String line = owner.toCSV(delimiter);
            // Add the line to the list
            ownersListToCSV.add(line);
        }
        writeTextFile(ownersFile, ownersListToCSV);
    }

    public List<Animal> loadAnimalsFromBinaryFile(String path, String animalsFileName)
        throws IOException, ClassNotFoundException {

        try (FileInputStream fileInputStream = new FileInputStream(path + animalsFileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (ArrayList<Animal>) objectInputStream.readObject();
        }
    }

    public void saveAnimalsToBinaryFile(String path, String animalsFileName, List<Animal> animals)
        throws IOException {

        try (FileOutputStream fileOutputStream = new FileOutputStream(path + animalsFileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(animals);
        }
    }

}
