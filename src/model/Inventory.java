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

    public boolean addItem (Item item) {
        if (item instanceof Sword swordItem)
            return addSword(swordItem);
        if (item instanceof HealingPotion potionItem)
            return addHealingPotion(potionItem);
        return false;
    }

    public void addGold(int gold) {
        if (gold <= 0) return;
        this.gold += gold;
    }

    public boolean addSword(Sword sword) {
        if (sword != null) {
            this.sword = sword;
            return true;
        }
        return false;
    }

    public boolean addHealingPotion(HealingPotion potion) {
        if (potions.size() >= 10) return false;
        potions.add(potion);
        return true;
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
}
