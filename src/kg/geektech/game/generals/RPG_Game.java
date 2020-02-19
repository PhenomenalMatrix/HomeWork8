package kg.geektech.game.generals;

import kg.geektech.game.players.*;

public class RPG_Game {
    public static void start() {
        Boss boss = new Boss(400, 50);
        Warrior warrior = new Warrior(230, 10);
        Tank tank = new Tank(210, 10);
        Magical magic = new Magical(260, 10);
        Medic medic = new Medic(250, 2, 100);
        Medic youngMedic = new Medic(290, 5, 50);
        Thor thor=new Thor(350,15);
        Golem golem=new Golem(450,8);
        Hero[] heroes = {warrior, tank, magic, medic, youngMedic,thor,golem};

        printStatistics(boss, heroes);
        while (!isFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }


    private static void heroesApplySuperAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].applySuperAbility(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        bossHits(boss, heroes);
        heroesHit(boss, heroes);
        heroesApplySuperAbilities(boss, heroes);
        printStatistics(boss, heroes);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("_______________");
        System.out.println("Boss health: " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName()
                    + " health: " + heroes[i].getHealth());
        }
        System.out.println("_______________");
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            } if (boss.getHealth() - heroes[i].getDamage() < 0) {
                boss.setHealth(0);
            } if (heroes[i].getHealth()-boss.getDamage()<=0){
                heroes[i].setHealth(0);
            }

        }
    }


    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }   if (heroes[i].getHealth() - boss.getDamage() < 0) {
                heroes[i].setHealth(0);
            }
        }
    }

    private static boolean isFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
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
            System.out.println("Boss won!!!");
        }
        return allHeroesDied;
    }
}
