package Plantits.Options;

import java.util.Map;

import Plantits.Game;

import static java.util.Map.entry;

public abstract class Option {
    private static Map<String, Option> options = Map.ofEntries(
        entry("selectplant", new SelectPlant()),
        entry("shop", new Shop()),
        entry("inventory", new Inventory()),
        entry("useitem", new UseItem()),
        entry("nextday", new NextDay()),
        entry("exit", new Exit())
        );

    public static Option getOption(String value) {
        Option option = options.get(value.toLowerCase());
        if (option == null) {
            return new InvalidOption();
        }
        return option;
    }

    public static void printOptions() {
        System.out.println("- selectplant");
        System.out.println("- shop");
        System.out.println("- inventory");
        System.out.println("- useitem");
        System.out.println("- nextday");
        System.out.println("- exit");
        
    }

    public abstract void runOption(Game game);
}
