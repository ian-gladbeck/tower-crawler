package model;

import model.items.HealingPotion;
import model.items.Item;
import model.items.Sword;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private int gold;
    private Sword sword;
    private List<HealingPotion> potions;

    public Inventory(int gold, Sword sword) {
        this.gold = gold;
        this.sword = sword;
        this.potions = new ArrayList<>();
    }

    public void addItem (Item item) {
        if (item instanceof Sword swordItem) {
            addSword(swordItem);
            return;
        }
        if (item instanceof HealingPotion potionItem) {
            addHealingPotion(potionItem);
        }
    }

    public void addGold(int gold) {
        if (gold <= 0) return;
        this.gold += gold;
    }

    public void addSword(Sword sword) {
        if (sword != null) {
            this.sword = sword;
        }
    }

    public void addHealingPotion(HealingPotion potion) {
        if (potions.size() >= 10) return;
        potions.add(potion);
    }

    public void spendGold (int amount) {
        if (amount <= 0) return;
        if (this.gold >= amount) {
            this.gold -= amount;
        }
    }

    public boolean hasSword () {
        return this.sword != null;
    }

    public void useSword () {
        if (hasSword()) {
            this.sword.useSword();
            if (this.sword.getDurability() <= 0)
                this.sword = null;
        }
    }

    public void spendHealingPotion (Player player) {
        if (!potions.isEmpty()) {
            HealingPotion potion = potions.removeFirst();
            player.cure(potion.getHealAmount());
        }
    }

    public int getGold() {
        return gold;
    }

    public Sword getSword() {
        return sword;
    }

    public int getSwordDurability() {
        if (hasSword())
            return this.sword.getDurability();
        return 0;
    }

    public int getHealingPotion() {
        return potions.size() - 1;
    }
}
