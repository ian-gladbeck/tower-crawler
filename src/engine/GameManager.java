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
            combat(enemy);
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


    private void combat (Enemy enemy) {
        while (true) {
            if (consoleUI.getCombatInput() == 1) {
                if (handlePlayerAttack(enemy)) break;
            }
            else {
                handlePlayerFlee();
                break;
            }
        }
    }

    private boolean handlePlayerAttack(Enemy enemy) {
        if (!gameEngine.canPlayerAttack()) {
            consoleUI.printMessage("You don't have sword!!");
            return false;
        }
        gameEngine.playerAttack(enemy);
        consoleUI.printMessage("You Kill enemy, but he attacks you\n-20 life!!");
        return true;
    }

    private void handlePlayerFlee () {
        gameEngine.playerFlee();
        consoleUI.printMessage("You escape, but enemy attacks you\n-50 life!!");
    }

    public GameEngine getGameEngine() {
        return gameEngine;
    }

    public ConsoleUI getConsoleUI() {
        return consoleUI;
    }
}
