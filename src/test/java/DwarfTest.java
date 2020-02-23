import items.weapons.Sword;
import org.junit.Before;
import org.junit.Test;
import players.Player;
import players.casters.Wizard;
import players.fighters.Barbarian;
import players.fighters.Dwarf;
import players.fighters.Knight;

import static org.junit.Assert.assertEquals;

public class DwarfTest {

    Player dwarf;
    Player knight;
    Sword sword;

    @Before
    public void before() {
        dwarf = new Dwarf (100, "Gimli", 3, 2);
        knight = new Knight(150, "Stephen", 3, 1);
        sword = new Sword( "Moria", 2);
    }

    @Test
    public void canInflictHealthDamage() {
        dwarf.attack(knight);
        assertEquals(148, knight.getHealthPoints());
    }

    @Test
    public void canTunnel() {
        assertEquals("The dwarf has tunnelled 300 metres", ((Dwarf)dwarf).tunnel(300));
    }

    @Test
    public void canSelectAttackingItem(){
        dwarf.selectAttackingItem(sword);
        assertEquals(sword, dwarf.getHeldAttackingItem());
    }

    @Test
    public void canReduceDefenseIfOpponentsDefenceRatingIsMoreThanAttackersAttack(){
        dwarf.attack(knight);
        assertEquals(0, knight.getDefenceRating());
        assertEquals(148, knight.getHealthPoints());
    }

}
