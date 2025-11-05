package org.study.model;

public class FireMokepon {
    
    private String name;
    private int health;
    private int basicAttackPower;
    private float burnChance;
    private int burnDamage;

    public FireMokepon(String name, int health, int basicAttackPower, float burnChance, int burnDamage) {
        this.name = name;
        this.health = health;
        this.basicAttackPower = basicAttackPower;
        this.burnChance = burnChance;
        this.burnDamage = burnDamage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getbasicAttackPower() {
        return basicAttackPower;
    }

    public float getBurnChance() {
        return burnChance;
    }

    public int reduceHealth(int damage) {
        this.health -= damage;
        return this.health;
    }

    public int getAttackPower() {
        return basicAttackPower + burnDamage;
    }

    public Damage getDamage() {
        
        if (Math.random() < burnChance) {
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
