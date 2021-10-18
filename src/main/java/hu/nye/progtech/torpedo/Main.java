package hu.nye.progtech.torpedo;

import hu.nye.progtech.torpedo.service.exception.MapReaderException;
import hu.nye.progtech.torpedo.service.map.reader.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player name = new Player();
        System.out.println("Please enter your name: ");
        Scanner scanner=new Scanner(System.in);

        try {
            System.out.println("Welcome to the game "+ name.PlayerName(scanner.nextLine())+"!");
            System.out.println("Your enemy will be the AI named Karl!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
