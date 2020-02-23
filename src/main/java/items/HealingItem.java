package items;

public abstract class HealingItem {

    protected String name;
    protected int increaseHealth;

    public HealingItem(String name, int increaseHealth) {
        this.name = name;
        this.increaseHealth = increaseHealth;

    }

    public int getIncreaseInHealth(){
        return increaseHealth;
    }
}