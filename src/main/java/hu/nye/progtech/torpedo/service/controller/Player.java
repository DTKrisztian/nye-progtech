package hu.nye.progtech.torpedo.service.controller;

import hu.nye.progtech.torpedo.model.Map;
import hu.nye.progtech.torpedo.service.boats.FifthBoat;
import hu.nye.progtech.torpedo.service.boats.FirstBoat;
import hu.nye.progtech.torpedo.service.boats.FourthBoat;
import hu.nye.progtech.torpedo.service.boats.SecondBoat;
import hu.nye.progtech.torpedo.service.boats.ThirdBoat;

/**
 * Player handler for boats and maps.
 */

public class Player {
    private final String nickname;
    public FirstBoat firstBoat;
    public SecondBoat secondBoat;
    public ThirdBoat thirdBoat;
    public FourthBoat fourthBoat;
    public FifthBoat fifthBoat;
    private int point;
    public Map map;
    public Map hitMap;
    public boolean lives;

    /**
     * Player handler.
     */

    public Player(String nick, int id1) {
        this.nickname = nick;
        this.lives = true;
        this.point = 0;
        map = new Map(id1, nick);
        hitMap = new Map(id1, nick);
    }

    /**
     * Return name for player.
     */

    public String getNickname() {
        return nickname;
    }

    /**
     * Add point for player.
     */

    public void addPoint() {
        this.point++;
    }

    /**
     * Return point for player.
     */

    public int getPoint() {
        return point;
    }

    /**
     * Lose check.
     */

    public boolean checkLose() {
        int[][] tmpMap = map.getMap();
        int losecheck = 0;
        for (int i = 0; i < tmpMap.length; i++) {
            for (int j = 0; j < tmpMap[i].length; j++) {
                if (tmpMap[i][j] == 1 || tmpMap[i][j] == 2) {
                    losecheck++;
                }
            }
        }
        if (losecheck == 0) {
            lives = false;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Hit table handler for map.
     */

    public void addHitPointToHitTable(int x, int y) {
        hitMap.getMap()[x - 1][y - 1] = 5;
    }
}
