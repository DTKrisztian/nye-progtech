package hu.nye.progtech.torpedo.service.boats;

import hu.nye.progtech.torpedo.model.Box;

/**
 * Third boat handler.
 */

public class ThirdBoat extends Box {
    int xcord;
    int ycord;

    /**
     * Third boat handler for length, cords and who owns it currently and vertical check.
     */

    public ThirdBoat(int x, int y, int whoOwn, boolean isVertical) {
        this.xcord = x;
        this.ycord = y;
        this.setLength(3);
        this.setOwnBoat(whoOwn);
        this.setVertical(isVertical);
        this.addCoordinate(x, y);
        setCoordinates();
    }

    /**
     * Second boat handler vertical or horizontal placement check.
     */

    public void setCoordinates() { //vertical
        if (this.getVertical()) {
            for (int i = 1; i < getLength(); i++) {
                this.addCoordinate(this.xcord + i, this.ycord);
            }
        } else { // horizontal
            for (int i = 1; i < getLength(); i++) {
                this.addCoordinate(this.xcord, this.ycord + i);
            }
        }
    }
}
