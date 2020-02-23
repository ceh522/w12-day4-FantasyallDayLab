package players.casters;

import items.AttackingItem;
import players.Player;

public class Warlock extends Caster {

    public Warlock(int healthPoints, String name, int attackRating, int defenceRating) {
        super(healthPoints, name, attackRating, defenceRating);
    }

    public void attack(Player opposingPlayer) {
        super.attack(opposingPlayer);
    }

    public int boostHealth() {
       return this.getHealthPoints() * 2;
    }
}