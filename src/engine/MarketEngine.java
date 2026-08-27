package engine;

import exception.AlreadyHasItemException;
import exception.InsufficientGoldException;
import exception.InventoryFullException;
import model.Player;
import model.items.HealingPotion;
import model.items.Sword;
import repository.ItemRepository;
import ui.ConsoleUI;

public class MarketEngine {
    private final ItemRepository itemRepository;
    private final ConsoleUI ui;
    private final Player p;

    public MarketEngine(ItemRepository itemRepository, ConsoleUI ui, Player p) {
        this.itemRepository = itemRepository;
        this.ui = ui;
        this.p = p;
    }

    public void openMarket() {
        int option = 0;
        while (option != 5) {
            try {
                ui.printMarketMenu(p.getInventory().getGold());
                option = ui.getOption(5);
                switch (option) {
                    case 1:
                        HealingPotion potion = new HealingPotion("Healing Potion", 15, 30);
                        p.spendGold(potion.getPrice());
                        p.addItemToInventory(potion);
                        break;
                    case 2:
                        swordSale("wooden");
                        break;
                    case 3:
                        swordSale("stone");
                        break;
                    case 4:
                        swordSale("golden");
                        break;
                    case 5:
                        ui.printMessage("See you later...");
                        break;
                }
            } catch (InsufficientGoldException | InventoryFullException | AlreadyHasItemException e) {
                ui.printMessage(e.getMessage());
            }
        }

    }

    private Sword generateSword(String type) {
        return switch (type) {
            case "stone" -> new Sword("Stone Sword", 100, 10);
            case "golden" -> new Sword("Golden Sword", 300, 25);
            default -> new Sword("Wooden Sword", 15, 5);
        };
    }


    private void swordSale(String type) {
        Sword sword = generateSword(type);
        p.spendGold(sword.getPrice());
        p.addItemToInventory(sword);
    }
}
