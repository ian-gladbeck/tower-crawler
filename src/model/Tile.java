package model;

public enum Tile {
    PATH('.'),
    BARRIER('#'),
    GOLD('$'),
    EXIT('!');

    private final char symbol;

    Tile(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
