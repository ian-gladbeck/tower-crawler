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

    public abstract void attack ();

    public void setPosition (int y, int x) {
        this.position.setPosition(y, x);
    }

    public void setPosition (Position pos) {
        this.position.setPosition(pos.getY(), pos.getX());
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
