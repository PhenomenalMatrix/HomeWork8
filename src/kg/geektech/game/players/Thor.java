package kg.geektech.game.players;

import java.util.Random;

public class Thor extends Hero {
    public Thor(int health, int damage) {
        super(health, damage, SuperAbility.STUN);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        Random r = new Random();
        int indexRandom = r.nextInt(3);
        if(indexRandom == 0){
            boss.setDamage(boss.getDamage() * indexRandom);
            System.out.println("Босс застанен");
        }
    }
}
