package players;

import items.HealingItem;

public class Cleric extends Player {

    public Cleric(int healthPoints, String name, int attackRating, int defenceRating) {
        super(healthPoints, name, attackRating, defenceRating);
    }

    public void heal(Player player, HealingItem healingItem) {
        player.healthPoints += healingItem.getIncreaseInHealth();
    }

}
