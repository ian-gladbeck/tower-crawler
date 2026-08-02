package renderer;

import model.Player;
import model.Room;
import model.Tile;

public class RoomRenderer {

    public static void printRoom (Room room, Player player) {
        for (int i = 0; i < room.getHeight(); i++) {
            for (int j = 0; j < room.getWidth(); j++) {
                if (player.getPosition().getY() == i
                        && player.getPosition().getX() == j) {
                    System.out.print("p ");
                    continue;
                }
                System.out.print(getTile(room.getGrid()[i][j]) + " ");
            }
            System.out.println();
        }
    }

    private static char getTile (Tile tile) {
        return switch (tile) {
            case PATH -> '.';
            case BARRIER -> '#';
            case EXIT -> '!';
            case GOLD -> '$';
        };
    }
}
