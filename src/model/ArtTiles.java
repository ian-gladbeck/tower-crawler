package model;

public class ArtTiles {
    public static String getTileSymbol(Tile tile) {
        return switch (tile) {
            case BARRIER -> ConsoleColors.RED + "#" + ConsoleColors.RESET;
            case PATH -> " ";
            case GOLD -> ConsoleColors.YELLOW + "$" + ConsoleColors.RESET;
            case EXIT -> ConsoleColors.GREEN + "!" + ConsoleColors.RESET;
        };
    }

    public static String getPlayerSymbol() {
        return ConsoleColors.CYAN + "P" + ConsoleColors.RESET;
    }

    public static String getEnemySymbol() {
        return ConsoleColors.BLUE + "E" + ConsoleColors.RESET;
    }
}
