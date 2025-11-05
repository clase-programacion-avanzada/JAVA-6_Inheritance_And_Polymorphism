package org.study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.study.controllers.BattleController;
import org.study.model.Airplane;
import org.study.model.BaseMokepon;
import org.study.model.DragonMokepon;
import org.study.model.ElectricMokepon;
import org.study.model.FireMokepon;
import org.study.model.Flyable;
import org.study.services.MokeponService;
import org.study.view.BattleView;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Mokepon Battle Simulator!");

        MokeponService mokeponService = new MokeponService();
        BattleController battleController = new BattleController(mokeponService);
        BattleView battleView = new BattleView(battleController);

        battleView.startBattleDemo();

        List<Integer> list = new LinkedList<>();

        list.add(1);

        List<Flyable> flyables = new ArrayList<>();

        flyables.add(new DragonMokepon("Charizandra", 100,100, 0.3f, 3));

        flyables.add(new Airplane());

        for (Flyable f : flyables) {
            System.out.println(f.fly());

            if (f instanceof DragonMokepon dragonMokepon) {
                dragonMokepon.getDamage();
            }

        }

        List<BaseMokepon> mokepons = new ArrayList<>();

        for (BaseMokepon mokepon : mokepons) {

            System.out.println(mokepon.getName());
            System.out.println(mokepon.getBasicAttackPower());
            System.out.println(mokepon.getHealth());

            if (mokepon instanceof FireMokepon fireMokepon) {
                System.out.println("BurnChance: ");
                System.out.println(fireMokepon.getBurnChance());
            }

            if (mokepon instanceof ElectricMokepon electricMokepon) {
                System.out.println("ParalyzeChance: ");
                System.out.println(electricMokepon.getParalyzeChance());
            }

            switch (mokepon) {
                case FireMokepon firemokepon -> {

                }
                default -> {

                }
            }

        }
    }

}
