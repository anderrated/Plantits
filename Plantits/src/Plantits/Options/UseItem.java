package Plantits.Options;
import java.util.Scanner;

import Plantits.Game;
import Plantits.Items.BuiltinItem;
import Plantits.Items.BuyableItem;
import Plantits.Items.Water;
import Plantits.Items.Window;

public class UseItem extends Option {
    public void runOption(Game game) {
        System.out.println("════════════════════════════════════");
        System.out.println("              USE ITEM");
        System.out.println("════════════════════════════════════");
        if (game.retrieveSelectedPlant() == null) {
            System.out.println("You haven't selected a plant yet. Select a plant with 'SelectPlant'.\n");
            return;
        }

        System.out.println("Water count: " + Water.getWaterCount());
        System.out.println("Window count: " + Window.getWindowCount());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
        System.out.println("PLANT COMMANDS:");
        BuiltinItem.printItems();
        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
        System.out.println("SELECT ITEM TO USE:");

        if (game.boughtItemsCount() < 1) {
            System.out.println("You do not own any items. Type 'Shop' to purchase an item.\n");
        } 
        game.listBoughtItems();

        System.out.println("════════════════════════════════════");
        System.out.println("Type command/item to use on your plant (Type 'back' to return to menu.):");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        System.out.println();


        if ("back".equalsIgnoreCase(userInput)) {
            System.out.println("Returning to the menu...");
            return;
        }

        BuiltinItem builtinItem = BuiltinItem.getItem(userInput);
        if (builtinItem != null) {
            builtinItem.useItem(game, game.retrieveSelectedPlant());
            return;
        }

        BuyableItem boughtItem = BuyableItem.getItem(userInput);
        if (boughtItem != null) {
            if (game.isItemAvailable(boughtItem)) {
                boolean isItemUsed = boughtItem.useItem(game, game.retrieveSelectedPlant());
                if (isItemUsed) {
                    game.useBoughtItem(boughtItem);
                }
            } else {
                System.out.println("Item '" + userInput + "' is not available, you can buy items from the shop.\n");
            }
            return;
        }

        System.out.println("No Item named '" + userInput + "'. Try again.\n");
    }
    
}
