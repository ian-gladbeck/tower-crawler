package engine;

import model.Player;
import model.Sword;
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
                case 2: swordSale(SwordType.WOODEN, p.getInventory().getGold());
                    break;
                case 3: swordSale(SwordType.STONE, p.getInventory().getGold());
                    break;
                case 4: swordSale(SwordType.GOLDEN, p.getInventory().getGold());
                    break;
                case 5: ui.printMessage("See you later...");
                    break;
            }
        }
    }

    private void swordSale (SwordType sword, int goldPlayer) {
        if (!validateSale(TABLE_VALUES.get(sword.getName()), goldPlayer)) {
            ui.printMessage("you no have gold enough");
            return;
        }

        if (!p.getInventory().hasSword()) {
            p.getInventory().addSword(sword);
            p.getInventory().spendGold(TABLE_VALUES.get(sword.getName()));
            ui.printMessage("+1 " + sword.getName());
        }
        else ui.printMessage("You already have a sword");

    }

    private boolean validateSale (int value, int playerGold) {
        return playerGold >= value;
    }
}
