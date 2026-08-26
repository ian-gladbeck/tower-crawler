package model.items;

public class HealingPotion extends Item{
    private int healAmount;

    public HealingPotion(String name, int price, int healAmount) {
        super(name, price);
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }
}
