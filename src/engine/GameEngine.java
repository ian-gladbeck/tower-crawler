package engine;

import exception.InvalidMovementException;
import model.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class GameEngine {
    private List<Position> stepHistory = new ArrayList<>();
    private int numberRoom;
    private Player player;
    private Room room;
    private RoomGeneration roomGeneration;

    public GameEngine(Player player, Room room, RoomGeneration roomGeneration, int numberRoom) {
        this.player = player;
        this.room = room;
        this.roomGeneration = roomGeneration;
        this.numberRoom = numberRoom;
    }

    public Room generateRoom () {
        return roomGeneration.createRoom();
    }

    public void nextRoom () {
        this.numberRoom ++;
        this.room = roomGeneration.createRoom();
        this.player.resetPlayerPosition();
    }

    public void movePlayer (char direction) {
        Position newPosition = checkMovement(direction);
        if (newPosition == null) {
            throw new InvalidMovementException("You cannot move in that direction");
        }
        stepHistory.add(new Position(player.getPosition()));
        player.setPosition(newPosition);
    }

    public void playerUndoMove () {
        if (stepHistory.isEmpty()) return;
        player.setPosition(stepHistory.removeLast());
    }

    public void playerAttack (Enemy enemy) {
        player.attack(enemy);
        enemy.attack(player);
        room.removeEnemy(enemy);
    }

    public void playerFlee () {
        player.takeDamage(50);
        playerUndoMove();
    }

    public boolean checkWin () {
        return room.getTile(player.getPosition()) == Tile.EXIT;
    }

    public Enemy checkEnemy () {
        return room.getEnemyAt(player.getPosition());
    }

    private Position checkMovement (char direction) {
        int x = player.getPosition().getX();
        int y = player.getPosition().getY();
        switch (direction) {
            case 'd' -> x++;
            case 'a' -> x--;
            case 'w' -> y--;
            case 's' -> y++;
            default -> throw new InputMismatchException("Invalid Input");
        }
        if (!room.isWithinBounds(x, y) || !room.getTile(x, y).isWalkable())
            return null;

        return new Position(x, y);
    }

    public boolean checkDiamond(Position position) {
        if (room.getTile(position)
            == Tile.GOLD) {
            player.collectDiamond(10);
            room.setTile(position, Tile.PATH);
            return true;
        }
        return false;
    }

    public Position getPlayerPosition () {
        return  player.getPosition();
    }

    public int getNumberRoom() {
        return numberRoom;
    }

    public Player getPlayer() {
        return player;
    }

    public Room getRoom() {
        return room;
    }

    public RoomGeneration getRoomGeneration() {
        return roomGeneration;
    }
}
