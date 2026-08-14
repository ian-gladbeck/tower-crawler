import engine.GameEngine;
import engine.GameManager;
import engine.RoomGeneration;
import model.Player;
import model.Position;
import model.Room;
import ui.MainMenu;
import ui.RoomRenderer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Give your character a name: ");
        String name = sc.nextLine();
        Player player = new Player(name, 200, new Position(0, 0));
        Room room = new Room(8, 12);
        RoomGeneration roomGeneration = new RoomGeneration(room);
        GameEngine gameEngine = new GameEngine(player, room, roomGeneration);
        GameManager gameManager = new GameManager(sc, gameEngine, new RoomRenderer());
        MainMenu mainMenu = new MainMenu(sc, gameManager);
        while (true) {
            mainMenu.initialMenu();
        }
    }
}
