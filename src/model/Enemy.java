package model;

public class Enemy {
    private Position position;
    private int life;
    private final String symbol = "\uD83D\uDC79";

    public Enemy(Position position, int life) {
        this.position = position;
        this.life = life;
    }

    public void takeDamage (int damage) {
        if (life > 0) {
            this.life -= damage;
        }
    }

    public String getSymbol () {
        return symbol;
    }

    public Position getPosition() {
        return position;
    }

    public int getLife() {
        return life;
    }
}
