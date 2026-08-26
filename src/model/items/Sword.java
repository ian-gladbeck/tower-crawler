package model.items;

public class Sword extends Item{
    private int durability;
    public Sword(String name, int price, int durability) {
        super(name, price);
        this.durability = durability;
    }

    public int getDurability() {
        return durability;
    }
}
