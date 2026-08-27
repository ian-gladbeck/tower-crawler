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
        Room room = new Room(8, 12);
        RoomGeneration roomGeneration = new RoomGeneration(room);
        ItemRepository itemRepository = new ItemRepository();
        Player player;
        Inventory inventory = new Inventory(100, null);
        SaveData saveData = SaveManager.load();
        GameEngine gameEngine;
        if (saveData != null) {
            player = new Player(ArtTiles.getPlayerSymbol(), saveData);
            gameEngine = new GameEngine(player, room, roomGeneration, saveData.getNumberRoom());
        }
        else {
            player = new Player(ArtTiles.getPlayerSymbol(), 100, inventory);
            gameEngine = new GameEngine(player, room, roomGeneration, 1);
        }
        GameManager gameManager = new GameManager(sc, gameEngine, new ConsoleUI(sc));
        MarketEngine marketEngine = new MarketEngine(itemRepository, new ConsoleUI(sc), player);
        MainMenu mainMenu = new MainMenu(new ConsoleUI(sc), gameManager, marketEngine);
        while (true) {
            mainMenu.start();
        }
    }
}
