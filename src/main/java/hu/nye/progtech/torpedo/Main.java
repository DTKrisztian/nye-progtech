package hu.nye.progtech.torpedo;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Main for starting everything.
 */

public class Main {

    /**
     * Game starter.
     */

    public static void main(String[] args) throws IOException, SQLException {
        System.out.println("Welcome to the Battleship game!\n");
        new AnnotationConfigApplicationContext("hu.nye.progtech.torpedo");
    }
}
