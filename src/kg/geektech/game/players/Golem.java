package kg.geektech.game.players;

import java.util.Random;

public class Golem extends Hero {

    public Golem(int health, int damage) {
        super(health, damage, SuperAbility.BLOCK_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if(this.getHealth() > 0){
            Random ra = new Random();
            int indexRandom = ra.nextInt(4)+2;
            boss.setDamage(boss.getDamage() / indexRandom);
            this.setHealth(this.getHealth() - (boss.getDamage() * heroes.length));

        }

    }
}
