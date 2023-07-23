package service;

import model.Location;
import model.Player;
import model.SafeHouse;

public class LocationService {
    public void selectLocation(Player player) {
        System.out.println("\nCharacter Info");
        System.out.println("Name: " + player.getName() + "\nHealth: " + player.getHealth()
                + "\nDamage: " + player.getTotalDamage() + "\nMoney: " + player.getMoney()
                + "\nWeapon: " + player.getInventory().getWeaponName() + "\nArmor: "
                + player.getInventory().getArmorName());
        System.out.println("\nSelect a location to move");
        System.out.println("1- Safe House" + "\n2- Tool Store" + "\n3- Forest" + "\n4- Cave" + "\n5- River"
                + "\n6- Mine"+ "\n0- Exit");

    }

    public void safeHouse(Player player, Location safeHouse) {
        if (player.getInventory().isFirewood() && player.getInventory().isFood() && player.getInventory().isWater()) {
            System.out.println("\nYou have collected all items.");
            System.out.println("You win the game.");
        } else {
            player.setLocation(safeHouse);
            safeHouse.onLocation();
        }
    }

    public void toolStore(Player player, Location toolStore) {
        player.setLocation(toolStore);
        toolStore.onLocation();
    }

    public void forest(Player player, Location forest) {
        if (player.getInventory().isFirewood()) {
            System.out.println("\nYou have already collected the firewood.");
            System.out.println("You can't collect the firewood again.");
        } else {
            player.setLocation(forest);
            forest.onLocation();
        }
    }

    public void cave(Player player, Location cave) {
        if (player.getInventory().isFood()) {
            System.out.println("\nYou have already collected the food.");
            System.out.println("You can't collect the food again.");
        } else {
            player.setLocation(cave);
            cave.onLocation();
        }
    }

    public void river(Player player, Location river) {
        if (player.getInventory().isWater()) {
            System.out.println("\nYou have already collected the water.");
            System.out.println("You can't collect the water again.");
        } else {
            player.setLocation(river);
            river.onLocation();
        }
    }

    public void mine(Player player, Location mine) {
        player.setLocation(mine);
        mine.onLocation();
    }
}
