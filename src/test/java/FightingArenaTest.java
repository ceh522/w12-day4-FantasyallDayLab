import items.AttackingItem;
import items.DefenceItem;
import items.Spells.Fireball;
import items.Spells.Invisibility;
import items.TreasureItem;
import items.armour.Shield;
import items.treasures.Gold;
import items.treasures.Jewels;
import items.weapons.Sword;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import players.Attacking;
import players.Player;
import players.casters.Wizard;
import players.fighters.Knight;
import rooms.Dungeon;
import rooms.FightingArena;
import rooms.Room;

import static junit.framework.TestCase.assertEquals;

public class FightingArenaTest {


    Room fightingArena;
    Player wizard;
    TreasureItem jewels;
    Player knight2;
    AttackingItem sword;
    AttackingItem fireball;
    DefenceItem invisibility;
    DefenceItem shield;

    @Before
    public void before() {
        fightingArena = new FightingArena("Colesseum", jewels, 5000);
        jewels = new Jewels("rubies", 500);
        wizard = new Wizard(100, "Daniel", 3, 4);
        knight2 = new Knight(150, "Galahad", 3, 1);
        sword = new Sword("Nimrod", 2);
        fireball = new Fireball("Fireball", 6);
        invisibility = new Invisibility("Invisibility Cloak", 3);
        shield = new Shield("shield", 2);
    }

    @Test
    public void wizardAndKnightCanEnterFightingArena() {
        fightingArena.addPlayerToRoom(wizard);
        fightingArena.addPlayerToRoom(knight2);
        assertEquals(2, fightingArena.checkNumberOfPlayersInRoom());
    }

    @Test
    public void CanSelectAttackingItemsAndFight() {
        knight2.selectAttackingItem(sword);
        wizard.selectAttackingItem(fireball);
        wizard.selectDefenceItem(invisibility);
        knight2.selectDefenceItem(shield);
        wizard.attack(knight2);
        if  (wizard.calculateTotalDefenceValue() > knight2.calculateTotalDefenceValue()) {
            wizard.addTreasureItemToCollection(fightingArena.getTreasureItem());
            fightingArena.removeTreasureFromRoom();
            fightingArena.removePlayerFromRoom(wizard);
        }
        assertEquals(true, wizard.calculateTotalDefenceValue() > knight2.calculateTotalDefenceValue());
        assertEquals(1, wizard.checkTreasureAddedToCollection());
        assertEquals(null, fightingArena.getTreasureItem());
        assertEquals(0, fightingArena.checkNumberOfPlayersInRoom());
    }
}


