package hu.nye.progtech.torpedo.model;

import java.util.Vector;

import hu.nye.progtech.torpedo.service.map.Coordinate;

/**
 * Map handler.
 */

public class Map {
    public final int[][] map;
    public final int playerId;
    public final String playerName;
    public Boolean boatAdded;

    /**
     * Player handle for their own maps.
     */

    public Map(int id, String playerName) {
        this.playerId = id;
        this.playerName = playerName;
        boatAdded = false;
        this.map = new int[10][10];
        initMap();
    }

    /**
     * Fills map with 0.
     */

    public void initMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = 0;
            }
        }
    }

    /**
     * Return boats added for player on map.
     */

    public Boolean getBoatAdded() {
        return this.boatAdded;
    }

    /**
     * Check for added boat for player on map.
     */

    public void setBoatAdded(Boolean boatAdded) {
        this.boatAdded = boatAdded;
    }

    /**
     * Map printer.
     */

    public void printMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    /**
     * Places player boat on map.
     */

    public void addBoat(Box boats) {
        Vector<Coordinate> coordinates = boats.getCoordinates();
        if (checkIndex(coordinates)) {
            if (checkPlaceIsEmpty(coordinates)) {
                for (Coordinate coordinate : coordinates) {
                    map[coordinate.getXcord() - 1][coordinate.getYcord() - 1] = boats.getOwnBoat();
                }
                setBoatAdded(true);
            } else {
                System.out.println("You already have a ship here!");
            }
        } else {
            System.out.println("Wrong coordinates. Keep it in the map. 1-10");
        }
    }

    /**
     * Checks if the place for boat is empty.
     */

    public boolean checkPlaceIsEmpty(Vector<Coordinate> coordinates) {
        for (Coordinate coordinate : coordinates) {
            if (map[coordinate.getXcord() - 1][coordinate.getYcord() - 1] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if boat is placed in the map.
     */

    public boolean checkIndex(Vector<Coordinate> coordinates) {
        for (Coordinate coordinate : coordinates) {
            if (coordinate.getXcord() - 1 < 0 || coordinate.getXcord() > 10) {
                return false;
            } else if (coordinate.getYcord() - 1 < 0 || coordinate.getYcord() > 10) {
                return false;
            }
        }
        return true;

    }

    /**
     * Check if the player shoot inside the map.
     */

    public boolean checkHitIndex(int x, int y) {
        if (x > 10 || x <= 0) {
            System.out.println("Wrong coordinates!");
            return false;
        } else if (y > 10 || y <= 0) {
            System.out.println("Wrong coordinates!");
            return false;
        }
        return true;
    }

    /**
     * Place check for hit, miss.
     */

    public int getPlace(int x, int y) {
        return map[x - 1][y - 1];
    }

    /**
     * Hit handler for players.
     */

    public void setHit(int x, int y) {
        map[x - 1][y - 1] = 5;
    }

    /**
     * Map handler for checks.
     */

    public int[][] getMap() {
        return this.map;
    }
}
