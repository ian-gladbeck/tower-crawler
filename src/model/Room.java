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

    public Tile getTile (int y, int x) {
        return grid[y][x];
    }

    public Tile getTile (Position pos) {
        return grid[pos.getY()][pos.getX()];
    }

    public void setTile(int y, int x, Tile tile) {
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
