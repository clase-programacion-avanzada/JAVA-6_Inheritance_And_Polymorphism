package org.study.model;

public class BaseMokepon {
    
    private String name;
    private int health;
    private int basicAttackPower;


    public BaseMokepon(String name, int health, int basicAttackPower) {
        this.name = name;
        this.health = health;
        this.basicAttackPower = basicAttackPower;
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

    public int reduceHealth(int damage, String type) {
        this.health -= damage;
        return this.health;
    }

    public Damage getDamage() {
        return new Damage(basicAttackPower, "Normal", 0, "Normal");
    }


    @Override
    public String toString() {
        return "BaseMokepon{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", basicAttackPower=" + basicAttackPower +
                '}';
    }

}
