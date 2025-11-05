package org.study.model;

public class ElectricMokepon {

    private String name;
    private int health;
    private int basicAttackPower;
    private int paralyzeChance;


    public ElectricMokepon(String name, int health, int basicAttackPower, int paralyzeChance) {
        this.name = name;
        this.health = health;
        this.basicAttackPower = basicAttackPower;
        this.paralyzeChance = paralyzeChance;
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

    public int getParalyzeChance() {
        return paralyzeChance;
    }


    @Override
    public String toString() {
        return "ElectricMokepon{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", basicAttackPower=" + basicAttackPower +
                ", paralyzeChance=" + paralyzeChance +
                '}';
    }
}
