package engine;

import exception.InvalidMovementException;
import model.Room;
import ui.RoomRenderer;

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
        while (true) {
            try {
                System.out.println("    ==== ROOM " + gameEngine.getNumberRoom() + " ====");
                roomRenderer.printRoom(room, gameEngine.getPlayer());
                if (gameEngine.checkWin()) {
                    System.out.println("You Win!!!");
                    break;
                }
                System.out.print("Move (w/a/s/d): ");
                char direction = sc.nextLine().toLowerCase().charAt(0);
                gameEngine.movePlayer(direction);
                if (gameEngine.checkGold(gameEngine.getPlayer().getPosition()))
                    System.out.println("+10 GOLD!!");
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
