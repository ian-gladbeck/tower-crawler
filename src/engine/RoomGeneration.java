package engine;

import model.Player;
import model.Position;
import model.Room;
import model.Tile;

public class RoomGeneration {
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
            else if ((int)(Math.random() * 2) == 1) y++;
            else x++;
            room.getGrid()[y][x] = Tile.PATH;
        }
    }

    public Room createRoom () {
        createPath();
        return room;
    }
}
