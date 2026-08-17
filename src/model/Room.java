package model;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int height;
    private int width;
    private Tile[][] grid;
    private List<Enemy> enemies = new ArrayList<>();

    public Room(int height, int width) {
        this.height = height;
        this.width = width;
        this.grid = new Tile[height][width];
    }

    public void addEnemy (Enemy enemy) {
        enemies.add(enemy);
    }

    public void removeEnemy (Enemy enemy) { enemies.remove(enemy); }

    public Enemy getEnemyInPosition (int y, int x) {
        for (Enemy enemy : enemies) {
            if (enemy.getPosition().getY() == y
                    && enemy.getPosition().getX() == x) {
                return enemy;
            }
        }
        return null;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Tile[][] getGrid() {
        return grid;
    }
}
