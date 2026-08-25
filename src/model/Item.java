package model;

public class Item {
    private final String name;
    private final int price;
    private final int usesLeft;

    public Item(String name, int price, int usesLeft) {
        this.name = name;
        this.price = price;
        this.usesLeft = usesLeft;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getUsesLeft() {
        return usesLeft;
    }

    @Override
    public String toString() {
        return String.format("%s, Uses: %d, Price: %d Gold", name, usesLeft, price);
    }
}
