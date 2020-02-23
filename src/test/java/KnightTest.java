import items.armour.Shield;
import items.weapons.Sword;
import org.junit.Before;
import org.junit.Test;
import players.Player;
import players.casters.Caster;
import players.fighters.Barbarian;
import players.fighters.Knight;

import static org.junit.Assert.assertEquals;

public class KnightTest {

    Player knight1;
    Player knight2;
    Sword sword;
    Shield shield;

    @Before
    public void before() {
        knight1 = new Knight(150, "Stephen", 3, 1);
        knight2 = new Knight(150, "Galahad", 3, 1);
        sword = new Sword("Nimrod", 2);
        shield = new Shield("shield", 2);
    }

    @Test
    public void canInflictHealthDamage(){
        knight1.attack(knight2);
        assertEquals(148, knight2.getHealthPoints());
    }

    @Test
    public void canSelectAttackingItem(){
        knight1.selectAttackingItem(sword);
        assertEquals(sword, knight1.getHeldAttackingItem());
    }

    @Test
    public void canSelectDefenceItem(){
        knight1.selectDefenceItem(shield);
        assertEquals(shield, knight1.getDefenceItem());
    }

    @Test
    public void defenceRatingIncreasesWhenDefenceItemSelected(){
        knight1.selectDefenceItem(shield);
        assertEquals(2, knight1.calculateTotalDefenceValue());
    }

    @Test
    public void canReduceDefenseIfOpponentsDefenceRatingIsMoreThanAttackersAttack(){
        knight1.attack(knight2);
        assertEquals(0, knight2.getDefenceRating());
        assertEquals(148, knight2.getHealthPoints());
    }
}
