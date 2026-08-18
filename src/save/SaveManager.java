package save;

import model.Player;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SaveManager {
    private static Path path = Path.of("save.txt");

    public static void save (Player player, int numberRoom) {
        try {
            String data = player.getName() + "\n" + player.getLife() + "\n"
                    + player.getGold() + "\n" + numberRoom;
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
            String name = lines[0];
            int life = Integer.parseInt(lines[1]);
            int gold = Integer.parseInt(lines[2]);
            int numberRoom = Integer.parseInt(lines[3]);
            return new SaveData(name, life, gold, numberRoom);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
