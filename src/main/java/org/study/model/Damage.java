package org.study.model;

public class Damage {

    private int amount;
    private String sideEffect;
    private int effectDuration;
    private String type;

    public Damage(int amount, String sideEffect, int effectDuration, String type) {
        this.amount = amount;
        this.sideEffect = sideEffect;
        this.effectDuration = effectDuration;
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public String getSideEffect() {
        return sideEffect;
    }

    public int getEffectDuration() {
        return effectDuration;
    }

    public String getType() {
        return type;
    }

}
