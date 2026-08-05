import engine.GameEngine;
import engine.GameManager;
import engine.RoomGeneration;
import model.Player;
import model.Position;
import model.Room;
import renderer.RoomRenderer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player player = new Player("GD", 200, new Position(0, 0));
        Room room = new Room(8, 12, player);
        RoomGeneration roomGeneration = new RoomGeneration(room);
        GameEngine gameEngine = new GameEngine(player, room, roomGeneration);
        GameManager gameManager = new GameManager(sc, gameEngine, new RoomRenderer());
        while (true) {
            gameManager.startRoom();
        }
    }
}
