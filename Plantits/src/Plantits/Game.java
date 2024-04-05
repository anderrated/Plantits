package Plantits;

import java.util.ArrayList;
import java.util.HashMap;

import Plantits.Items.BuyableItem;
import Plantits.Plants.Plant;

public class Game {
    public static final int MAX_ITEM_SIZE = 5;
    public static final int MAX_PLANT_SIZE = 5;
    public static final String FILE_NAME = "plantits.titi";
    private static final int MAX_MONEY = 5000;
    private boolean isGameOver;
    private int money;
    private HashMap<BuyableItem, Integer> boughtItems;
    private ArrayList<Plant> plants;
    private Plant selectedPlant;

    public Game(int initialMoney) {
        try {
            GameData gameData = GameData.load(FILE_NAME);
            this.isGameOver = false;
            this.money = gameData.money;
            this.boughtItems = gameData.boughtItems;
            this.plants = gameData.plants;
            this.selectedPlant = gameData.selectedPlant;
        } catch (Exception e) {
            System.err.println(e);
            this.isGameOver = false;
            this.money = Math.min(initialMoney, MAX_MONEY);
            this.boughtItems = new HashMap<>();
            this.plants = new ArrayList<>();
            this.selectedPlant = null;
        }
    }

    public GameData gameData() {
        return new GameData(money, boughtItems, plants, selectedPlant);
    }

    public void gameOver(Plant plant) {
        isGameOver = true;
        System.out.println("Game Over: " + plant.getName() + " died");
    }

    public boolean selectPlant(int index) {
        if (index < 0 || index >= plants.size()) return false;
        selectedPlant = plants.get(index);
        return true;
    }

    public Plant retrieveSelectedPlant() {
        return selectedPlant;
    }

    public Plant getPlant(int index) {
        return plants.get(index);
    }

    public void listItems() {
        listBoughtItems();
    }

    public void listBoughtItems() {
        for (BuyableItem item : boughtItems.keySet()) {
            System.out.println("- " + item.getName() + " x" + boughtItems.get(item));
        }
    }

    public boolean isItemAvailable(BuyableItem item) {
        return boughtItems.containsKey(item);
    }

    // returns false if item is not available
    public void useBoughtItem(BuyableItem itemUsed) {

        int itemsLeft = boughtItems.get(itemUsed);
        if (itemsLeft <= 1) {
            boughtItems.remove(itemUsed);
        } else {
            boughtItems.put(itemUsed, boughtItems.get(itemUsed) - 1);
        }

    }

    public void listPlants() {
        for (int i = 0; i < plants.size(); i++) {
            Plant plant = plants.get(i);
            System.out.println("Slot #" + i + ": " + plant.getName());
        }
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public int getMoney() {
        return money;
    }
    
    public void setMoney(int value) {
        money = Math.min(value, MAX_MONEY);
    }

    public void addItem(BuyableItem item) {
        if (boughtItems.containsKey(item)) {
            boughtItems.put(item, boughtItems.get(item) + 1);
        }
        else {
            boughtItems.put(item, 1);
        }
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void removePlant(Plant plant) {
        plants.remove(plant);
    }
    

    public int boughtItemsCount() {
        int total = 0;
        for (BuyableItem item : boughtItems.keySet()) {
            total += boughtItems.get(item);
        }
        return total;
    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public HashMap<BuyableItem, Integer> getBoughtItems() {
        return boughtItems;
    }

}
