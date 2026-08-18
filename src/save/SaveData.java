package save;

public class SaveData {
    private int life;
    private int diamonds;
    private int numberRoom;

    public SaveData(int life, int gold, int numberRoom) {
        this.life = life;
        this.diamonds = gold;
        this.numberRoom = numberRoom;
    }

    public int getLife() {
        return life;
    }

    public int getDiamonds() {
        return diamonds;
    }

    public int getNumberRoom() {
        return numberRoom;
    }
}
