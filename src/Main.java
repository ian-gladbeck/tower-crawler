import engine.GameEngine;
import engine.GameManager;
import engine.RoomGeneration;
import model.Player;
import model.Position;
import model.Room;
import save.SaveData;
import save.SaveManager;
import ui.MainMenu;
import ui.RoomRenderer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SaveData saveData = SaveManager.load();
        Player player;
        if (saveData == null) {
            System.out.print("Give your character a name: ");
            String name = sc.nextLine();
            player = new Player(name, 200, new Position(0, 0), 0);
        }
        else {
            player = new Player(saveData.getName(), saveData.getLife(), new Position(0, 0), saveData.getGold());
        }
        Room room = new Room(8, 12);
        RoomGeneration roomGeneration = new RoomGeneration(room);
        GameEngine gameEngine;
        if (saveData != null) {
            gameEngine = new GameEngine(player, room, roomGeneration, saveData.getNumberRoom());
        }
        else {
            gameEngine = new GameEngine(player, room, roomGeneration, 0);
        }
        GameManager gameManager = new GameManager(sc, gameEngine, new RoomRenderer());
        MainMenu mainMenu = new MainMenu(sc, gameManager);
        while (true) {
            mainMenu.initialMenu();
        }
    }
}
