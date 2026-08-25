package model;

import save.SaveData;

public class Player extends Entity{
    private final Inventory inventory;

    public Player(String symbol, int life, Inventory inventory) {
        super(symbol, life, new Position(0, 0));
        this.inventory = inventory;
    }

    public Player(String symbol, SaveData saveData) {
        super(symbol, saveData.getLife(), new Position(0, 0));
        this.inventory = new Inventory();
    }

    public void reset () {
        this.life = 100;
        this.position = new Position(0, 0);
        this.inventory.resetInventory();
    }

    public void resetPlayerPosition () {
        setPosition(0, 0);
    }

    @Override
    public void attack (Entity target) {
        if (this.inventory.hasSword()) {
            this.inventory.useSword();
            target.takeDamage(50);
            if (!this.inventory.hasSword()) {
                System.out.println("Your sword broke!");
            }
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void collectGold(int gold) {
        this.inventory.addGold(gold);
    }

    public void cure (int life) {
        if (life > 0)
            this.life = Math.min(this.life + life, 100);
    }
}
