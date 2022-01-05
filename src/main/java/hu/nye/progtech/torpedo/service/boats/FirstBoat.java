package hu.nye.progtech.torpedo.service.boats;

import hu.nye.progtech.torpedo.model.Box;

/**
 * First boat handler.
 */

public class FirstBoat extends Box {

    /**
     * First boat handler for length, cords and who owns it currently.
     */

    public FirstBoat(int x, int y, int whoOwn) {
        this.setLength(1);
        this.addCoordinate(x, y);
        this.setOwnBoat(whoOwn);
    }
}
