package engine;

import model.Player;
import model.SwordType;
import ui.ConsoleUI;

import java.util.Hashtable;
import java.util.Map;

public class MarketEngine {
    private final Map<String, Integer> TABLE_VALUES = Map.of(
            "Healing Potion", 10,
            "Wooden Sword", 15,
            "Stone Sword", 30,
            "Golden Sword", 150
    );
    private final ConsoleUI ui;
    private final Player p;

    public MarketEngine(ConsoleUI ui, Player p) {
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
                    if (validateSale(TABLE_VALUES.get("Healing Potion"), p.getInventory().getGold())) {
                        p.getInventory().addHealingPotion(1);
                        p.getInventory().spendGold(TABLE_VALUES.get("Healing Potion"));
                        ui.printMessage("+1 Healing Potion!!");
                    }
                    else {
                        ui.printMessage("you no have gold enough");
                    }
                    break;
                case 2:
                    if (validateSale(TABLE_VALUES.get("Wooden Sword"), p.getInventory().getGold())) {
                        if (!p.getInventory().hasSword()) {
                            p.getInventory().addSword(SwordType.WOODEN);
                            p.getInventory().spendGold(TABLE_VALUES.get("Wooden Sword"));
                            ui.printMessage("+1 Wooden Sword");
                        }
                        else
                            ui.printMessage("You already have a sword");
                    }
                    else {
                        ui.printMessage("you no have gold enough");
                    }
                    break;
                case 3:
                    if (validateSale(TABLE_VALUES.get("Stone Sword"), p.getInventory().getGold())) {
                        if (!p.getInventory().hasSword()) {
                            p.getInventory().addSword(SwordType.STONE);
                            p.getInventory().spendGold(TABLE_VALUES.get("Stone Sword"));
                            ui.printMessage("+1 Stone Sword");
                        }
                        else
                            ui.printMessage("You already have a sword");
                    }
                    else {
                        ui.printMessage("you no have gold enough");
                    }
                    break;
                case 4:
                    if (validateSale(TABLE_VALUES.get("Golden Sword"), p.getInventory().getGold())) {
                        if (!p.getInventory().hasSword()) {
                            p.getInventory().addSword(SwordType.GOLDEN);
                            p.getInventory().spendGold(TABLE_VALUES.get("Golden Sword"));
                            ui.printMessage("+1 Golden Sword");
                        }
                        else
                            ui.printMessage("You already have a sword");
                    }
                    else {
                        ui.printMessage("you no have gold enough");
                    }
                    break;
                case 5:
                    ui.printMessage("See you later...");
                    break;
            }
        }
    }

    private boolean validateSale (int value, int playerGold) {
        return playerGold >= value;
    }
}
