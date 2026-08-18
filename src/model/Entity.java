package model;

public abstract class Entity {
    private Position position;
    private int life;
    private final String symbol;

    public Entity(String symbol, int life, Position position) {
        this.symbol = symbol;
        this.life = life;
        this.position = position;
    }

    public boolean isAlive () {
        return this.life > 0;
    }

    public abstract void attack (Entity target);

    public void setPosition (int x, int y) {
        this.position.setPosition(x, y);
    }

    public void setPosition (Position pos) {
        this.position.setPosition(pos.getX(), pos.getY());
    }

    public void takeDamage (int damage) {
        this.life = Math.max(0, this.life - damage);
    }


    public Position getPosition() {
        return position;
    }

    public int getLife() {
        return life;
    }

    public String getSymbol() {
        return symbol;
    }
}
