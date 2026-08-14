package model;

public class Player {
    private String name;
    private int gold;
    private int life;
    private Position position;

    public Player(String name, int life, Position position, int gold) {
        this.name = name;
        this.life = life;
        this.position = position;
        this.gold = gold;
    }

    public void setPlayerPosition () {
        this.position = new Position(0, 0);
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
}
