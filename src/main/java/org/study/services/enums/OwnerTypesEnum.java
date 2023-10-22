package org.study.services.enums;

public enum OwnerTypesEnum {

    REGULAR("Regular"),
    PREMIUM("Premium");

    private String type;

    OwnerTypesEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static OwnerTypesEnum fromString(String text) {
        for (OwnerTypesEnum b : OwnerTypesEnum.values()) {
            if (b.type.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
