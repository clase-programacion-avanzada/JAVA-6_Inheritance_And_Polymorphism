package org.study.view;

import java.util.Scanner;

import org.study.controllers.BattleController;
import org.study.exceptions.MokeponCannotAttackException;
import org.study.model.MokeponBattle;

public class BattleView {

    private BattleController battleController;

    public BattleView(BattleController battleController) {
        this.battleController = battleController;
    }

    public void startBattleDemo() {

        MokeponBattle mokepon1 = battleController.getMokeponByName("Chorizard");
        MokeponBattle mokepon2 = battleController.getMokeponByName("Pokachu");
        Scanner scanner = new Scanner(System.in);
        System.out.println("The battle between " + mokepon1.getName() + " and " + mokepon2.getName() + " begins!");
        int round = 1;
        
        while (!battleController.battleIsOver(mokepon1, mokepon2)) {
            System.out.println("Round " + round + ":");
            attack(mokepon1, mokepon2);

            if (!battleController.battleIsOver(mokepon2)) {

                attack(mokepon2, mokepon1);
            }
            
            System.out.println(battleController.battleStatus(mokepon1, mokepon2));

            System.out.println("Press Enter to continue to the next round...");
            scanner.nextLine();
            round++;
        }


        
        scanner.close();

        System.out.println("The battle has ended!");
    }

    private void attack(MokeponBattle attacker, MokeponBattle defender) {
        try {
            System.out.println(attacker.getName() + " is attacking " + defender.getName());
            battleController.attack(attacker, defender);
        } catch (MokeponCannotAttackException e) {
            System.out.println(attacker.getName() + " cannot attack " + defender.getName());
            System.out.println(e.getMessage());
        }   
    }

    

}
