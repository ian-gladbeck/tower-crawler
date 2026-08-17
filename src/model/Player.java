package model;

public class Player {
    private String name;
    private int gold;
    private int life;
    private Position position;
    private boolean hasSword;
    private int swordDurability;

    public Player(String name, int life, Position position, int gold) {
        this.name = name;
        this.life = life;
        this.position = position;
        this.gold = gold;
        this.swordDurability = 10;
        this.hasSword = true;
    }

    public void setPlayerPosition () {
        this.position = new Position(0, 0);
    }

    public void takeDamage (int damage) {
        this.life -= damage;
    }

    public void attack () {
        if (this.swordDurability > 0) {
            this.swordDurability -= 1;
            if (this.swordDurability == 0) {
                this.hasSword = false;
                System.out.println("Your sword broke!");
            }
        }
    }


    public void collectGold (int gold) {
        if (gold > 0)
            this.gold += gold;
    }


    public int getGold() {
        return gold;
    }


    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isHasSword() {
        return hasSword;
    }

    public int getSwordDurability() {
        return swordDurability;
    }
}
