package engine;

import model.Room;
import model.Tile;

import java.util.Random;

public class RoomGeneration {
    private static Random random = new Random();
    private Room room;

    public RoomGeneration(Room room) {
        this.room = room;
    }

    private void createPath () {
        int x = 0;
        int y = 0;
        while (y < room.getHeight() - 1 || x < room.getWidth() - 1) {
            if (y == room.getHeight() - 1) x++;
            else if (x == room.getWidth() - 1) y++;
            else if (random.nextBoolean()) y++;
            else x++;
            room.getGrid()[y][x] = Tile.PATH;
        }
    }

    private void fillRoom () {
        for (int i = 0; i < room.getHeight(); i++) {
            for (int j = 0; j < room.getWidth(); j++) {
                if (i == 0 && j == 0)
                    room.getGrid()[i][j] = Tile.PATH;
                if (room.getGrid()[i][j] == Tile.PATH) continue;
                if (random.nextBoolean())
                    room.getGrid()[i][j] = Tile.PATH;
                else
                    room.getGrid()[i][j] = Tile.BARRIER;
            }
        }
    }

    private void putExit () {
        room.getGrid()[room.getHeight() - 1][room.getWidth() - 1] = Tile.EXIT;
    }

    public Room createRoom () {
        createPath();
        fillRoom();
        putExit();
        return room;
    }
}
