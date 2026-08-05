package engine;

import exception.InvalidMovementException;
import model.Room;
import renderer.RoomRenderer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameManager {
    private Scanner sc;
    private GameEngine gameEngine;
    private RoomRenderer roomRenderer;

    public GameManager(Scanner sc, GameEngine gameEngine, RoomRenderer roomRenderer) {
        this.sc = sc;
        this.gameEngine = gameEngine;
        this.roomRenderer = roomRenderer;
    }

    public void startRoom () {
        Room room = gameEngine.getRoomGeneration().createRoom();
        boolean win = false;
        while (!win) {
            try {
                System.out.println("    ==== ROOM " + (gameEngine.getNumberRoom() + 1) + " ====");
                roomRenderer.printRoom(room, gameEngine.getPlayer());
                System.out.print("Move (w/a/s/d): ");
                char direction = sc.next().toLowerCase().charAt(0);
                gameEngine.movePlayer(direction);
                if (gameEngine.checkWin()) {
                    System.out.println("You Win!!!");
                    win = true;
                }
            }
            catch(InvalidMovementException | InputMismatchException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public GameEngine getGameEngine() {
        return gameEngine;
    }

    public RoomRenderer getRoomRenderer() {
        return roomRenderer;
    }
}
