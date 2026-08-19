package engine;

import exception.InvalidMovementException;
import model.Enemy;
import model.Player;
import model.Position;
import model.Room;
import ui.ConsoleUI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameManager {
    private Scanner sc;
    private GameEngine gameEngine;
    private ConsoleUI consoleUI;

    public GameManager(Scanner sc, GameEngine gameEngine, ConsoleUI ui) {
        this.sc = sc;
        this.gameEngine = gameEngine;
        this.consoleUI = ui;
    }

    public void startRoom () {
        Room room = gameEngine.getRoomGeneration().createRoom();
        while (true) {
            try {
                consoleUI.printHUD(gameEngine.getPlayer(), gameEngine.getNumberRoom());
                consoleUI.printRoom(room, gameEngine.getPlayer());
                if (gameEngine.checkWin()) {
                    consoleUI.printMessage("You Win!!!");
                    break;
                }
                Position lastPosition = new Position(gameEngine.getPlayer().getPosition());
                char direction = consoleUI.getMovementInput();
                gameEngine.movePlayer(direction);
                Enemy enemy = gameEngine.checkEnemy();
                if (enemy != null) {
                    combat(gameEngine.getPlayer(), enemy, lastPosition);
                }
                if (gameEngine.checkDiamond(gameEngine.getPlayer().getPosition()))
                    consoleUI.printMessage("+10 DIAMONDS!!");
            }
            catch(InvalidMovementException e) {
                consoleUI.printMessage(e.getMessage());
            }
        }
    }

    private void combat (Player player, Enemy enemy, Position lastPosition) {
        int choice = 3;
        while (choice != 1 && choice != 2) {
            System.out.println("[1]- Attack");
            System.out.println("[2]- Flee");
            choice = Integer.parseInt(sc.nextLine());
            if (choice == 1) {
                if (!player.hasSword()) {
                    System.out.println("You don't have sword!!");
                    choice = 3;
                    continue;
                }
                gameEngine.playerAttack(enemy);
                System.out.println("You Kill enemy, but he attacks you");
                System.out.println("-20 Life!");
            }
            else if (choice == 2) {
                gameEngine.playerFlee(lastPosition);
                System.out.println("You escape, but enemy attacks you");
                System.out.println("-50 life!");
            }
            else {
                System.out.println("Invalid Input");
            }
        }
    }

    public GameEngine getGameEngine() {
        return gameEngine;
    }

    public ConsoleUI getConsoleUI() {
        return consoleUI;
    }
}
