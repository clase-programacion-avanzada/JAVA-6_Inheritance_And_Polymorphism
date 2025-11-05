package org.study.model;

import java.io.Serializable;

public class Airplane implements Serializable,  Flyable {


    @Override
    public String fly() {
        return "I am flying using motor";
    }
}
