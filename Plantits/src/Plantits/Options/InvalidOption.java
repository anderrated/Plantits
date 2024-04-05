package Plantits.Options;
import Plantits.Game;

public class InvalidOption extends Option {
    public void runOption(Game game) {
        System.out.println("Invalid Option, Try again!");
    }
}
