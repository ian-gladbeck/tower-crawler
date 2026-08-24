import engine.GameEngine;
import engine.GameManager;
import engine.RoomGeneration;
import model.ArtTiles;
import model.Inventory;
import model.Player;
import model.Room;
import save.SaveData;
import save.SaveManager;
import ui.MainMenu;
import ui.ConsoleUI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SaveData saveData = SaveManager.load();
        Player player;
        Room room = new Room(8, 12);
        RoomGeneration roomGeneration = new RoomGeneration(room);
        GameEngine gameEngine;
        if (saveData != null) {
            player = new Player(ArtTiles.getPlayerSymbol(), saveData);
            gameEngine = new GameEngine(player, room, roomGeneration, saveData.getNumberRoom());
        }
        else {
            player = new Player(ArtTiles.getPlayerSymbol(), 100, new Inventory());
            gameEngine = new GameEngine(player, room, roomGeneration, 1);
        }
        GameManager gameManager = new GameManager(sc, gameEngine, new ConsoleUI(sc));
        MainMenu mainMenu = new MainMenu(new ConsoleUI(sc), gameManager);
        while (true) {
            mainMenu.start();
        }
    }
}
