package engine;

import model.Player;
import model.items.HealingPotion;
import model.items.Item;
import model.items.Sword;
import model.items.SwordType;
import repository.ItemRepository;
import ui.ConsoleUI;
import java.util.Map;

public class MarketEngine {
    private final ItemRepository itemRepository;
    private final ConsoleUI ui;
    private final Player p;

    public MarketEngine(ItemRepository itemRepository, ConsoleUI ui, Player p) {
        this.itemRepository = itemRepository;
        this.ui = ui;
        this.p = p;
    }

    public void openMarket () {
        int option = 0;
        while (option != 5) {
            ui.printMarketMenu(p.getInventory().getGold());
            option = ui.getOption(5);
            switch (option) {
                case 1:
                    HealingPotion potion = new HealingPotion("Healing Potion", 15, 30);
                    if (validateSale(potion)) {
                        p.addItemToInventory(potion);
                        p.spendGold(potion.getPrice());
                    }
                    break;
                case 2: swordSale("wooden");
                    break;
                case 3: swordSale("stone");
                    break;
                case 4: swordSale("golden");
                    break;
                case 5: ui.printMessage("See you later...");
                    break;
            }
        }
    }

    private Sword generateSword(String type) {
        return switch (type) {
            case "stone" -> new Sword("Stone Sword",150, 10);
            case "golden" -> new Sword("Golden Sword",250, 25);
            default -> new Sword("Wooden Sword",15, 5);
        };
    }


    private void swordSale (String type) {
       Sword sword = generateSword(type);
       if (validateSale(sword)) {
           if (!p.hasSword()) {
               p.spendGold(sword.getPrice());
               p.addItemToInventory(sword);
           }
       }
    }

    private boolean validateSale (Item item) {
        return p.getGold() >= item.getPrice();
    }
}
