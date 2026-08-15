package model;

public class Enemy {
    private EnemyType enemyType;
    private Position position;
    private int life;

    public Enemy(EnemyType enemyType, Position position, int life) {
        this.enemyType = enemyType;
        this.position = position;
        this.life = life;
    }

    public void takeDamage (int damage) {
        if (life > 0) {
            this.life -= damage;
        }
    }

    public char getSymbol () {
        return enemyType.getSymbol();
    }

    public EnemyType getEnemyType() {
        return enemyType;
    }

    public Position getPosition() {
        return position;
    }

    public int getLife() {
        return life;
    }
}
