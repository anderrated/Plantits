package Plantits.Items;

import java.util.Map;
import static java.util.Map.entry;

public abstract class BuiltinItem extends Item {
    private static Map<String, BuiltinItem> builtinItems = Map.ofEntries(
        entry("statusprinter", new StatusPrinter()),
        entry("water", new Water()),
        entry("window", new Window())
    );

    // Safety: Could return null
    public static BuiltinItem getItem(String item) {
        return builtinItems.get(item.toLowerCase());
    }

    public static void printItems() {
        for (String item : builtinItems.keySet()) {
            System.out.println("- " + item);
        }
    }
}
