package model;

public class Enemy extends Entity {
    public Enemy(String symbol, int life, Position position) {
        super(symbol, life, position);
    }

    @Override
    public void attack(Entity target) {
        target.takeDamage(20);
    }
}
