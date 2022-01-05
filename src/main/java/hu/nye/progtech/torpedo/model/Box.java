package hu.nye.progtech.torpedo.model;

import java.util.Vector;

import hu.nye.progtech.torpedo.service.map.Coordinate;

/**
 * Coordinates and boat handler.
 */

public class Box {
    private Boolean isVertical;
    private int length;
    Vector<Coordinate> coordinates;
    private int ownBoat;

    /**
     * Box handler for boat.
     */

    public Box() {
        length = 0;
        coordinates = new Vector<>();
    }

    /**
     * Check vertical for boats.
     */

    public void setVertical(Boolean vertical) {
        isVertical = vertical;
    }

    /**
     * Return vertical for boats.
     */

    public Boolean getVertical() {
        return isVertical;
    }

    /**
     * Length handler for boats.
     */

    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Return length for boats.
     */

    public int getLength() {
        return length;
    }

    /**
     * Places the boats on coordinate.
     */

    public void addCoordinate(int x, int y) {
        coordinates.add(new Coordinate(x, y));
    }

    /**
     * Return coordinate placement for boats.
     */

    public Vector<Coordinate> getCoordinates() {
        return coordinates;
    }

    /**
     * Return boat own for player.
     */

    public int getOwnBoat() {
        return ownBoat;
    }

    /**
     * Set boat own for player.
     */

    public void setOwnBoat(int ownBoat) {
        this.ownBoat = ownBoat;
    }
}
