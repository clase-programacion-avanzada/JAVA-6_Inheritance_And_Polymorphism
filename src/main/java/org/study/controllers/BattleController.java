package org.study.controllers;

import org.study.exceptions.MokeponCannotAttackException;
import org.study.model.MokeponBattle;
import org.study.services.CreatureService;

public class BattleController {

    private CreatureService creatureService;

    public BattleController(CreatureService creatureService) {
        this.creatureService = creatureService;
    }

    public MokeponBattle getMokeponByName(String name) {

        return creatureService.getMokeponByName(name);
    }

    public void attack(MokeponBattle attacker, MokeponBattle defender) throws MokeponCannotAttackException {
        attacker.attack(defender);
    }

    public boolean battleIsOver(MokeponBattle mokepon1, MokeponBattle mokepon2) {
        // Check if either Mokepon is not alive
        return !mokepon1.isAlive() || !mokepon2.isAlive();
    }

    public boolean battleIsOver(MokeponBattle mokepon) {
        return !mokepon.isAlive();
    }

    public String battleStatus(MokeponBattle mokepon1, MokeponBattle mokepon2) {
        StringBuilder status = new StringBuilder();
        status.append(mokepon1.getName()).append(" Health: ").append(mokepon1.getHealth()).append("\n");
        status.append(mokepon2.getName()).append(" Health: ").append(mokepon2.getHealth()).append("\n");
        return status.toString();
    }

    

}
