package hu.nye.progtech.torpedo;

import java.io.IOException;
import java.sql.SQLException;

import hu.nye.progtech.torpedo.model.GameState;

/**
 * Main for starting everything.
 */

public class Main {

    /**
     * Game starter.
     */

    public static void main(String[] args) throws IOException, SQLException {
        System.out.println("Welcome to the Battleship game!\n");
        new GameState();
    }
}
