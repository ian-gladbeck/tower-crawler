package model.items;

public enum SwordType {
    WOODEN("Wooden Sword", 3),
    STONE("Stone Sword", 6),
    GOLDEN("Golden Sword", 10);

    private final String name;
    private final int durability;
    SwordType(String name, int durability) {
        this.name = name;
        this.durability = durability;
    }

    public String getName() {
        return name;
    }

    public int getDurability() {
        return durability;
    }
}
