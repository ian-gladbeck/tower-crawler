package model;

import model.items.SwordType;

public class Inventory {
    private int gold;
    private SwordType sword;
    private int swordDurability;
    private int healingPotion;

    public Inventory() {
        this.gold = 0;
        this.sword = null;
        this.swordDurability = 0;
        this.healingPotion = 0;
    }

    public void resetInventory () {
        this.gold = 0;
        this.sword = SwordType.WOODEN;
        this.swordDurability = sword.getDurability();
        this.healingPotion = 0;
    }

    public void addGold(int gold) {
        if (gold <= 0) return;
        this.gold += gold;
    }

    public void addSword(SwordType sword) {
        if (sword != null) {
            this.sword = sword;
            this.swordDurability = sword.getDurability();
        }
    }

    public void addHealingPotion(int healingPotion) {
        if (healingPotion <= 0) return;
        this.healingPotion += healingPotion;
    }

    public boolean spendGold (int amount) {
        if (amount <= 0) return false;
        if (this.gold >= amount) {
            this.gold -= amount;
            return true;
        } else return false;
    }

    public boolean hasSword () {
        return this.sword != null;
    }

    public void useSword () {
        if (hasSword()) {
            swordDurability--;
            if (swordDurability <= 0)
                this.sword = null;
        }
    }

    public void spendHealingPotion (Player player) {
        if (this.healingPotion > 0) {
            player.cure(50);
            this.healingPotion--;
        }
    }

    public int getGold() {
        return gold;
    }

    public SwordType getSword() {
        return sword;
    }

    public int getSwordDurability() {
        return swordDurability;
    }

    public int getHealingPotion() {
        return healingPotion;
    }
}
