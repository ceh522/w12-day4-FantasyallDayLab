package items;

public abstract class TreasureItem {

protected String typeOfTreasure;
protected int valueOfTreasure;

public TreasureItem(String typeOfTreasure, int valueOfTreasure){
        this.typeOfTreasure=typeOfTreasure;
        this.valueOfTreasure=valueOfTreasure;
        }

        public String getTypeOfTreasure(){
        return typeOfTreasure;
        }

        public int getValueOfTreasure() {
    return valueOfTreasure;
        }

        }
