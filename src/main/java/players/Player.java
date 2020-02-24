package players;

import items.AttackingItem;
import items.DefenceItem;
import items.TreasureItem;
import items.weapons.Unarmed;

import java.util.ArrayList;
import java.util.logging.StreamHandler;

public abstract class Player implements Attacking {

    protected int healthPoints;
    protected String name;
    protected int attackRating;
    protected int defenceRating;
    protected AttackingItem heldAttackingItem;
    protected DefenceItem defenceItem;
    protected ArrayList<TreasureItem> collectionOfTreasure;

    public Player(int healthPoints, String name, int attackRating, int defenceRating) {
        this.healthPoints = healthPoints;
        this.name = name;
        this.attackRating = attackRating;
        this.defenceRating = defenceRating;
        this.heldAttackingItem = new Unarmed("unarmed", 1);
        this.defenceItem = null;
        this.collectionOfTreasure = new ArrayList<TreasureItem>();
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

    public ArrayList<TreasureItem> getCollectionOfTreasure(){
        return collectionOfTreasure;
    }

    public void addTreasureItemToCollection(TreasureItem treasureItem) {
       collectionOfTreasure.add(treasureItem);
    };

    public int checkTreasureAddedToCollection() {
        return collectionOfTreasure.size();
    }

    public void selectAttackingItem(AttackingItem heldAttackingItem) {
        this.heldAttackingItem = heldAttackingItem;
    }

    public void selectDefenceItem(DefenceItem defenceItem) {
        this.defenceItem = defenceItem;
    }

    public ArrayList<TreasureItem> getCollectionOfTreasureItem() {
        return collectionOfTreasure;
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
