import items.healingItems.Herbs;
import org.junit.Before;
import org.junit.Test;
import players.Cleric;
import players.Player;
import players.fighters.Barbarian;
import players.fighters.Dwarf;

import static junit.framework.TestCase.assertEquals;

public class ClericTest {

    Player cleric;
    Player dwarf;
    Herbs herbs;

    @Before
    public void before() {
        cleric = new Cleric(200, "Eleanor", 0, 1);
        dwarf = new Dwarf(100, "Gimli", 3, 2);
        herbs = new Herbs("chamomillle and feverfew", 10);
    }

    @Test
    public void canHealOtherPlayers() {
        ((Cleric)cleric).heal(dwarf, herbs);
        assertEquals(110, dwarf.getHealthPoints());
    }

}
