package ui;

import model.Enemy;
import model.Player;
import model.Position;
import model.Room;

public class RoomRenderer {

    public void printRoom (Room room, Player player) {
        Enemy[][] enemies = new Enemy[room.getHeight()][room.getWidth()];
        for (Enemy enemy : room.getEnemies()) {
            Position pos = enemy.getPosition();
            enemies[pos.getY()][pos.getX()] = enemy;
        }
        for (int i = 0; i < room.getHeight(); i++) {
            for (int j = 0; j < room.getWidth(); j++) {
                if (player.getPosition().getY() == i
                        && player.getPosition().getX() == j) {
                    System.out.print(player.getSymbol() + " ");
                    continue;
                }
                Enemy enemy = enemies[i][j];
                if (enemy != null) {
                    System.out.print(enemy.getSymbol() + " ");
                    continue;
                }
                System.out.print(room.getGrid()[i][j].getSymbol() + " ");
            }
            System.out.println();
        }
    }

    public void clearScreen() {
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
    }
}
