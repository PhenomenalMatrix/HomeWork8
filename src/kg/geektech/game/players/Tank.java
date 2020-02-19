package kg.geektech.game.players;

public class Tank extends Hero {

    public Tank(int health, int damage) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVENT);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        boss.setHealth(boss.getHealth() - (boss.getDamage() + this.getDamage()));
    }
}
