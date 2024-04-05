package Plantits.Items;

import Plantits.Game;
import Plantits.Plants.Plant;

public class Antidote extends BuyableItem {
    public String getName() {
        return "Antidote";
    }

    public int cost() {
        return 150;
    }

    public boolean useItem(Game game, Plant plant) {

        if (!plant.getIsBugPresent()) {
            System.out.println("Your plant is not sick as it is not infested with bugs. You cannot use this item.");
            
            return false;
        }
        
        System.out.println("You used an antidote on your " + plant.getName() + "!");
        
        plant.setBugPresence(false);
        plant.increaseSunlightLevel(game, 20);
        plant.increaseWaterLevel(game, 20);
        plant.increaseHealthLevel(20);

        System.out.println("Your plant is healed! You can now water or move it to the window.");
        return true;
    }
}
