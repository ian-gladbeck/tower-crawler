package engine;

import exception.InvalidMovementException;
import model.Player;
import model.Position;
import model.Room;
import model.Tile;
import renderer.RoomRenderer;

import java.util.Scanner;

public class GameEngine {
    private static int numberRoom;
    private Player player;
    private Room room;

    public GameEngine(Player player, Room room) {
        this.player = player;
        this.room = room;
    }

    public void startRoom(Scanner sc) {
        boolean win = false;
        while (!win) {
            try {
                RoomRenderer.printRoom(room, player);
                char direction = sc.next().toLowerCase().charAt(0);
                movePlayer(direction);
                if (checkWin())
                    win = true;
            }
            catch(InvalidMovementException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void movePlayer (char direction) {
        Position newPosition = checkMovement(direction);
        if (newPosition == null)
            throw new InvalidMovementException("You cannot move in that direction");
        player.getPosition().setPosition(newPosition.getY(),
                newPosition.getX());
    }

    private boolean checkWin () {
        return player.getPosition().getY() == room.getHeight() - 1
                && player.getPosition().getX() == room.getWidth() - 1;
    }

    private Position checkMovement (char direction) {
        int y = player.getPosition().getY();
        int x = player.getPosition().getX();
        switch (direction) {
            case 'd' -> x++;
            case 'a' -> x--;
            case 'w' -> y--;
            case 's' -> y++;
        }
        if (y > room.getHeight() - 1 || y < 0
                || x > room.getWidth() - 1 || x < 0)
            return null;

        if (room.getGrid()[y][x] == Tile.BARRIER)
            return null;

        return new Position(y, x);
    }

    public static int getNumberRoom() {
        return numberRoom;
    }

    public Player getPlayer() {
        return player;
    }

    public Room getRoom() {
        return room;
    }
}
