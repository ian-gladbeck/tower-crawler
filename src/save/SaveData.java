package save;

public class SaveData {
    private String name;
    private int life;
    private int gold;
    private int numberRoom;

    public SaveData(String name, int life, int gold, int numberRoom) {
        this.name = name;
        this.life = life;
        this.gold = gold;
        this.numberRoom = numberRoom;
    }

    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public int getGold() {
        return gold;
    }

    public int getNumberRoom() {
        return numberRoom;
    }
}
