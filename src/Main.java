import engine.GameEngine;
import engine.GameManager;
import engine.MarketEngine;
import engine.RoomGeneration;
import model.ArtTiles;
import model.Inventory;
import model.Player;
import model.Room;
import model.items.Sword;
import repository.ItemRepository;
import save.SaveData;
import save.SaveManager;
import ui.MainMenu;
import ui.ConsoleUI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ItemRepository itemRepository = new ItemRepository();
        Inventory inventory = new Inventory(300,null);
        Player player = new Player("p", 200, inventory);
        player.getInventory().addGold(100);
        MarketEngine marketEngine = new MarketEngine(itemRepository, new ConsoleUI(sc), player);
        marketEngine.openMarket();

//        SaveData saveData = SaveManager.load();
//        Player player;
//        Room room = new Room(8, 12);
//        RoomGeneration roomGeneration = new RoomGeneration(room);
//        GameEngine gameEngine;
//        if (saveData != null) {
//            player = new Player(ArtTiles.getPlayerSymbol(), saveData);
//            gameEngine = new GameEngine(player, room, roomGeneration, saveData.getNumberRoom());
//        }
//        else {
//            player = new Player(ArtTiles.getPlayerSymbol(), 100, new Inventory());
//            gameEngine = new GameEngine(player, room, roomGeneration, 1);
//        }
//        GameManager gameManager = new GameManager(sc, gameEngine, new ConsoleUI(sc));
//        MainMenu mainMenu = new MainMenu(new ConsoleUI(sc), gameManager);
//        while (true) {
//            mainMenu.start();
//        }
    }
}
