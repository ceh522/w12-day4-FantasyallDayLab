package players.fighters;

import items.AttackingItem;
import players.Player;

public class Barbarian extends Player {

    public Barbarian(int healthPoints, String name, int attackRating, int defenceRating) {
        super(healthPoints, name, attackRating, defenceRating);
    }

    public int goesBeserk() {
            return this.getAttackRating() * 4;
        }
    }
