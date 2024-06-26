package org.study.model.owners;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.study.model.animals.Animal;
import org.study.services.enums.OwnerTypesEnum;

import static org.study.services.enums.OwnerTypesEnum.PREMIUM;
import static org.study.services.enums.OwnerTypesEnum.REGULAR;




/*
* Let talk about abstract classes
* abstract classes have the 'abstract' keyword in the class declaration
* these classes are classes that cannot be instantiated
* and are used to define common behavior for subclasses.
* This means that abstract classes are used to define common attributes and methods for subclasses.
*
* The abstract keyword can be used for attributes and methods.
* if an attribute is declared as abstract, it means that the attribute must be implemented in the subclasses.
* if a method is declared as abstract, it means that the method must be implemented in the subclasses.
*
*
* Reference: https://www.javatpoint.com/abstract-class-in-java
* Reference: https://www.geeksforgeeks.org/abstract-classes-in-java/
* */
public class Owner implements Serializable {
    private static final String PASSWORD_PATTERN = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";

    private final static int MINIMUM_AGE = 18; // Minimum allowed age

    private static final String EMAIL_PATTERN = "[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]++";

    private static final String PHONE_PATTERN = "^[0-9]{10}$";


    private static final String USERNAME_PATTERN = "^[a-zA-Z][a-zA-Z0-9_]{7,30}$";

    // Attributes of the Owner class
    private UUID id;
    protected String name;
    protected String username;
    protected String email;
    protected String password;

    protected int age;
    protected String phone;
    protected String address;
    protected String city;
    protected String state;
    protected String zip;
    protected String country;

    protected List<Animal> animals;


    public Owner (String id,
                  String name,
                  String username,
                  String email,
                  String password,
                  int age,
                  String phone,
                  String address,
                  String city,
                  String state,
                  String country,
                  String zip) {

        validateConstructor(
            id,
            name,
            username,
            email,
            password,
            age,
            phone,
            address,
            city,
            state,
            zip,
            country);

        this.id = UUID.fromString(id); // Generate a unique ID for the owner
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.animals = new ArrayList<>();
    }

    public Owner (String id,
                  String name,
                  String username,
                  String email,
                  String password,
                  int age,
                  String phone,
                  String address,
                  String city,
                  String state,
                  String country,
                  String zip,
                  List<Animal> animals) {

        validateConstructor(
            id,
            name,
            username,
            email,
            password,
            age,
            phone,
            address,
            city,
            state,
            zip,
            country);

        this.id = UUID.fromString(id); // Generate a unique ID for the owner
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.animals = new ArrayList<>(animals);
    }


    public Owner(String name,
                 String username,
                 String email,
                 String password,
                 int age,
                 String phone,
                 String address,
                 String city,
                 String state,
                 String country,
                 String zip) {

        validateConstructor(
            name,
            username,
            email,
            password,
            age,
            phone,
            address,
            city,
            state,
            country,
            zip);

        this.id = UUID.randomUUID(); // Generate a unique ID for the owner
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.animals = new ArrayList<>();
    }

    public static Owner getOwnerFromType(String type,
                                         String id,
                                         String name,
                                         String username,
                                         String email,
                                         String password,
                                         int age,
                                         String phone,
                                         String address,
                                         String city,
                                         String state,
                                         String country,
                                         String zipcode,
                                         List<Animal> animals) {

        return switch (type) {
            case "Regular" -> new RegularOwner(id, name, username, email, password, age, phone, address, city, state, country, zipcode, animals);
            case "Premium" -> new PremiumOwner(id, name, username, email, password, age, phone, address, city, state, country, zipcode, animals);
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };

    }


    private void validateConstructor(String id,
                                     String name,
                                     String username,
                                     String email,
                                     String password,
                                     int age,
                                     String phone,
                                     String address,
                                     String city,
                                     String state,
                                     String country,
                                     String zip) {

        validateId(id); // Validate the provided UUID
        validateConstructor(
            name,
            username,
            email,
            password,
            age,
            phone,
            address,
            city,
            state,
            country,
            zip);


    }

    private void validateConstructor(String name,
                                     String username,
                                     String email,
                                     String password,
                                     int age,
                                     String phone,
                                     String address,
                                     String city,
                                     String state,
                                     String zip,
                                     String country) {

        validateName(name); // Validate the provided name
        validateUsername(username); // Validate the provided username
        validateEmail(email); // Validate the provided email
        validatePassword(password); // Validate the provided password
        validateAge(age); // Validate the provided age
        validatePhone(phone); // Validate the provided phone
        validateAddress(address); // Validate the provided address
        validateCity(city); // Validate the provided city
        validateState(state); // Validate the provided state
        validateZip(zip); // Validate the provided zip
        validateCountry(country); // Validate the provided country

    }

    private void validateAge(int age) {
        // Step 1: Check if the provided age is less than the minimum allowed age
        if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("Age cannot be less than " + MINIMUM_AGE);
        }
    }


    private void validateUsername(String username) {
        // Step 1: Check if the provided username is null
        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        // Step 2: Check if the provided username is empty
        if (username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        // Step 3: Check if the provided username is in the correct format
        if (!username.matches(USERNAME_PATTERN)) {
            throw new IllegalArgumentException("Username must be in the appropriate format");
        }
    }

    private void validateId(String id) {
        // Step 1: Check if the provided id is null
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        // Step 2: Check if the provided id is empty
        if (id.isEmpty()) {
            throw new IllegalArgumentException("Id cannot be empty");
        }

    }

    private void validateName(String name) {
        // Step 1: Check if the provided name is null
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }

        // Step 2: Check if the provided name is empty
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void validateEmail(String email) {
        // Step 1: Check if the provided email is null
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }

        // Step 2: Check if the provided email is empty
        if (email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        // Step 3: Check if the provided email is in the correct format
        if (!email.matches(EMAIL_PATTERN)) {
            throw new IllegalArgumentException("Email must be in the appropriate format");
        }
    }

    private void validatePhone(String phone) {
        // Step 1: Check if the provided phone is null
        if (phone == null) {
            throw new IllegalArgumentException("Phone cannot be null");
        }

        // Step 2: Check if the provided phone is empty
        if (phone.isEmpty()) {
            throw new IllegalArgumentException("Phone cannot be empty");
        }

        // Step 3: Check if the provided phone is in the correct format
        if (!phone.matches(PHONE_PATTERN)) {
            throw new IllegalArgumentException("Phone must be in the appropriate format");
        }
    }

    private void validatePassword(String password) {
        // Step 1: Check if the provided password is null
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        // Step 2: Check if the provided password is empty
        if (password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        // Step 3: Check if the provided password is less than 8 characters and includes at least one number and one letter and one special character and one uppercase letter
        if (!password.matches(PASSWORD_PATTERN)) {
            throw new IllegalArgumentException(
                password + " must be in the appropriate format\n" +
                """
                    At least one upper case English letter
                    At least one lower case English letter
                    At least one digit
                    At least one special character or space from the following: #?!@$ %^&*-
                    Minimum eight in length
                    """ );
        }
    }

    private void validateAddress(String address) {
        // Step 1: Check if the provided address is null
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }

        // Step 2: Check if the provided address is empty
        if (address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty");
        }
    }

    private void validateCity(String city) {
        // Step 1: Check if the provided city is null
        if (city == null) {
            throw new IllegalArgumentException("City cannot be null");
        }

        // Step 2: Check if the provided city is empty
        if (city.isEmpty()) {
            throw new IllegalArgumentException("City cannot be empty");
        }
    }

    private void validateState(String state) {
        // Step 1: Check if the provided state is null
        if (state == null) {
            throw new IllegalArgumentException("State cannot be null");
        }

        // Step 2: Check if the provided state is empty
        if (state.isEmpty()) {
            throw new IllegalArgumentException("State cannot be empty");
        }
    }

    private void validateZip(String zip) {
        // Step 1: Check if the provided zip is null
        if (zip == null) {
            throw new IllegalArgumentException("Zip cannot be null");
        }

        // Step 2: Check if the provided zip is empty
        if (zip.isEmpty()) {
            throw new IllegalArgumentException("Zip cannot be empty");
        }

    }

    private void validateCountry(String country) {
        // Step 1: Check if the provided country is null
        if (country == null) {
            throw new IllegalArgumentException("Country cannot be null");
        }

        // Step 2: Check if the provided country is empty
        if (country.isEmpty()) {
            throw new IllegalArgumentException("Country cannot be empty");
        }
    }



    // Getters and setters for the Owner class attributes
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        validateUsername(username);
        this.username = username;
    }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email;
    }

    public void setPassword(String password) {
        validatePassword(password);
        this.password = password;
    }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    public void setCity(String city) {
        validateCity(city);
        this.city = city;
    }

    public void setState(String state) {
        validateState(state);
        this.state = state;
    }

    public void setZip(String zip) {
        validateZip(zip);
        this.zip = zip;
    }

    public void setCountry(String country) {
        validateCountry(country);
        this.country = country;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public void setId(String id) {
        validateId(id);
        this.id = UUID.fromString(id);
    }



    public void setAge(int age) {
        validateAge(age);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void addAnimal(Animal animal) {
         animals.add(animal);

    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public String toString() {
        return "Owner{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", age=" + age +
            ", phone='" + phone + '\'' +
            ", address='" + address + '\'' +
            ", city='" + city + '\'' +
            ", state='" + state + '\'' +
            ", zip='" + zip + '\'' +
            ", country='" + country + '\'' +
            '}';
    }

    public String toCSV(String delimiter) {
        String[] animalIdsArray = this.animals.stream()
            .map(animal -> animal.getId().toString())
            .toArray(String[]::new);
        String animalIds = "{" + String.join(",",animalIdsArray ) + "}";
        return
            id + delimiter +
            name + delimiter +
            username + delimiter +
            email + delimiter +
            password + delimiter +
            age + delimiter +
            phone + delimiter +
            address + delimiter +
            city + delimiter +
            state + delimiter +
            zip + delimiter +
            country + delimiter +
            animalIds ;
    }

    //public abstract String getType();
    public String getType() {
        return "No Type";
    }

    public String getDiscount() {
        return "0%";
    }


}
