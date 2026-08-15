package model;

public enum EnemyType {
    VAMPIRE('V'),
    GOBLIN('G'),
    SKELETON('S');

    private final char symbol;

    EnemyType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
