package ui;

import model.Enemy;
import model.Player;
import model.Position;
import model.Room;

public class RoomRenderer {

    public void printRoom (Room room, Player player) {
        for (int i = 0; i < room.getHeight(); i++) {
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
            System.out.println();
        }
    }

    public void clearScreen() {
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
    }
}
