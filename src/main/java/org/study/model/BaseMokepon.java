package org.study.model;

public abstract class BaseMokepon {
    
    protected String name;
    protected int health;
    protected int basicAttackPower;


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

    public int getBasicAttackPower() {
        return basicAttackPower;
    }

    public abstract int reduceHealth(int damage, String type);

    protected int reduceHealth(int damage) {
        this.health -= damage;
        return this.health;
    }
    public Damage getDamage() {
        return new Damage(basicAttackPower, "Normal", 0, "Normal");
    }

    public final boolean isAlive() {
        return health > 0;
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
