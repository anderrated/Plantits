package Plantits.Items;

import Plantits.Game;
import Plantits.Plants.Plant;

public class Water extends BuiltinItem {
    static int waterCount = 5;
    
    public static int getWaterCount() {
        return waterCount;
    }

    public static int setWaterCount(int factor) {
        waterCount = factor;
        return waterCount;
    }

    public String getName() {
        return "Water";
    }
    
    public boolean useItem(Game game, Plant plant) {
        if (waterCount <= 0) {
            System.out.println("You're out of water.\n");
            return false;
        } 
        
        if (plant.getIsBugPresent()) {
            System.out.println(plant.getName() + " is infested with Bugs! You cannot water this plant.");
            System.out.println("Cure the plant first by buying an antidote from the 'Shop'.\n");
            return false;
        }
        
        System.out.println("You watered your plant!");
        waterCount--;
        System.out.println("Water Count Left: " + waterCount);
   
        plant.increaseWaterLevel(game, 10);
        return true;
    }
}
