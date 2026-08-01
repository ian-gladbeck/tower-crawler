package model;

public class Room {
    private int height;
    private int width;
    private Tile[][] grid;
    private Player player;

    public Room(int height, int width, Player player) {
        this.height = height;
        this.width = width;
        this.grid = new Tile[height][width];
        this.player = player;
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

    public Player getPlayer() {
        return player;
    }
}
