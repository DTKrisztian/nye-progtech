package hu.nye.progtech.torpedo.service.boats;

import hu.nye.progtech.torpedo.model.Box;

/**
 * Fourth boat handler.
 */

public class FourthBoat extends Box {
    int xcord;
    int ycord;

    /**
     * Fourth boat handler for length, cords and who owns it currently and vertical check.
     */

    public FourthBoat(int x, int y, int whoOwn, boolean isVertical) {
        this.xcord = x;
        this.ycord = y;
        this.setLength(4);
        this.setOwnBoat(whoOwn);
        this.setVertical(isVertical);
        this.addCoordinate(x, y);
        setCoordinates();
    }

    /**
     * Fourth boat handler vertical or horizontal placement check.
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
