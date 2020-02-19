package kg.geektech.game.players;

import java.util.Random;

public class Magical extends Hero {

    public Magical(int health, int damage) {
        super(health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length ; i++) {
            if(heroes[i].getHealth() > 0 ){
                Random r = new Random();
                int indexRandom = r.nextInt(10)+1;
                heroes[i].setDamage(heroes[i].getDamage() + indexRandom);
            }
        }
    }
}
