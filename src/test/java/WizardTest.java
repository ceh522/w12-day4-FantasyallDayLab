import items.AttackingItem;
import items.DefenceItem;
import items.Spells.Fireball;
import items.Spells.Invisibility;
import items.mythicalcreatures.Banshee;
import items.mythicalcreatures.Dragon;
import items.mythicalcreatures.MythicalCreature;
import org.junit.Before;
import org.junit.Test;
import players.Player;
import players.casters.Caster;
import players.casters.Warlock;
import players.casters.Wizard;
import players.fighters.Dwarf;
import players.fighters.Knight;

import static org.junit.Assert.assertEquals;

public class WizardTest {

    Player wizard;
    Player knight;
    AttackingItem fireball;
    DefenceItem invisibility;
    MythicalCreature banshee;

    @Before
    public void before() {
        wizard = new Wizard(100, "Daniel", 3, 4);
        knight = new Knight(150, "Gerald", 2, 1);
        invisibility = new Invisibility("Invisibility Cloak", 3);
        fireball = new Fireball("Blue Flame", 7);
        banshee = new Banshee("Vera", 3);
    }

    @Test
    public void canInflictHealthDamage() {
        wizard.attack(knight);
        assertEquals(148, knight.getHealthPoints());
    }

    @Test
    public void canLevitate() {
       assertEquals("The wizard has levitated by 100 metres", ((Wizard)wizard).levitate(100));
    }

    @Test
    public void canSelectAttackingItem(){
        wizard.selectAttackingItem(fireball);
        assertEquals(fireball, wizard.getHeldAttackingItem());
    }

    @Test
    public void canSelectDefenceItem(){
        wizard.selectDefenceItem(invisibility);
        assertEquals(invisibility, wizard.getDefenceItem());
    }

    @Test
    public void canSetMythicalCreature(){
        ((Caster) wizard).setMythicalCreature(banshee);
        assertEquals(banshee, ((Caster)wizard).getMythicalCreature());
    }

    @Test
    public void defenceRatingIncreasesWhenMythicalCreatureSet(){
        ((Caster) wizard).setMythicalCreature(banshee);
        assertEquals(12, wizard.getDefenceRating());
    }

    @Test
    public void canReduceDefenseIfOpponentsDefenceRatingIsMoreThanAttackersAttack(){    Player dwarf = new Dwarf(11, "Gimli", 2, 3);
        wizard.attack(dwarf);
        assertEquals(2, dwarf.getDefenceRating());
        assertEquals(11, dwarf.getHealthPoints());
    }

}

