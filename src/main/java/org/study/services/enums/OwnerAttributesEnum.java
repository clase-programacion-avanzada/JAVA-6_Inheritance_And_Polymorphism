package org.study.services.enums;

public enum OwnerAttributesEnum {

    TYPE(0,"type"),
    ID(1,"id"),
    NAME(2,"name"),
    USERNAME(3,"username"),
    EMAIL(4,"email"),
    PASSWORD(5,"password"),
    AGE(6,"age"),
    PHONE(7,"phone"),
    ADDRESS(8,"address"),
    CITY(9,"city"),
    STATE(10,"state"),
    COUNTRY(11,"country"),

    ZIPCODE(12, "zipcode"),
    ANIMAL_IDS(13, "animalIds");

    private int index;

    private String header;

    private OwnerAttributesEnum(int index, String header) {
        this.index = index;
        this.header = header;

    }

    public String getHeader() {
        return header;
    }

    public int getIndex() {
        return index;
    }
}
