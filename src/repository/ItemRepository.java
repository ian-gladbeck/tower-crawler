package repository;

import model.items.HealingPotion;
import model.items.Item;
import model.items.Sword;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {
    private List<Item> items = new ArrayList<>();

    public ItemRepository() {
        putCatalog();
    }

    private void putCatalog () {
        items.add(new HealingPotion("Healing Potion", 15, 30));
        items.add(new Sword("Wooden Sword", 15, 5));
        items.add(new Sword("Stone Sword", 100, 10));
        items.add(new Sword("Golden Sword", 300, 25));
    }

    public Item getItem (String name) {
        return items.stream()
                .filter(i -> i.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void addItem (Item item) {
        if (getItem(item.getName()) != null)
            throw new RuntimeException("This item has already been added.");
        items.add(item);
    }

    public boolean removeItem (String name) {
        return items.removeIf(i -> i.getName().equals(name));
    }

    public List<Item> getAll () {
        return List.copyOf(items);
    }
 }
