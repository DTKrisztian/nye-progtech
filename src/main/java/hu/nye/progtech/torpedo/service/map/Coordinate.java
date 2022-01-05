package hu.nye.progtech.torpedo.service.map;

/**
 * Coordinate handler.
 */

public class Coordinate {

    private final int xcord;
    private final int ycord;

    /**
     * Coordinate handler for x and y.
     */

    public Coordinate(int x, int y) {
        this.xcord = x;
        this.ycord = y;
    }

    public int getXcord() {
        return xcord;
    }

    public int getYcord() {
        return ycord;
    }
}
