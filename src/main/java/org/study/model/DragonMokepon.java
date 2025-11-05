package org.study.model;

import java.io.Serializable;

public class DragonMokepon extends FireMokepon implements Flyable, Serializable {



    public DragonMokepon(String name, int health, int basicAttackPower, float burnChance, int burnDamage) {
        super(name, health, basicAttackPower, burnChance, burnDamage);
    }

    @Override
    public String fly() {
        return "I am flying using wings";
    }
}
