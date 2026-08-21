package model;

public enum Tile {
    PATH(true),
    BARRIER(false),
    GOLD(true),
    EXIT(true);

    private final boolean walkable;

    Tile(boolean walkable) {
        this.walkable = walkable;
    }


    public boolean isWalkable() {
        return walkable;
    }
}
