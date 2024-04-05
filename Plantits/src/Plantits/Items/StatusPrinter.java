package Plantits.Items;
import Plantits.Game;
import Plantits.Plants.Plant;

public class StatusPrinter extends BuiltinItem {
    public String getName() {
        return "StatusPrinter";
    }

    public boolean useItem(Game game, Plant plant) {
        System.out.println("════════════════════════════════════");
        System.out.println("DISPLAYING STATUS FOR PLANT: " + plant.getName());
        System.out.println("════════════════════════════════════");
        
        int waterLvl = plant.getWaterLevel();
        System.out.println(plant.getName() + " Water Level: " +  waterLvl);

        int sunlightLvl = plant.getSunlightLevel();
        System.out.println(plant.getName() + " Sunlight Level: " +  sunlightLvl);

        int healthLvl = plant.getHealthLevel();
        System.out.println(plant.getName() + " Health Level: " + healthLvl);

        boolean bugPresence = plant.getIsBugPresent();
        if (bugPresence) {
            System.out.println(plant.getName() + " is infested with Bugs!");
            return false;
        }

        System.out.println(plant.getName() + " is free from Bugs!");
        return true;

    }
}