package model;

public enum Tile {
    PATH(".", true),
    BARRIER("#", false),
    GOLD("$", true),
    EXIT("!", true);

    private final String symbol;
    private final boolean walkable;

    Tile(String symbol, boolean walkable) {
        this.symbol = symbol;
        this.walkable = walkable;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isWalkable() {
        return walkable;
    }
}
