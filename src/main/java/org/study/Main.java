package org.study;

import org.study.controllers.BattleController;
import org.study.services.CreatureService;
import org.study.view.BattleArena;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Mokepon Battle Simulator!");

        CreatureService creatureService = new CreatureService();
        BattleController battleController = new BattleController(creatureService);
        BattleArena battleArena = new BattleArena(battleController);

        battleArena.startBattleDemo();

    }

}
