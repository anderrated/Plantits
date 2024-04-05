package Plantits.Items;

import Plantits.Game;
import Plantits.Plants.Plant;

public class Window extends BuiltinItem {
    static int windowCount = 5;
    
    public static int getWindowCount() {
        return windowCount;
    }

    public static int setWindowCount(int factor) {
        windowCount = factor;
        return windowCount;
    }

    public String getName() {
        return "Window";
    }
    
    public boolean useItem(Game game, Plant plant) {
        if (windowCount <= 0) {
            System.out.println("You're out of moves to the window!");
            return false;
        } 
        
        if (plant.getIsBugPresent()) {
            System.out.println(plant.getName() + " is infested with Bugs! You cannot move this plant near the window.");
            System.out.println("Cure the plant first by buying an antidote from the 'Shop'.");
            return false;
        }
        
        windowCount--;
        System.out.println("The sun kissed your plant!");
        System.out.println("Window Count: " + windowCount);
        
        plant.increaseSunlightLevel(game, 10);
        return true;
    }
}
