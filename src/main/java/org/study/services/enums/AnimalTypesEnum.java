package org.study.services.enums;

public enum AnimalTypesEnum {

    DOG("Dog"),
    CAT("Cat"),
    PUPPY("Puppy");

    private String type;

    AnimalTypesEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static AnimalTypesEnum fromString(String text) {
        for (AnimalTypesEnum b : AnimalTypesEnum.values()) {
            if (b.type.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
