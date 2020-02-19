package kg.geektech.game.generals;

import kg.geektech.game.players.*;

public class RPG_Game {
    public static void start() {
        Boss boss = new Boss(10000, 50);
        Warrior warrior = new Warrior(250, 10);
        Tank tank = new Tank(210, 10);
        Magical magical = new Magical(260, 10);
        Medic medic = new Medic(250, 2, 15);
        Medic youngMedic = new Medic(290, 5, 15);
        Thor thor = new Thor(210, 10);
        Golem golem = new Golem(300, 3);

        Hero[] heroes = {warrior, tank, magical, medic, youngMedic, thor, golem};


        printStatics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);

        }


    }

    private static void heroesApplySuperAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].applySuperAbility(boss, heroes);

        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        bossHit(boss, heroes);
        heroesHit(boss, heroes);
        heroesApplySuperAbilities(boss, heroes);
        printStatics(boss, heroes);
    }

    private static void printStatics(Boss boss, Hero[] heroes) {
        System.out.println("__________");
        System.out.println("Boss health: " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() + " health: " + heroes[i].getHealth());
        }
        System.out.println("__________");
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static void bossHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() < 0) {
            System.out.println("Heroes won!!");
            return true;
        }
        boolean allHeroesDied = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDied = false;
                break;
            }

        }
        if (allHeroesDied) {
            System.out.println("Boss won!!");
        }
        return allHeroesDied;
    }

}
