package Plantits.Plants;

import java.util.Map;
import java.util.Random;

import Plantits.Game;

import static java.util.Map.entry;

public abstract class Plant {
    private static Map<String, Plant> plants = Map.ofEntries(
        entry("cactus", new Cactus()),
        entry("begonia", new Begonia()),
        entry("lavender", new Lavender()),
        entry("hydrangea", new Hydrangea()),
        entry("sunflower", new Sunflower())
    );

    private int healthLevel;
    private int waterLevel;
    private int sunlightLevel;
    private boolean isBugPresent;

    public Plant() {
        this.healthLevel = enforceBounds(100);
        this.waterLevel = enforceBounds(50);
        this.sunlightLevel = enforceBounds(50);
        this.isBugPresent = false;
    }
    
    public abstract int cost();
    public abstract int sellingPrice();
    public abstract String getName();
    
    public void nextDay(Game game) {
        if (isBugPresent) {
            boolean didPlantDie = damagePlant(30);
            if (didPlantDie) {
                game.gameOver(this);
            }

            waterLevel = enforceBounds(waterLevel - 30);
            sunlightLevel = enforceBounds(sunlightLevel - 30);

        } else {
            boolean didPlantDie = damagePlant(10);
            if (didPlantDie) {
                game.gameOver(this);
            }

             waterLevel = enforceBounds(waterLevel - 10);
            sunlightLevel = enforceBounds(sunlightLevel - 10);

          
            setRandomBugPresence();
        }
    }

    // returns true if the plant dies
    public boolean damagePlant(int damage) {
        healthLevel = enforceBounds(healthLevel - damage);
        if (healthLevel <= 0) {
            return true;
        }
        return false;
    }

    public void setRandomBugPresence() {
        // randomized number to determine if bugs are present
        Random random = new Random();
        double probability = 0.30;
        isBugPresent = random.nextDouble() < probability;
    }

    public boolean reachedPlantReqs() {
        if (getWaterLevel() >= 100 && getSunlightLevel() >=100) {
            return true;
        }
        return false;
    }

    public void fullyGrown(Game game) {
        game.setMoney(game.getMoney() + sellingPrice());

        System.out.println();
        System.out.println("Your " + getName() + " has fully grown!");
        System.out.println("Selling your plant...\n");
        System.out.println("You have earned $" + sellingPrice() + " !!!");
        System.out.println("Current Money: " + game.getMoney());

        game.removePlant(this);
    }

    public void increaseWaterLevel(Game game, int factor) {
        waterLevel = enforceBounds(waterLevel + factor);
        if(reachedPlantReqs()) {
            fullyGrown(game);
        }
    }

    public void increaseSunlightLevel(Game game, int factor) {
        sunlightLevel = enforceBounds(sunlightLevel + factor);
        if(reachedPlantReqs()) {
            fullyGrown(game);
        }
    }

    public void increaseHealthLevel(int factor) {
        healthLevel = enforceBounds(healthLevel + factor);
    }

    // Safety: Could return null
    public static Plant getPlant(String plant) {
        return plants.get(plant.toLowerCase());
    }

    public static void printPlants() {
        for (String plantName : plants.keySet()) {
            Plant plant = plants.get(plantName);
            System.out.println("- " + plantName + " (Cost: $" + plant.cost() + ")");
        }
    }
    
    public int getWaterLevel() {
        return waterLevel;
    }

    public int getSunlightLevel() {
        return sunlightLevel;
    }

    public int getHealthLevel() {
        return healthLevel;
    }

    public boolean getIsBugPresent() {
        return isBugPresent;
    }

    public void setBugPresence(boolean value) {
        isBugPresent = value;
    }


    private int enforceBounds(int value) {
        return Math.max(0, Math.min(100, value));
    }

}
