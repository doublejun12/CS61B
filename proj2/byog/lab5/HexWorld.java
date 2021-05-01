package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);
    /**
     * Computes the width of row i for a size s hexagon.
     * @param s The size of hexagon.
     * @param i The row number where i = 0 is the bottom row.
     */
    private static int hexRowWidth(int s, int i) {
        if (i >= s) {
            i = 2 * s - 1 - i;
        }

        return s + 2 * i;
    }
    /**
     * Computes the offset of row i for a size s hexagon.
     * @param s The size of hexagon.
     * @param i The row number where i = 0 is the bottom row.
     */
    private static int hexRowOffset(int s, int i) {
        if (i >= s) {
            i = 2 * s - 1 - i;
        }

        return s - 1 - i;
    }

    /** Picks a RANDOM tile with a 33% change of being
     *  a wall, 33% chance of being a flower, and 33%
     *  chance of being empty space.
     */
    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(5);
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.MOUNTAIN;
            case 3: return Tileset.SAND;
            case 4: return Tileset.PLAYER;
            case 5: return Tileset.TREE;
            default: return Tileset.NOTHING;
        }
    }

    /**
     * Adds a hexagon to the world.
     * @param world the world to draw on
     * @param s the size of the hexagon
     * @param xPos the bottom left x-coordinate of the hexagon
     * @param yPos the bottom left y-coordinate of the hexagon
     */
    public static void addHexagon(TETile[][] world, int s, int xPos, int yPos) {
        TETile T = randomTile();
        int hexWidth = 3 * s - 2;
        int hexHeight = 2 * s;
        for (int i = 0; i < hexHeight; i++) {
            int hexRowWidth = hexRowWidth(s, i);
            int hexRowOffset = hexRowOffset(s, i);
            for (int j = hexRowOffset; j < hexRowOffset + hexRowWidth; j++) {
                world[j + xPos][i + yPos] = T;
            }
        }
    }

    /**
     * Calculating the Width of world.
     * @param s the size of the hexagon.
     * @return the width
     */
    private static int calWidth(int s) {
        return (3 * s - 2) * 3 + 2 * s;
    }

    /**
     * Calculating the Height of world.
     * @param s the size of the hexagon.
     * @return the height
     */
    private static int calHeight(int s) {
        return 10 * s;
    }
    /**
     * Draw a tesselation of Hexagons
     * @param s the size of the hexagon
     */
    public static void tesselationOfHexagons(TETile[][] world, int s) {
        drawVerticalHexes(world, s, 0);
        drawVerticalHexes(world, s, 1);
        drawVerticalHexes(world, s, 2);
        drawVerticalHexes(world, s, 3);
        drawVerticalHexes(world, s, 4);
    }

    /**
     * Draw a column of N hexes
     * @param s the size of the hexagon.
     * @param col the column of the world.
     */
    private static void drawVerticalHexes(TETile[][] world, int s, int col) {
        if (col == 0) {
            addHexagon(world, s, 0, 2 * s);
            addHexagon(world, s, 0, 4 * s);
            addHexagon(world, s, 0, 6 * s);
        } else if (col == 1) {
            addHexagon(world, s, 2 * s - 1, s);
            addHexagon(world, s, 2 * s - 1, 3 * s);
            addHexagon(world, s, 2 * s - 1, 5 * s);
            addHexagon(world, s, 2 * s - 1, 7 * s);
        } else if (col == 2) {
            addHexagon(world, s, 4 * s - 2, 0);
            addHexagon(world, s, 4 * s - 2, 2 * s);
            addHexagon(world, s, 4 * s - 2, 4 * s);
            addHexagon(world, s, 4 * s - 2, 6 * s);
            addHexagon(world, s, 4 * s - 2, 8 * s);
        } else if (col == 3) {
            addHexagon(world, s, 6 * s - 3, s);
            addHexagon(world, s, 6 * s - 3, 3 * s);
            addHexagon(world, s, 6 * s - 3, 5 * s);
            addHexagon(world, s, 6 * s - 3, 7 * s);
        } else if (col == 4) {
            addHexagon(world, s, 8 * s - 4, 2 * s);
            addHexagon(world, s, 8 * s - 4, 4 * s);
            addHexagon(world, s, 8 * s - 4, 6 * s);
        }
    }
    public static void main(String[] args) {
        int s = 5;

        int widthOfWorld = calWidth(s);
        int heightOfWorld = calHeight(s);

        TERenderer ter = new TERenderer();
        ter.initialize(widthOfWorld, heightOfWorld);

        TETile[][] world = new TETile[widthOfWorld][heightOfWorld];
        for (int x = 0; x < widthOfWorld; x += 1) {
            for (int y = 0; y < heightOfWorld; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        tesselationOfHexagons(world, s);

        ter.renderFrame(world);
    }
}
