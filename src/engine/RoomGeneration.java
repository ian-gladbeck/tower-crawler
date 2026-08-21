package engine;

import model.*;

import java.util.Random;

public class RoomGeneration {
    private static Random random = new Random();
    private Room room;

    public RoomGeneration(Room room) {
        this.room = room;
    }

    private void resetRoom () {
        for (int i = 0; i < room.getHeight(); i++) {
            for (int j = 0; j < room.getWidth(); j++) {
                room.setTile(j, i, null);
            }
        }
        room.getEnemies().clear();
    }

    private void putGoldInRoom () {
        for (int i = 0; i < room.getHeight(); i++) {
            for (int j = 0; j < room.getWidth(); j++) {
                if (random.nextInt(5) == 1
                        && room.getTile(j, i) == Tile.PATH)
                    room.setTile(j, i, Tile.GOLD);
            }
        }
    }


    private void createPath () {
        int x = 0;
        int y = 0;
        while (y < room.getHeight() - 1 || x < room.getWidth() - 1) {
            if (y == room.getHeight() - 1) x++;
            else if (x == room.getWidth() - 1) y++;
            else if (random.nextBoolean()) y++;
            else x++;
            room.setTile(x, y, Tile.PATH);
        }
    }

    private void fillRoom () {
        for (int i = 0; i < room.getHeight(); i++) {
            for (int j = 0; j < room.getWidth(); j++) {
                if (i == 0 && j == 0)
                    room.setTile(j, i, Tile.PATH);
                if (room.getTile(j, i) == Tile.PATH
                        || room.getTile(j, i) == Tile.GOLD) continue;
                if (random.nextBoolean())
                    room.setTile(j, i, Tile.PATH);
                else
                    room.setTile(j, i, Tile.BARRIER);
            }
        }
    }

    private void generateEnemies () {
        for (int i = 0; i < room.getHeight(); i++) {
            for (int j = 0; j < room.getWidth(); j++) {
                if (i == 0 && j == 0) continue;
                if (i == room.getHeight() - 1 && j == room.getWidth() - 1) continue;
                if (room.getTile(j, i) == Tile.BARRIER) continue;
                if (room.getTile(j, i) == Tile.EXIT) continue;
                if (random.nextInt(10) == 1) {
                    Enemy enemy = new Enemy(ArtTiles.getEnemySymbol(), 50, new Position(j, i));
                    room.addEnemy(enemy);
                }
            }
        }
    }

    private void putExit () {
        room.setTile(room.getWidth() - 1, room.getHeight() - 1, Tile.EXIT);
    }

    public Room createRoom () {
        resetRoom();
        createPath();
        putGoldInRoom();
        fillRoom();
        generateEnemies();
        putExit();
        return room;
    }
}
