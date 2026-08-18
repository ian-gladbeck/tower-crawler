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

    public Enemy getEnemyAt (Position pos) {
        for (Enemy enemy : enemies) {
            if (enemy.getPosition().equals(pos))
                return enemy;
        }
        return null;
    }

    public boolean isWithinBounds (int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public Tile getTile (int x, int y) {
        return grid[y][x];
    }

    public Tile getTile (Position pos) {
        return grid[pos.getY()][pos.getX()];
    }

    public void setTile(int x, int y, Tile tile) {
        this.grid[y][x] = tile;
    }

    public void setTile(Position pos, Tile tile) {
        this.grid[pos.getY()][pos.getX()] = tile;
    }

    public void addEnemy (Enemy enemy) {
        enemies.add(enemy);
    }

    public void removeEnemy (Enemy enemy) { enemies.remove(enemy); }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
