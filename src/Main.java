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
        Room room = new Room(8, 12);
        RoomGeneration roomGeneration = new RoomGeneration(room);
        GameEngine gameEngine;
        if (saveData != null) {
            player = new Player("\uD83D\uDC82", saveData);
            gameEngine = new GameEngine(player, room, roomGeneration, saveData.getNumberRoom());
        }
        else {
            player = new Player("\uD83D\uDC82", 200);
            gameEngine = new GameEngine(player, room, roomGeneration, 1);
        }
        GameManager gameManager = new GameManager(sc, gameEngine, new RoomRenderer());
        MainMenu mainMenu = new MainMenu(sc, gameManager);
        while (true) {
            mainMenu.initialMenu();
        }
    }
}
