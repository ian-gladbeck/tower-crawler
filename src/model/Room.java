package model;

public class Room {
    private int height;
    private int width;
    private Tile[][] grid;

    public Room(int height, int width) {
        this.height = height;
        this.width = width;
        this.grid = new Tile[height][width];
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
