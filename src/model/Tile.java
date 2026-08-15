package model;

public enum Tile {
    PATH("  "),
    BARRIER("\uD83E\uDDF1"),
    GOLD("\uD83D\uDC8E"),
    EXIT("\uD83D\uDEAA");

    private final String symbol;

    Tile(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
