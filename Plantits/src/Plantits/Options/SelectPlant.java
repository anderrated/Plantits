package Plantits.Options;

import java.util.Scanner;

import Plantits.Game;

public class SelectPlant extends Option {
    public void runOption(Game game) {
            System.out.println("════════════════════════════════════");
            System.out.println("HERE ARE YOUR PLANTS!");
            System.out.println();
            
        if (game.getPlants().isEmpty()){
            System.out.println("You don't have plants at the moment. Type 'Shop' to buy a plant.\n");
            return;
        }
            game.listPlants();
            System.out.println("════════════════════════════════════");
            System.out.println("Enter the Slot# of plant to select (Type 'back' to return to menu):");
            
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            System.out.println();
            
            if ("back".equalsIgnoreCase(userInput)) {
                System.out.println("Returning to the menu...");
                return;
            }
            
            try {
                int slotNumber = Integer.parseInt(userInput);
    
                // Check if the slotNumber is valid
                if (slotNumber >= 0 && slotNumber < game.getPlants().size()) {
                    boolean success = game.selectPlant(slotNumber);

                    if (!success) {
                        System.out.println("Invalid Index: Try again ;P");
                        return;
                    }
            
                    System.out.println("\nYou selected your " + game.getPlant(slotNumber).getName() + "!");
                } else {
                    System.out.println("That Slot# doesn't exist.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input: Please enter a valid number.");
            }

        }

}


