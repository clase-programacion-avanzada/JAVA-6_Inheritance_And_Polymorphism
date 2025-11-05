package org.study.model;

import org.study.exceptions.MokeponCannotAttackException;

public class MokeponBattle {
    
    private BaseMokepon BaseMokepon;
    private State state;

    public MokeponBattle(BaseMokepon BaseMokepon) {
        this.BaseMokepon = BaseMokepon;
        this.state = new State("Normal", 0);
    }

    public BaseMokepon getBaseMokepon() {
        return BaseMokepon;
    }

    public State getState() {
        return state;
    }

    public void changeState(String newState, int turns) {
        
        if (isNormalState()) {
            this.state.changeState(newState, turns);
        }
    }

    public boolean isNormalState() {
        return this.state.getName().equalsIgnoreCase("normal");
    }

    public int reduceHealth(int damage, String type) {
        return this.BaseMokepon.reduceHealth(damage, type);
    }

    public int receiveDamage(Damage damage) {
       if (damage.getSideEffect().equalsIgnoreCase("normal")) {
        
            this.changeState(damage.getSideEffect(), damage.getEffectDuration());
        }
        return this.BaseMokepon.reduceHealth(damage.getAmount(), damage.getType());
    }



    public void attack(MokeponBattle opponent, Damage damage) {

       opponent.receiveDamage(damage);

    }

    public void attack(MokeponBattle opponent) throws MokeponCannotAttackException {

        if (!this.isNormalState()) {
            // If the BaseMokepon is not in a normal state, it cannot attack
            this.state.reduceDuration();
            throw new MokeponCannotAttackException("BaseMokepon is in " + this.state.getName() + " state and cannot attack.");
        }

        Damage damage = this.BaseMokepon.getDamage();

        attack(opponent, damage);
    }

    public String getName() {
        return BaseMokepon.getName();
    }

    public boolean isAlive() {
        return BaseMokepon.getHealth() > 0;
    }

    public int getHealth() {
        if (!this.isAlive())
            return 0;
        return BaseMokepon.getHealth();
    }

}
