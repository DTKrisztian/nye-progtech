package hu.nye.progtech.torpedo.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import hu.nye.progtech.torpedo.service.boats.FifthBoat;
import hu.nye.progtech.torpedo.service.boats.FirstBoat;
import hu.nye.progtech.torpedo.service.boats.FourthBoat;
import hu.nye.progtech.torpedo.service.boats.SecondBoat;
import hu.nye.progtech.torpedo.service.boats.ThirdBoat;
import hu.nye.progtech.torpedo.service.controller.Player;

/**
 * Handles the whole boat placement and game.
 */

public class GameState {
    static Player playerOne;
    static Player AI;
    BufferedReader reader;
    Random random = new Random();
    int rand = random.nextInt(10) + 1;
    int direct = random.nextInt(2) + 1;
    int xcord = 0;
    int ycord = 0;
    String direction;

    /**
     * Begins game after player checks.
     */

    public GameState() throws IOException, SQLException {
        initPlayerOne();
        initPlayerTwo();
        System.out.println("Let the battle begin!");
        beginGame();
    }

    /**
     * Inserting the users into the database.
     */

    public static int insertUser(Statement statement, String name, Integer points) throws SQLException {
        String query = "INSERT INTO USERS (NAME, POINTS) VALUES ('" + name + "', " + points + ");";
        return statement.executeUpdate(query);
    }

    Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
    String query = "SELECT * FROM USERS;";
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(query);

    /**
     * First player boat placement.
     */

    public void initPlayerOne() throws IOException, SQLException {
        boolean check;
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What is your name: ");
        this.playerOne = new Player(reader.readLine(), 1);
        insertUser(statement, playerOne.getNickname(), 0);
        System.out.println("Place your first ship " + playerOne.getNickname());
        while (!playerOne.map.getBoatAdded()) {
            do {
                check = false;
                System.out.print("\nx: ");
                try {
                    xcord = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please give a number between 1 and 10!");
                    check = true;
                }
            } while (check);
            do {
                check = false;
                System.out.print("\ny: ");
                try {
                    ycord = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please give a number between 1 and 10!");
                    check = true;
                }
            } while (check);
            playerOne.map.addBoat(playerOne.firstBoat = new FirstBoat(xcord, ycord, 1));
        }
        playerOne.map.setBoatAdded(false);
        playerOne.map.printMap();
        System.out.println("\n" + "Place your second ship " + playerOne.getNickname());
        xcord = 0;
        ycord = 0;
        while (!playerOne.map.getBoatAdded()) {
            do {
                check = false;
                System.out.print("\nx: ");
                try {
                    xcord = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please give a number between 1 and 10!");
                    check = true;
                }
            } while (check);
            do {
                check = false;
                System.out.print("\ny: ");
                try {
                    ycord = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please give a number between 1 and 10!");
                    check = true;
                }
            } while (check);
            do {
                System.out.print("Vertical or horisontal? (v/h) :");
                direction = reader.readLine();
            } while (!direction.equals("v") && !direction.equals("h"));
            playerOne.map.addBoat(playerOne.secondBoat = new SecondBoat(xcord, ycord, 1, (direction.equals("v"))));
        }
        playerOne.map.setBoatAdded(false);
        playerOne.map.printMap();

        System.out.println("\n" + "Place your third ship " + playerOne.getNickname());
        xcord = 0;
        ycord = 0;
        while (!playerOne.map.getBoatAdded()) {
            do {
                check = false;
                System.out.print("\nx: ");
                try {
                    xcord = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please give a number between 1 and 10!");
                    check = true;
                }
            } while (check);
            do {
                check = false;
                System.out.print("\ny: ");
                try {
                    ycord = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please give a number between 1 and 10!");
                    check = true;
                }
            } while (check);
            do {
                System.out.print("Vertical or horisontal? (v/h) :");
                direction = reader.readLine();
            } while (!direction.equals("v") && !direction.equals("h"));
            playerOne.map.addBoat(playerOne.thirdBoat = new ThirdBoat(xcord, ycord, 1, (direction.equals("v"))));
        }
        playerOne.map.setBoatAdded(false);
        playerOne.map.printMap();

        System.out.println("\n" + "Place your fourth ship " + playerOne.getNickname());
        xcord = 0;
        ycord = 0;
        while (!playerOne.map.getBoatAdded()) {
            do {
                check = false;
                System.out.print("\nx: ");
                try {
                    xcord = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please give a number between 1 and 10!");
                    check = true;
                }
            } while (check);
            do {
                check = false;
                System.out.print("\ny: ");
                try {
                    ycord = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please give a number between 1 and 10!");
                    check = true;
                }
            } while (check);
            do {
                System.out.print("Vertical or horisontal? (v/h) :");
                direction = reader.readLine();
            } while (!direction.equals("v") && !direction.equals("h"));
            playerOne.map.addBoat(playerOne.fourthBoat = new FourthBoat(xcord, ycord, 1, (direction.equals("v"))));
        }
        playerOne.map.setBoatAdded(false);
        playerOne.map.printMap();

        System.out.println("\n" + "Place your fifth ship " + playerOne.getNickname());
        xcord = 0;
        ycord = 0;
        while (!playerOne.map.getBoatAdded()) {
            do {
                check = false;
                System.out.print("\nx: ");
                try {
                    xcord = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please give a number between 1 and 10!");
                    check = true;
                }
            } while (check);
            do {
                check = false;
                System.out.print("\ny: ");
                try {
                    ycord = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please give a number between 1 and 10!");
                    check = true;
                }
            } while (check);
            do {
                System.out.print("Vertical or horisontal? (v/h) :");
                direction = reader.readLine();
            } while (!direction.equals("v") && !direction.equals("h"));
            playerOne.map.addBoat(playerOne.fifthBoat = new FifthBoat(xcord, ycord, 1, (direction.equals("v"))));
        }
        playerOne.map.setBoatAdded(false);
        playerOne.map.printMap();
    }

    /**
     * Updates the users with the scores.
     */

    public int updateUser(Statement statement, String name, Integer points) throws SQLException {
        String query2 = "UPDATE USERS SET POINTS = " + points + " WHERE NAME = '" + name + "';";
        return statement.executeUpdate(query2);
    }

    /**
     * Second player (AI) boat placement.
     */

    public void initPlayerTwo() throws IOException, SQLException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nPlease give your opponent a name: ");
        this.AI = new Player(reader.readLine(), 2);
        insertUser(statement, AI.getNickname(), 0);
        xcord = 0;
        ycord = 0;
        while (!AI.map.getBoatAdded()) {
            xcord = random.nextInt(10) + 1;
            ycord = random.nextInt(10) + 1;
            AI.map.addBoat(AI.firstBoat = new FirstBoat(xcord, ycord, 2));
        }
        AI.map.setBoatAdded(false);
        AI.map.printMap();
        xcord = 0;
        ycord = 0;
        while (!AI.map.getBoatAdded()) {
            xcord = random.nextInt(10) + 1;
            ycord = random.nextInt(10) + 1;
            direct = random.nextInt(2) + 1;
            if (direct == 1) {
                direction = "v";
            } else {
                direction = "h";
            }
            AI.map.addBoat(AI.secondBoat = new SecondBoat(xcord, ycord, 2, (direction.equals("v"))));
        }
        AI.map.setBoatAdded(false);
        AI.map.printMap();

        xcord = 0;
        ycord = 0;
        while (!AI.map.getBoatAdded()) {
            xcord = random.nextInt(10) + 1;
            ycord = random.nextInt(10) + 1;
            direct = random.nextInt(2) + 1;
            if (direct == 1) {
                direction = "v";
            } else {
                direction = "h";
            }
            AI.map.addBoat(AI.thirdBoat = new ThirdBoat(xcord, ycord, 2, (direction.equals("v"))));
        }
        AI.map.setBoatAdded(false);
        AI.map.printMap();

        xcord = 0;
        ycord = 0;
        while (!AI.map.getBoatAdded()) {
            xcord = random.nextInt(10) + 1;
            ycord = random.nextInt(10) + 1;
            direct = random.nextInt(2) + 1;
            if (direct == 1) {
                direction = "v";
            } else {
                direction = "h";
            }
            AI.map.addBoat(AI.fourthBoat = new FourthBoat(xcord, ycord, 2, (direction.equals("v"))));
        }
        AI.map.setBoatAdded(false);
        AI.map.printMap();

        xcord = 0;
        ycord = 0;
        while (!AI.map.getBoatAdded()) {
            xcord = random.nextInt(10) + 1;
            ycord = random.nextInt(10) + 1;
            direct = random.nextInt(2) + 1;
            if (direct == 1) {
                direction = "v";
            } else {
                direction = "h";
            }
            AI.map.addBoat(AI.fifthBoat = new FifthBoat(xcord, ycord, 2, (direction.equals("v"))));
        }
        AI.map.setBoatAdded(false);
        AI.map.printMap();
    }

    /**
     * Handles the actual game.
     */

    public void beginGame() throws IOException, SQLException {
        boolean nextPlayer = true;
        boolean playerOneLost = false;
        boolean playerTwoLost;
        reader = new BufferedReader(new InputStreamReader(System.in));

        while (playerOne.lives && AI.lives) {
            if (nextPlayer) {
                System.out.println("\n" + playerOne.getNickname() + " shooting now!");
                System.out.println(playerOne.getNickname() + "Your current shots:");
                playerOne.hitMap.printMap();
                System.out.println("\n\n" + playerOne.getNickname() + " Your map:");
                playerOne.map.printMap();
                System.out.println("\n" + playerOne.getNickname() + " shoot!");
                xcord = 0;
                ycord = 0;
                do {
                    System.out.print("x: ");
                    xcord = Integer.parseInt(reader.readLine());
                    System.out.print("y: ");
                    ycord = Integer.parseInt(reader.readLine());
                } while (!playerOne.map.checkHitIndex(xcord, ycord));

                if (AI.map.getPlace(xcord, ycord) == 2) {
                    System.out.println("Hit!");
                    AI.map.setHit(xcord, ycord);
                    playerOne.addHitPointToHitTable(xcord, ycord);
                    playerOne.addPoint();
                } else if (AI.map.getPlace(xcord, ycord) == 0) {
                    System.out.println("Miss!");
                    playerOne.addHitPointToHitTable(xcord, ycord);
                    AI.map.setHit(xcord, ycord);
                } else {
                    System.out.println("You shot here already!");
                    AI.map.setHit(xcord, ycord);
                }
            } else {
                System.out.println("\n" + AI.getNickname() + " comes next");
                xcord = 0;
                ycord = 0;
                do {
                    xcord = random.nextInt(10) + 1;
                    ycord = random.nextInt(10) + 1;
                } while (!AI.map.checkHitIndex(xcord, ycord));

                if (playerOne.map.getPlace(xcord, ycord) == 1) {
                    playerOne.map.setHit(xcord, ycord);
                    AI.addHitPointToHitTable(xcord, ycord);
                    AI.addPoint();
                } else if (playerOne.map.getPlace(xcord, ycord) == 0) {
                    AI.addHitPointToHitTable(xcord, ycord);
                    playerOne.map.setHit(xcord, ycord);
                } else {
                    playerOne.map.setHit(xcord, ycord);
                }
            }

            nextPlayer = !nextPlayer;

            playerOneLost = playerOne.checkLose();
            playerTwoLost = AI.checkLose();
        }
        if (playerOneLost) {
            System.out.println(AI.getNickname() + " Won! \n Your score: " + AI.getPoint());
            updateUser(statement, AI.getNickname(), AI.getPoint());
        } else {
            System.out.println(playerOne.getNickname() + " Won! \n Your score: " + playerOne.getPoint());
            updateUser(statement, playerOne.getNickname(), playerOne.getPoint());
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}

