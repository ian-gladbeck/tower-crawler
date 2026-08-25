package repository;

import model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {
    private List<Item> items = new ArrayList<>();

    public ItemRepository(List<Item> items) {
        this.items = items;
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
