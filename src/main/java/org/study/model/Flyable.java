package org.study.model;

public interface Flyable {

    String fly();

    default String fly(String name) {
        return "I am flying using " + name;
    }

}
