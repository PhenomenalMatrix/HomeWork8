package kg.geektech.game.players;

public class Medic extends Hero {

    private int healPoints;

    public Medic(int health, int damage, int healPoints) {
        super(health, damage, SuperAbility.HEAL);
        this.healPoints = healPoints;
    }

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            //if(heroes[i] != this){
            if (!heroes[i].getAbility().equals(SuperAbility.HEAL) && this.getHealth() > 0 && heroes[i].getHealth() <= 50){
                heroes[i].setHealth(heroes[i].getHealth() + healPoints);
                break;
            }
        }
    }
}

   /* @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            //if(heroes[i] != this){
            if (!heroes[i].getAbility().equals(SuperAbility.HEAL)){
            heroes[i].setHealth(heroes[i].getHealth() - healPoints);}
        }
    }
}*/
