package save;

import model.Player;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SaveManager {
    private static Path path = Path.of("save.txt");

    public static void save (Player player, int numberRoom) {
        try {
            String data = player.getLife() + "\n"
                    + player.getDiamonds() + "\n" + numberRoom;
            Files.writeString(path, data);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static SaveData load () {
        try {
            if (!Files.exists(path)) {
                return null;
            }
            String content = Files.readString(path);
            if (content.isEmpty()) {
                return null;
            }
            String[] lines = content.split("\n");
            int life = Integer.parseInt(lines[0]);
            int diamonds = Integer.parseInt(lines[1]);
            int numberRoom = Integer.parseInt(lines[2]);
            return new SaveData(life, diamonds, numberRoom);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
