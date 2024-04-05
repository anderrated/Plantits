package Plantits;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import Plantits.Items.BuyableItem;
import Plantits.Plants.Plant;

public class GameData {
    public int money;
    public HashMap<BuyableItem, Integer> boughtItems;
    public ArrayList<Plant> plants;
    public Plant selectedPlant;

    public GameData() {
    }

    public GameData(int money, HashMap<BuyableItem, Integer> boughtItems, ArrayList<Plant> plants, Plant selectedPlant) {
        this.money = money;
        this.boughtItems = boughtItems;
        this.plants = plants;
        this.selectedPlant = selectedPlant;
    }

    public static GameData load(String filename) throws IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream(filename);
        GameData gameData = new GameData();
        gameData.readExternal(in);

        return gameData;
    }

    public void save(String filename) throws IOException {
        FileOutputStream out = new FileOutputStream(filename);
        writeExternal(out);
    }


    // DANGEROUS AREA
    private void writeExternal(FileOutputStream outStream) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(outStream));

        // Magic
        out.writeUTF("titi");

        out.writeInt(money);
        
        out.writeInt(boughtItems.size());
        for (BuyableItem item : boughtItems.keySet()) {
            out.writeUTF(item.getName());
            out.writeInt(boughtItems.get(item));
        }

        out.writeInt(plants.size());
        for (Plant plant : plants) {
            out.writeUTF(plant.getName());
        }

        if (selectedPlant != null) {
            out.writeBoolean(true);
            out.writeUTF(selectedPlant.getName());
        } else {
            out.writeBoolean(false);
        }
        out.flush();
        out.close();
    }

    private void readExternal(FileInputStream inStream) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(inStream));

        String magic = in.readUTF();
        if (!magic.equals("titi")) {
            throw new ClassNotFoundException();
        }

        this.money = in.readInt();

        this.boughtItems = new HashMap<>();
        int numberOfItems = in.readInt();
        for (int i = 0; i < numberOfItems; ++i) {
            String itemString = in.readUTF();
            int itemInt = in.readInt();
            this.boughtItems.put(BuyableItem.getItem(itemString), itemInt);
        }

        this.plants = new ArrayList<>();
        int numberOfPLants = in.readInt();
        for (int i = 0; i < numberOfPLants; ++i) {
            this.plants.add(Plant.getPlant(in.readUTF()));
        }

        boolean isSelectedPlantAvailable = in.readBoolean();
        if (isSelectedPlantAvailable) {
            this.selectedPlant = Plant.getPlant(in.readUTF());
        } else {
            this.selectedPlant = null;
        }
        in.close();
    }
}
