package engine;

import exception.InvalidMovementException;
import model.Enemy;
import model.Player;
import model.Room;
import ui.ConsoleUI;

import java.util.Scanner;

public class GameManager {
    private Scanner sc;
    private String lastEventMessage = "";
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
                consoleUI.clearScreen();
                handleRenderUI(room);
                if (!lastEventMessage.isEmpty()) {
                    consoleUI.printMessage(lastEventMessage);
                    lastEventMessage = "";
                }
                if (checkWinCondition()) break;
                handleMovement();
                processCombat();
                checkDiamond();
                if (!player.isAlive()) {
                    handleGameOver(room);
                    break;
                }
            }
            catch (InvalidMovementException e) {
                lastEventMessage = e.getMessage();
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
            lastEventMessage = "+10 GOLD!!";
    }


    private void handleMovement () throws InvalidMovementException {
        char direction = consoleUI.getMovementInput();
        gameEngine.movePlayer(direction);
    }

    public void handleGameOver (Room room) {
        consoleUI.clearScreen();
        consoleUI.printGameOver(gameEngine.getNumberRoom(), gameEngine.getPlayer().getInventory().getGold());
        int n = consoleUI.getOption(2);
        gameEngine.resetGame();
        if (n == 1) {
            startRoom();
        }
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
            lastEventMessage = "You don't have sword!!";
            return false;
        }
        gameEngine.playerAttack(enemy);
        lastEventMessage = "You Kill enemy, but he attacks you\n-20 life!!";
        return true;
    }

    private void handlePlayerFlee () {
        gameEngine.playerFlee();
        lastEventMessage = "You escape, but enemy attacks you\n-50 life!!";
    }

    public GameEngine getGameEngine() {
        return gameEngine;
    }

    public ConsoleUI getConsoleUI() {
        return consoleUI;
    }
}
