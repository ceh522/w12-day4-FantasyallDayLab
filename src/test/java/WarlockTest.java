import items.AttackingItem;
import items.DefenceItem;
import items.Spells.Fireball;
import items.Spells.Invisibility;
import items.mythicalcreatures.Dragon;
import items.mythicalcreatures.MythicalCreature;
import org.junit.Before;
import org.junit.Test;
import players.Attacking;
import players.Player;
import players.casters.Caster;
import players.casters.Warlock;
import players.fighters.Dwarf;
import players.fighters.Knight;

import static org.junit.Assert.assertEquals;

public class WarlockTest {

    Player warlock;
    Player knight;
    AttackingItem fireball;
    DefenceItem invisibility;
    MythicalCreature dragon;

    @Before
    public void before() {
        warlock = new Warlock(100, "Alex", 2, 4);
        knight = new Knight(150, "Stephen", 3, 1);
        fireball = new Fireball("Fireball", 6);
        invisibility = new Invisibility("Invisibility Cloak", 3);
        dragon = new Dragon("Humphrey", 4);
    }

    @Test
    public void canInflictHealthDamage() {
        warlock.attack(knight);
        assertEquals(149, knight.getHealthPoints());
    }

    @Test
    public void canBoostHealth() {
        assertEquals(200, ((Warlock)warlock).boostHealth());
    }

    @Test
    public void canSelectAttackingItem(){
        warlock.selectAttackingItem(fireball);
        assertEquals(fireball, warlock.getHeldAttackingItem());
    }

    @Test
    public void canSelectDefenceItem(){
        warlock.selectDefenceItem(invisibility);
        assertEquals(invisibility, warlock.getDefenceItem());
    }

    @Test
    public void canSetMythicalCreature(){
        ((Caster) warlock).setMythicalCreature(dragon);
        assertEquals(dragon, ((Caster)warlock).getMythicalCreature());
    }

    @Test
    public void defenceRatingIncreasesWhenMythicalCreatureSet(){
        ((Caster) warlock).setMythicalCreature(dragon);
        assertEquals(16, warlock.getDefenceRating());
    }

    @Test
    public void canReduceDefenseIfOpponentsDefenceRatingIsMoreThanAttackersAttack(){    Player dwarf = new Dwarf(11, "Ralph", 2, 3);
    warlock.attack(dwarf);
    assertEquals(2, dwarf.getDefenceRating());
    assertEquals(11, dwarf.getHealthPoints());
    }

}
