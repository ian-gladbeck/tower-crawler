package ui;

import engine.GameManager;
import save.SaveManager;

import java.util.Scanner;

public class MainMenu {
    private final Scanner sc;
    private GameManager gameManager;

    public MainMenu(Scanner sc, GameManager gameManager) {
        this.sc = sc;
        this.gameManager = gameManager;
    }

    public void initialMenu () {
        try {
            System.out.println("===TOWER CRAWLER===");
            System.out.println("[1]- Play Room " +
                    (gameManager.getGameEngine().getNumberRoom() + 1));
            System.out.println("[2]- Exit");
            System.out.print("Enter: ");
            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    while (option != 2) {
                        gameManager.startRoom();
                        System.out.println("[1]- Next Room");
                        System.out.println("[2]- Menu");
                        System.out.print("Enter: ");
                        option = Integer.parseInt(sc.nextLine());
                    }
                    break;
                case 2:
                    SaveManager.save(gameManager.getGameEngine().getPlayer(), gameManager.getGameEngine().getNumberRoom());
                    System.exit(0);
                    break;
            }
        }
        catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
