package model;

public class Room {
    private Tile[][] grid;
    private Player player;

    public Room(Tile[][] grid, Player player) {
        this.grid = grid;
        this.player = player;
    }

    public Tile[][] getGrid() {
        return grid;
    }

    public Player getPlayer() {
        return player;
    }
}
