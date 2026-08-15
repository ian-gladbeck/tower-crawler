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
                room.getGrid()[i][j] = null;
            }
        }
        room.getEnemies().clear();
    }

    private void putGoldInRoom () {
        for (int i = 0; i < room.getHeight(); i++) {
            for (int j = 0; j < room.getWidth(); j++) {
                if (random.nextInt(5) == 1
                        && room.getGrid()[i][j] == Tile.PATH)
                    room.getGrid()[i][j] = Tile.GOLD;
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
            room.getGrid()[y][x] = Tile.PATH;
        }
    }

    private void fillRoom () {
        for (int i = 0; i < room.getHeight(); i++) {
            for (int j = 0; j < room.getWidth(); j++) {
                if (i == 0 && j == 0)
                    room.getGrid()[i][j] = Tile.PATH;
                if (room.getGrid()[i][j] == Tile.PATH
                        || room.getGrid()[i][j] == Tile.GOLD) continue;
                if (random.nextBoolean())
                    room.getGrid()[i][j] = Tile.PATH;
                else
                    room.getGrid()[i][j] = Tile.BARRIER;
            }
        }
    }

    private void generateEnemies () {
        for (int i = 0; i < room.getHeight(); i++) {
            for (int j = 0; j < room.getWidth(); j++) {
                if (i == 0 && j == 0) continue;
                if (room.getGrid()[i][j] == Tile.BARRIER) continue;
                if (room.getGrid()[i][j] == Tile.EXIT) continue;
                if (random.nextInt(10) == 1) {
                    Enemy enemy = new Enemy(switch (random.nextInt(3)) {
                        case 1 -> EnemyType.VAMPIRE;
                        case 2 -> EnemyType.SKELETON;
                        default -> EnemyType.GOBLIN;
                    }, new Position(i, j), 50);
                    room.addEnemy(enemy);
                }
            }
        }
    }

    private void putExit () {
        room.getGrid()[room.getHeight() - 1][room.getWidth() - 1] = Tile.EXIT;
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
