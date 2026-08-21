package ui;

import model.*;

import java.util.Scanner;

public class ConsoleUI {
    private final Scanner sc;

    public ConsoleUI(Scanner sc) {
        this.sc = sc;
    }

    public void printMessage (String message) {
        System.out.println(message);
    }

    public void printLogo() {
        System.out.println("          ___________________  __      _______________________          \n" +
                "          \\__    ___/\\_____  \\/  \\    /  \\_   _____/\\______   \\         \n" +
                "            |    |    /   |   \\   \\/\\/   /|    __)_  |       _/         \n" +
                "            |    |   /    |    \\        / |        \\ |    |   \\         \n" +
                "            |____|   \\_______  /\\__/\\  / /_______  / |____|_  /         \n" +
                "                             \\/      \\/          \\/         \\/          \n" +
                "___________________    _____  __      __.____     _____________________ \n" +
                "\\_   ___ \\______   \\  /  _  \\/  \\    /  \\    |    \\_   _____/\\______   \\\n" +
                "/    \\  \\/|       _/ /  /_\\  \\   \\/\\/   /    |     |    __)_  |       _/\n" +
                "\\     \\___|    |   \\/    |    \\        /|    |___  |        \\ |    |   \\\n" +
                " \\______  /____|_  /\\____|__  /\\__/\\  / |_______ \\/_______  / |____|_  /\n" +
                "        \\/       \\/         \\/      \\/          \\/        \\/         \\/ ");
    }

    public void printMainMenu (int diamonds, int numberRoom) {
        printLogo();
        System.out.println("             ╔══════════════════════════════════════════╗");
        System.out.println("             ║ Diamonds" + diamonds + "   " +
                "      ║       Room: " + numberRoom + "       ║");
        System.out.println("             ╠══════════════════════════════════════════╣");
        System.out.println("             ║  [1]    Play Room                        ║");
        System.out.println("             ║  [2]    Save and Exit                    ║");
        System.out.println("             ╚══════════════════════════════════════════╝");
    }

    public void printPostRoom () {
        System.out.println("[1]- Next Room");
        System.out.println("[2]- Menu");
    }


    public int getOption (int maxOption) {
        int choice = 0;
        while (choice < 1 || choice > maxOption){
            System.out.print("➤enter: ");
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
                if (choice < 1 || choice > maxOption) {
                    System.out.println("Invalid Option! Choose between 1 and " + maxOption);
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid Input! please enter a number");
            }
        }
        return choice;
    }

    public char getMovementInput () {
        String valid = "wasd";
        while (true) {
            System.out.print("Move (w/a/s/d): ");
            String direction = sc.nextLine().trim().toLowerCase();
            if (direction.length() != 1) {
                System.out.println("Invalid Input! Enter (w/a/s/d)");
                continue;
            }
            if (valid.contains(direction))
                return direction.charAt(0);
        }
    }

    public void printHUD (Player player, int numRoom) {
        System.out.println("=====ROOM " + numRoom + "=====");
        System.out.println("Your Life: " + player.getLife());
        if (player.hasSword())
            System.out.println("Sword Durability: " + player.getSwordDurability());
    }

    public void printRoom (Room room, Player player) {
        System.out.println("*------------------------*");
        for (int i = 0; i < room.getHeight(); i++) {
            System.out.print("|");
            for (int j = 0; j < room.getWidth(); j++) {
                Position currentPos = new Position(j, i);
                if (player.getPosition().equals(currentPos))
                    System.out.print(player.getSymbol() + " ");
                else {
                    Enemy enemy = room.getEnemyAt(currentPos);
                    String symbol = (enemy != null ? enemy.getSymbol()
                            : room.getTile(currentPos).getSymbol());
                    System.out.print(symbol + " ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("*------------------------*");
    }

    public int getCombatInput () {
        int choice = 0;
        while(choice != 1 && choice != 2) {
            System.out.println("[1]- Attack");
            System.out.println("[2]- Flee");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice != 1 && choice != 2) {
                    System.out.println("Invalid Input! Enter 1 or 2");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid Input! please enter a number");
            }
        }
        return choice;
    }


    public void clearScreen() {
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
    }
}
