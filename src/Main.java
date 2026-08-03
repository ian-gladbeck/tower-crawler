import engine.GameEngine;
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
        RoomGeneration roomGeneration = new RoomGeneration(new Room(8, 8, player));
        Room room = roomGeneration.createRoom();
        GameEngine gameEngine = new GameEngine(player, room);
        gameEngine.startRoom(sc);
    }
}
