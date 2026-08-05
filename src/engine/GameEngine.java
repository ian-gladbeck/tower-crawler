package engine;

import exception.InvalidMovementException;
import model.Player;
import model.Position;
import model.Room;
import model.Tile;

import java.util.InputMismatchException;

public class GameEngine {
    private static int numberRoom;
    private Player player;
    private Room room;
    private RoomGeneration roomGeneration;

    public GameEngine(Player player, Room room, RoomGeneration roomGeneration) {
        this.player = player;
        this.room = room;
        this.roomGeneration = roomGeneration;
    }

    public void movePlayer (char direction) {
        Position newPosition = checkMovement(direction);
        if (newPosition == null)
            throw new InvalidMovementException("You cannot move in that direction");
        player.getPosition().setPosition(newPosition.getY(),
                newPosition.getX());
    }

    public boolean checkWin () {
        if (room.getGrid()[player.getPosition().getY()]
                [player.getPosition().getX()] == Tile.EXIT) {
            player.setPayerPosition();
            numberRoom++;
            return true;
        }
        return false;
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

        if (room.getGrid()[y][x] == Tile.BARRIER)
            return null;

        return new Position(y, x);
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
