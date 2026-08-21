package ui;

import engine.GameManager;
import save.SaveManager;

public class MainMenu {
    private final ConsoleUI consoleUI;
    private final GameManager gameManager;

    public MainMenu(ConsoleUI consoleUI, GameManager gameManager) {
        this.consoleUI = consoleUI;
        this.gameManager = gameManager;
    }

    public void start() {
        int diamonds = gameManager.getGameEngine().getPlayer().getDiamonds();
        int numberRoom = gameManager.getGameEngine().getNumberRoom();
        consoleUI.printMainMenu(diamonds, numberRoom);
        int option = consoleUI.getOption(2);
        switch (option) {
            case 1 -> handlePlayLoop();
            case 2 -> handleSaveAndExit();
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

    private void handleSaveAndExit() {
        SaveManager.save(gameManager.getGameEngine().getPlayer(),
                gameManager.getGameEngine().getNumberRoom());
        consoleUI.printMessage("Game saved!");
        System.exit(0);
    }
}
