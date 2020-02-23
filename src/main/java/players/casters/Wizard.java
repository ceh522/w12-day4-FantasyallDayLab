package players.casters;

import items.AttackingItem;
import players.Player;

public class Wizard extends Caster {

    public Wizard(int healthPoints, String name, int attackRating, int defenceRating) {
        super(healthPoints, name, attackRating, defenceRating);
    }

    public void attack(Player opposingPlayer) {
        super.attack(opposingPlayer);
    }

    public String levitate(int distance) {
        return "The wizard has levitated by " + distance + " metres";
    }
}
