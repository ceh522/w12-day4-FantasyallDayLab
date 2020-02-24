package rooms;

import items.TreasureItem;
import players.Player;

import java.util.ArrayList;

public abstract class Room {

    protected String name;
    protected ArrayList<Player> players;
    protected TreasureItem treasureItem;
    protected int attackForceNeededToLeaveRoom;

    public Room(String name, TreasureItem treasureItem, int attackForceNeededToLeaveRoom) {
        this.name = name;
        this.players = new ArrayList<Player>();
        this.treasureItem = treasureItem;
        this.attackForceNeededToLeaveRoom = attackForceNeededToLeaveRoom;
    }

    public void addPlayerToRoom(Player player) {
        players.add(player);
    }

    public int getAttackForceNeededToLeaveRoom() {
        return attackForceNeededToLeaveRoom;
    }

    public TreasureItem getTreasureItem() {
        return treasureItem;
    }

    public void removePlayerFromRoom(Player player) {
        players.remove(player);
    }

    public void removeTreasureFromRoom() {
        this.treasureItem = null;
    }

    public ArrayList<Player> getPlayersInRoom() {
        return players;
    }

    public int checkNumberOfPlayersInRoom() {
        return this.getPlayersInRoom().size();
    }
}
