package Plantits.Options;
import Plantits.Game;
import Plantits.Items.Water;
import Plantits.Items.Window;
import Plantits.Plants.Plant;

public class NextDay extends Option {
    public void runOption(Game game) {
        System.out.println("\r\n" + //
                "                   |\r\n" + //
                "               \\       /\r\n" + //
                "                 .-\"-.\r\n" + //
                "            --  /     \\  --\r\n" + //
                "`~^~^~^~~^~^~^~-=======-~^~^~^~~^~^~^~`");
        System.out.println("Welcome to the next day! Good Morning :p\n");

        Water.setWaterCount(5);
        Window.setWindowCount(5);
        
        for (Plant plant : game.getPlants()) {
            plant.nextDay(game);
        }


    }
}
