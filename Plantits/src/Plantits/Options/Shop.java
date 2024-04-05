package Plantits.Options;

import java.util.Scanner;

import Plantits.Game;
import Plantits.Items.BuyableItem;
import Plantits.Plants.Plant;

public class Shop extends Option {
    public void runOption(Game game) {
        System.out.println("════════════════════════════════════");
        System.out.println("               SHOP");
        System.out.println("════════════════════════════════════");
        System.out.println("AVAILABLE ITEMS: ");
        BuyableItem.printItems();
        System.out.println();
        System.out.println("AVAILABLE PLANTS: ");
        Plant.printPlants();
        System.out.println();
        System.out.println("Current Money: " + game.getMoney());
        System.out.println("════════════════════════════════════");
        System.out.println("What do you want to buy? (Type 'back' to return to menu):");

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        System.out.println();

        if ("back".equalsIgnoreCase(userInput)) {
            System.out.println("Returning to the menu...");
            return;
        }
        
        BuyableItem userItem = BuyableItem.getItem(userInput);
        if (userItem != null) {
            if (game.boughtItemsCount() >= Game.MAX_ITEM_SIZE) {
                System.out.println("You already have the maximum number of items.\n");
                return;
            }

            if (userItem.cost() > game.getMoney()) {
                System.out.println("Not enough money; you poor guy, ;P\n"); // XD
                return;
            }

            game.setMoney(game.getMoney() - userItem.cost());
            game.addItem(userItem);
            System.out.println("You purchased a/n " + userInput + "!");
            return;
        }

        Plant userPlant = Plant.getPlant(userInput);
        if (userPlant != null) {
            if (game.getPlants().size() >= Game.MAX_PLANT_SIZE) {
                System.out.println("You already have the maximum number of plants.\n");
                return;
            }

            if (userPlant.cost() > game.getMoney()) {
                System.out.println("Not enough money; you poor guy, ;P\n"); // XD
                return;
            }

            game.setMoney(game.getMoney() - userPlant.cost());
            game.addPlant(userPlant);
            System.out.println("You purchased a/n " + userInput + "!");
            return;
        }

        System.out.println("No item / plant named '" + userInput + "'. Try again.\n");
    }
}
