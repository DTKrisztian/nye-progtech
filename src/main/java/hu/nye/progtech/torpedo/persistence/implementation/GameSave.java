package hu.nye.progtech.torpedo.persistence.implementation;

import hu.nye.progtech.torpedo.service.controller.Player;

/**
 * Game save and load.
 */

public interface GameSave {
    void save(String player, String file);

    Player load();
}
