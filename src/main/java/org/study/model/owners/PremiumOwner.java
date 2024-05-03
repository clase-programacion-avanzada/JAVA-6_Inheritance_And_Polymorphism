package org.study.model.owners;

import java.util.List;
import org.study.model.animals.Animal;
import org.study.services.enums.OwnerTypesEnum;

public class PremiumOwner extends Owner {


    public PremiumOwner(String id, String name, String username, String email, String password, int age, String phone,
                        String address, String city, String state, String country, String zip) {
        super(id, name, username, email, password, age, phone, address, city, state, country, zip);
    }

    public PremiumOwner(String name, String username, String email, String password, int age, String phone,
                        String address,
                        String city, String state, String country, String zip) {
        super(name, username, email, password, age, phone, address, city, state, country, zip);
    }

    public PremiumOwner(String id, String name, String username, String email, String password, int age, String phone, String address, String city, String state,
                        String country, String zipcode, List<Animal> animals) {
        super(id, name, username, email, password, age, phone, address, city, state, country, zipcode, animals);
    }


    @Override
    public String getType() {
        return "Premium";
    }

    public String getDiscount() {
        return "10%";
    }

    public String toCSV(String delimiter) {
        return OwnerTypesEnum.PREMIUM.getType() + delimiter + super.toCSV(delimiter);
    }

}
