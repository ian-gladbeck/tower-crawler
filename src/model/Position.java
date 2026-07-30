package model;

public class Position {
    private int y;
    private int x;

    public Position(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setPosition (int y, int x) {
        this.x = x;
        this.y = y;
    }
}
