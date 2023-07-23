package service;

import model.Player;

import java.util.Scanner;

public class ToolStoreService {
    private final Scanner input = new Scanner(System.in);

    public void buyWeapon(Player player) {
        System.out.println("Weapons");
        System.out.println("1- Gun (2 Damage, 25 Coin)");
        System.out.println("2- Sword (3 Damage, 35 Coin)");
        System.out.println("3- Rifle (7 Damage, 45 Coin)");
        System.out.println("4- Exit");
        System.out.print("Make your choice: ");
        int choice = input.nextInt();
        while (choice < 1 || choice > 4) {
            System.out.print("Invalid choice! Try again: ");
            choice = input.nextInt();
        }
        switch (choice) {
            case 1 -> buyWeapon("Gun", 2, 25, player);
            case 2 -> buyWeapon("Sword", 3, 35, player);
            case 3 -> buyWeapon("Rifle", 7, 45, player);
            default -> {
            }
        }
    }

    public void buyWeapon(String name, int damage, int price, Player player) {
        if (price > player.getMoney()) {
            System.out.println("You don't have enough money!");
        } else {
            System.out.println("You bought " + name + "!");
            player.setMoney(player.getMoney() - price);
            player.getInventory().setWeapon(name, damage);
        }
    }

    public void buyArmor(Player player) {
        System.out.println("Armors");
        System.out.println("1- Light Armor (1 Block, 15 Coin)");
        System.out.println("2- Medium Armor (3 Block, 25 Coin)");
        System.out.println("3- Heavy Armor (5 Block, 40 Coin)");
        System.out.println("4- Exit");
        System.out.print("Make your choice: ");
        int choice = input.nextInt();
        while (choice < 1 || choice > 4) {
            System.out.print("Invalid choice! Try again: ");
            choice = input.nextInt();
        }
        switch (choice) {
            case 1 -> buyArmor("Light Armor", 1, 15, player);
            case 2 -> buyArmor("Medium Armor", 3, 25, player);
            case 3 -> buyArmor("Heavy Armor", 5, 40, player);
        }
    }

    public void buyArmor(String name, int block, int price, Player player) {
        if (price > player.getMoney()) {
            System.out.println("You don't have enough money!");
        } else {
            System.out.println("You bought " + name + "!");
            player.setMoney(player.getMoney() - price);
            player.getInventory().setArmor(name, block);
        }
    }
}
