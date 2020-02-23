package items;

public abstract class DefenceItem {
    protected String name;
    protected int defenceMultiplier;

    public DefenceItem(String name, int defenceMultiplier) {
        this.name = name;
        this.defenceMultiplier = defenceMultiplier;
    }

    public int getDefenceMultiplier() {
        return defenceMultiplier;
    }
}
