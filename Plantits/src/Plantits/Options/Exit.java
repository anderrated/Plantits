package Plantits.Options;

import java.io.IOException;

import Plantits.Game;
import Plantits.GameData;

public class Exit extends Option {
    public void runOption(Game game) {
        GameData gameData = game.gameData();
        try {
            gameData.save(Game.FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}


