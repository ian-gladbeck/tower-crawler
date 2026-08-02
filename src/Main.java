import engine.RoomGeneration;
import model.Player;
import model.Position;
import model.Room;
import renderer.RoomRenderer;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("GD", 200, new Position(0, 0));
        RoomGeneration roomGeneration = new RoomGeneration(new Room(8, 8, player));
        Room room = roomGeneration.createRoom();
        RoomRenderer.printRoom(room, player);
    }
}
