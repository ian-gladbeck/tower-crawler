import engine.RoomGeneration;
import model.Player;
import model.Position;
import model.Room;

public class Main {
    public static void main(String[] args) {
        RoomGeneration roomGeneration = new RoomGeneration(new Room(8, 8, new Player("Lk", 200, new Position(0, 0))));
        Room room = roomGeneration.createRoom();
        for (int i = 0; i < room.getHeight(); i++) {
            for (int j = 0; j < room.getWidth(); j++) {
                System.out.print(room.getGrid()[i][j] + " ");
            }
            System.out.println();
        }
    }
}
