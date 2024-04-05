package Plantits.Items;

import java.util.Map;
import static java.util.Map.entry;

public abstract class BuyableItem extends Item {
    private static Map<String, BuyableItem> buyableItems = Map.ofEntries(
        entry("antidote", new Antidote())
    );

    public abstract int cost();

    // Safety: Could return null
    public static BuyableItem getItem(String item) {
        return buyableItems.get(item.toLowerCase());
    }

    public static void printItems() {
        for (String itemName : buyableItems.keySet()) {
            BuyableItem item = buyableItems.get(itemName);
            System.out.println("- " + itemName + " (Cost: $" + item.cost() + ")");
        }
    }
}
