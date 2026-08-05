package model;

public class Player {
    private String name;
    private int life;
    private Position position;

    public Player(String name, int life, Position position) {
        this.name = name;
        this.life = life;
        this.position = position;
    }

    public void setPlayerPosition () {
        this.position = new Position(0, 0);
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
