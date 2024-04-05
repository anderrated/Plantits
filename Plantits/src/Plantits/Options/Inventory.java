package Plantits.Options;
import Plantits.Game;

public class Inventory extends Option {
    public void runOption(Game game) {
        System.out.println("════════════════════════════════════");
        System.out.println("             INVENTORY");
        System.out.println("════════════════════════════════════");
        if (game.getPlants().isEmpty()) {
            System.out.println("You don't have plants at the moment. Type 'Shop' to buy a plant.\n");
        } else {
            
            System.out.println("PLANTS IN YOUR INVENTORY:\n");
            game.listPlants();
            System.out.println();
        }

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
        if (game.getBoughtItems().isEmpty()) {
            
            System.out.println("You don't have items at the moment. Type 'Shop' to buy an item.\n");
        } else {
            System.out.println("ITEMS IN YOUR INVENTORY:\n");
            game.listItems();
        }
    }
}
