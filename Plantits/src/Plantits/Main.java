/**
* Plantits is an AMAZING plant simulator game created as a
* Final Project in CMSC 22 - Fundamentals of Object Oriented Programming (Java)
* @author Andrea A. Laserna
* @author Albin Alexis A. Cayanan
* @author Khanne S. Labao
* @author Angelique Margaret M. Ardeña
* 
* @date December 19, 2023
* "Welcome to Plantits! Start the game by going to the Shop and buying your first plant!"
*/

package Plantits;

import java.util.Scanner;

import Plantits.Options.*;

public class Main {
    public static void main(String args[]) {
        
        Game game = new Game(500);
        Scanner scanner = new Scanner(System.in);

        while (!game.isGameOver()) {
            System.out.println("════════════════════════════════════");
            System.out.println("               MENU");
            System.out.println("════════════════════════════════════");
            Option.printOptions();
            System.out.println();
            System.out.println("Current Money: " + game.getMoney());
            System.out.println("════════════════════════════════════");

            System.out.println("What would you like?");
            String choice = scanner.nextLine();
            System.out.println();

            Option choiceOption = Option.getOption(choice);
            choiceOption.runOption(game);
        }

        scanner.close();
    }
}
