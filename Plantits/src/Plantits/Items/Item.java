package Plantits.Items;

import Plantits.Game;
import Plantits.Plants.Plant;

public abstract class Item {
    public abstract String getName();
    public abstract boolean useItem(Game game, Plant plant);
}
