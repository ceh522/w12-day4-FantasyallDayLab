import items.AttackingItem;
import items.Spells.Fireball;
import items.TreasureItem;
import items.treasures.Gold;
import items.treasures.Jewels;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import players.Player;
import players.casters.Wizard;
import rooms.Dungeon;
import rooms.FightingArena;
import rooms.Room;

import static junit.framework.TestCase.assertEquals;

public class DungeonTest {

    Room dungeon;
    Player wizard;
    AttackingItem fireball;
    TreasureItem gold;
    Room fightingArena;
    TreasureItem jewels;

    @Before
    public void before() {
        dungeon = new Dungeon("Dungeon of Doom", gold, 500);
        fightingArena = new FightingArena ("Colesseum", jewels, 5000);
        gold = new Gold("bars of gold", 500);
        fireball = new Fireball("Explosive", 500);
        wizard = new Wizard(100, "Daniel", 3, 4);
        jewels = new Jewels("rubies", 500 );

    }

    @Test
    public void wizardCanEnterDungeon() {
        dungeon.addPlayerToRoom(wizard);
        assertEquals(1, dungeon.checkNumberOfPlayersInRoom());
    }

    @Test
    public void wizardCanSummonFireball() {
        wizard.selectAttackingItem(fireball);
        assertEquals(fireball, wizard.getHeldAttackingItem());
    }

    @Test
    public void wizardHasEnoughAttackForceToBlastHoleInDungeonAndLeaveRoomWithTreasure() {
        if (dungeon.getAttackForceNeededToLeaveRoom() <= wizard.calculateTotalAttackValue()) {
            wizard.addTreasureItemToCollection(dungeon.getTreasureItem());
            dungeon.removeTreasureFromRoom();
            dungeon.removePlayerFromRoom(wizard);
            fightingArena.addPlayerToRoom(wizard);
            assertEquals(1, wizard.checkTreasureAddedToCollection());
            assertEquals(null, dungeon.getTreasureItem());
            assertEquals(0, dungeon.checkNumberOfPlayersInRoom());
            assertEquals(1, fightingArena.checkNumberOfPlayersInRoom());
        }

    }
}
