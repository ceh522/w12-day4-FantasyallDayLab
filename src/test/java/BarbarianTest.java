import items.weapons.Sword;
import org.junit.Before;
import org.junit.Test;
import players.Player;
import players.casters.Caster;
import players.casters.Warlock;
import players.fighters.Barbarian;
import players.fighters.Dwarf;
import players.fighters.Knight;

import static org.junit.Assert.assertEquals;

public class BarbarianTest {

    Player barbarian;
    Player knight;
    Sword sword;

    @Before public void before() {
        barbarian = new Barbarian(150, "Ivan the Headsplitter", 4, 2);
        knight = new Knight(150, "Stephen", 3, 1);
        sword = new Sword( "Claw", 2);
    }

    @Test
    public void canInflictHealthDamage(){
        barbarian.attack(knight);
        assertEquals(147, knight.getHealthPoints());
    }

    @Test
    public void canGoBeserk(){
        assertEquals(16, ((Barbarian)barbarian).goesBeserk());
    }

    @Test
    public void canSelectAttackingItem(){
        barbarian.selectAttackingItem(sword);
        assertEquals(sword, barbarian.getHeldAttackingItem());
    }

    @Test
    public void canReduceDefenseIfOpponentsDefenceRatingIsMoreThanAttackersAttack(){
        barbarian.attack(knight);
        assertEquals(0, knight.getDefenceRating());
        assertEquals(147, knight.getHealthPoints());
    }

}
