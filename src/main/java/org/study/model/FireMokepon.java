package org.study.model;

import java.io.Serializable;

public class FireMokepon extends BaseMokepon implements Serializable {

    private float burnChance;
    private int burnDamage;

    public FireMokepon(String name, int health, int basicAttackPower, float burnChance, int burnDamage) {
        super(name,health,basicAttackPower);
        this.burnChance = burnChance;
        this.burnDamage = burnDamage;
    }

    public float getBurnChance() {
        return burnChance;
    }

    @Override
    public int reduceHealth(int damage, String type) {

        if(type.equals("Grass")){
            return  this.health;
        }

        return super.reduceHealth(damage);
    }


    public int getAttackPower() {
        return basicAttackPower + burnDamage;
    }

    @Override
    public Damage getDamage() {
        
        if (Math.random() > burnChance) {
            return new Damage(basicAttackPower + burnDamage, "Burn", 3, "Fire");
        }

        return new Damage(basicAttackPower, "Normal", 0, "Fire");
    }


    @Override
    public String toString() {
        return "FireMokepon{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", basicAttackPower=" + basicAttackPower +
                ", burnChance=" + burnChance +
                '}';
    }
}
