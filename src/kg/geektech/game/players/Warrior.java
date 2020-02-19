package kg.geektech.game.players;

import java.util.Random;

public class Warrior extends Hero {

    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        Random ra = new Random();
        int indexRa = ra.nextInt(4)+2;
        this.setDamage(this.getDamage() * indexRa);

    }
}
