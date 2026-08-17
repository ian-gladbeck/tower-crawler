package ui;

import model.Enemy;
import model.Player;
import model.Position;
import model.Room;

public class RoomRenderer {

    public void printRoom (Room room, Player player) {
        for (int i = 0; i < room.getHeight(); i++) {
            for (int j = 0; j < room.getWidth(); j++) {
                if (player.getPosition().getY() == i
                        && player.getPosition().getX() == j) {
                    System.out.print("\uD83D\uDC82 ");
                    continue;
                }
                Enemy enemy = room.getEnemyInPosition(i, j);
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
