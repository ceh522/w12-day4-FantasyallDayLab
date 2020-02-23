package players.fighters;

import items.AttackingItem;
import players.Player;

public class Dwarf extends Player {

    public Dwarf(int healthPoints, String name, int attackRating, int defenceRating) {
        super(healthPoints, name, attackRating, defenceRating);
    }

    public String tunnel(int distance) {
        return "The dwarf has tunnelled " + distance + " metres";
    }
}

