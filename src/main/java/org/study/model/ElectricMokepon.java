package org.study.model;

public class ElectricMokepon extends BaseMokepon {


    private int basicAttackPower;
    private int paralyzeChance;


    public ElectricMokepon(String name, int health, int basicAttackPower, int paralyzeChance) {
        super(name,health,basicAttackPower);
        this.basicAttackPower = basicAttackPower;
        this.paralyzeChance = paralyzeChance;
    }


    public int getParalyzeChance() {
        return paralyzeChance;
    }


    @Override
    public int reduceHealth(int damage, String type) {
        return 0;
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
