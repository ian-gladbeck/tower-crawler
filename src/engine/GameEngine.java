package engine;

import exception.InvalidMovementException;
import model.*;

import java.util.InputMismatchException;

public class GameEngine {
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

    public void movePlayer (char direction) {
        Position newPosition = checkMovement(direction);
        if (newPosition == null)
            throw new InvalidMovementException("You cannot move in that direction");
        player.setPosition(newPosition);
    }

    public void playerAttack (Enemy enemy) {
        player.attack(enemy);
        enemy.attack(player);
        room.removeEnemy(enemy);
    }

    public void playerFlee (Position previousPosition) {
        player.takeDamage(50);
        player.setPosition(previousPosition);
    }

    public boolean checkWin () {
        if (room.getTile(player.getPosition()) == Tile.EXIT) {
            player.resetPlayerPosition();
            numberRoom++;
            return true;
        }
        return false;
    }

    public Enemy checkEnemy () {
        for (Enemy enemy : room.getEnemies()) {
            if (player.getPosition().equals(enemy.getPosition())) {
                return enemy;
            }
        }
        return null;
    }

    private Position checkMovement (char direction) {
        int y = player.getPosition().getY();
        int x = player.getPosition().getX();
        switch (direction) {
            case 'd' -> x++;
            case 'a' -> x--;
            case 'w' -> y--;
            case 's' -> y++;
            default -> throw new InputMismatchException("Invalid Input");
        }
        if (y > room.getHeight() - 1 || y < 0
                || x > room.getWidth() - 1 || x < 0)
            return null;

        if (!room.getTile(x, y).isWalkable())
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
