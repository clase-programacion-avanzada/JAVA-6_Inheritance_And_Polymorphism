package org.study.model.owners;

import java.util.List;
import org.study.model.animals.Animal;
import org.study.services.enums.OwnerTypesEnum;

public class RegularOwner extends Owner {


    public RegularOwner(String id, String name, String username, String email, String password, int age, String phone,
                        String address, String city, String state, String country, String zip) {
        super(id, name, username, email, password, age, phone, address, city, state, country, zip);
    }

    public RegularOwner(String name, String username, String email, String password, int age, String phone,
                        String address,
                        String city, String state, String country, String zip) {
        super(name, username, email, password, age, phone, address, city, state, country, zip);
    }

    public RegularOwner(String id, String name, String username, String email, String password, int age, String phone, String address, String city, String state,
                        String country, String zipcode, List<Animal> animals) {
        super(id, name, username, email, password, age, phone, address, city, state, country, zipcode, animals);
    }

    @Override
    public String getType() {
        return "Regular";
    }

    public String getDiscount() {
        return "5%";
    }

    public String toCSV(String delimiter) {
        return OwnerTypesEnum.REGULAR.getType() + delimiter + super.toCSV(delimiter);
    }

}
