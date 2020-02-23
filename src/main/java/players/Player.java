package players;

import items.AttackingItem;
import items.DefenceItem;
import items.TreasureItem;
import items.weapons.Unarmed;

import java.util.ArrayList;

public abstract class Player implements Attacking {

    protected int healthPoints;
    protected String name;
    protected int attackRating;
    protected int defenceRating;
    protected AttackingItem heldAttackingItem;
    protected DefenceItem defenceItem;
    protected ArrayList<TreasureItem> collectionOfTreasureItem;

    public Player(int healthPoints, String name, int attackRating, int defenceRating) {
        this.healthPoints = healthPoints;
        this.name = name;
        this.attackRating = attackRating;
        this.defenceRating = defenceRating;
        this.heldAttackingItem = new Unarmed("unarmed", 1);
        this.defenceItem = null;
        this.collectionOfTreasureItem = new ArrayList<TreasureItem>();
    }

    public AttackingItem getHeldAttackingItem() {
        return heldAttackingItem;
    }

    public DefenceItem getDefenceItem() { return defenceItem; }

    public int getAttackRating() {
        return attackRating;
    }

    public int getDefenceRating() {
        return defenceRating;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void selectAttackingItem(AttackingItem heldAttackingItem) {
        this.heldAttackingItem = heldAttackingItem;
    }

    public void selectDefenceItem(DefenceItem defenceItem) {
        this.defenceItem = defenceItem;
    }

    public ArrayList<TreasureItem> getCollectionOfTreasureItem() {
        return collectionOfTreasureItem;
    }

    public int calculateTotalAttackValue() {
        return this.heldAttackingItem.getAttackMultiplier() * this.attackRating;
    }

    public int calculateTotalDefenceValue() {
        return this.defenceItem.getDefenceMultiplier() * this.defenceRating;
    }

    public void attack(Player opposingPlayer) {
        int effectiveDamage = calculateTotalAttackValue() - opposingPlayer.defenceRating;
        if (effectiveDamage > 0) {
            opposingPlayer.healthPoints -= effectiveDamage;
        }
        opposingPlayer.defenceRating--;
    }
}
