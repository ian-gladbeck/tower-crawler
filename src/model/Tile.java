package model;

public enum Tile {
    PATH("  ", true),
    BARRIER("\uD83E\uDDF1", false),
    GOLD("\uD83D\uDC8E", true),
    EXIT("\uD83D\uDEAA", true);

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
