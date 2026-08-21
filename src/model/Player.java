package model;

import save.SaveData;

public class Player extends Entity{
    private int gold;
    private int swordDurability;

    public Player(String symbol, int life) {
        super(symbol, life, new Position(0, 0));
        this.swordDurability = 5;
    }

    public Player(String symbol, SaveData saveData) {
        super(symbol, saveData.getLife(), new Position(0, 0));
        this.swordDurability = 5;
    }

    public void resetPlayerPosition () {
        setPosition(0, 0);
    }

    @Override
    public void attack (Entity target) {
        if (hasSword()) {
            this.swordDurability -= 1;
            target.takeDamage(50);
            if (!hasSword()) {
                System.out.println("Your sword broke!");
            }
        }
    }

    public boolean hasSword () {
        return this.swordDurability > 0;
    }

    public void collectGold(int ghold) {
        if (ghold > 0)
            this.gold += ghold;
    }

    public int getGold() {
        return gold;
    }

    public int getSwordDurability() {
        return swordDurability;
    }
}
