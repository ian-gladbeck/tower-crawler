package ui;

import engine.GameManager;
import engine.MarketEngine;
import save.SaveManager;

public class MainMenu {
    private final ConsoleUI consoleUI;
    private final GameManager gameManager;
    private final MarketEngine marketEngine;

    public MainMenu(ConsoleUI consoleUI, GameManager gameManager, MarketEngine marketEngine) {
        this.consoleUI = consoleUI;
        this.gameManager = gameManager;
        this.marketEngine = marketEngine;
    }

    public void start() {
        consoleUI.clearScreen();
        int diamonds = gameManager.getGameEngine().getPlayer().getInventory().getGold();
        int numberRoom = gameManager.getGameEngine().getNumberRoom();
        consoleUI.printMainMenu(diamonds, numberRoom);
        int option = consoleUI.getOption(3);
        switch (option) {
            case 1 -> handlePlayLoop();
            case 2 -> handleSaveAndExit();
            case 3 -> handleOpenMarket();
        }
    }

    private void handlePlayLoop() {
        boolean isRunning = true;
        while (isRunning) {
            gameManager.startRoom();
            if (!gameManager.getGameEngine().getPlayer().isAlive()) {
                consoleUI.printMessage("GAME OVER");
                break;
            }
            consoleUI.printPostRoom();
            int choice = consoleUI.getOption(2);
            if (choice == 2) isRunning = false;
        }
    }

    private void handleOpenMarket () {
        marketEngine.openMarket();
    }

    private void handleSaveAndExit() {
        SaveManager.save(gameManager.getGameEngine().getPlayer(),
                gameManager.getGameEngine().getNumberRoom());
        consoleUI.printMessage("Game saved!");
        System.exit(0);
    }
}
