package service;

import model.Character;
import model.Inventory;
import model.Player;

public class PlayerService {
    public void setCharacter(Player player, Character character) {
        player.setCharacter(character);
        player.setInventory(new Inventory());
    }
}
