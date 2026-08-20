package engine;

import exception.InvalidMovementException;
import model.Enemy;
import model.Player;
import model.Room;
import ui.ConsoleUI;

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
        Room room = gameEngine.generateRoom();
        gameLoop(room, gameEngine.getPlayer());
    }

    private void gameLoop (Room room, Player player) {
        while (player.isAlive()) {
            try {
                handleRenderUI(room);
                if (checkWinCondition()) break;
                handleMovement();
                consoleUI.clearScreen();
                processCombat();
                checkDiamond();
            }
            catch (InvalidMovementException e) {
                consoleUI.printMessage(e.getMessage());
            }
        }
    }

    private void handleRenderUI (Room room) {
        consoleUI.printHUD(gameEngine.getPlayer(), gameEngine.getNumberRoom());
        consoleUI.printRoom(room, gameEngine.getPlayer());
    }

    private void processCombat() {
        Enemy enemy = gameEngine.checkEnemy();
        if (enemy != null)
            combat(gameEngine.getPlayer(), enemy);
    }

    private boolean checkWinCondition() {
        if (gameEngine.checkWin()) {
            consoleUI.printMessage("You Win!!!");
            gameEngine.nextRoom();
            return true;
        }
        return false;
    }

    private void checkDiamond () {
        if (gameEngine.checkDiamond(gameEngine.getPlayerPosition()))
            consoleUI.printMessage("+10 DIAMONDS!!");
    }


    private void handleMovement () throws InvalidMovementException {
        char direction = consoleUI.getMovementInput();
        gameEngine.movePlayer(direction);
    }


    private void combat (Player player, Enemy enemy) {
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
                gameEngine.playerFlee();
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
