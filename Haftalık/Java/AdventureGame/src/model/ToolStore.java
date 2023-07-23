package model;

import service.ToolStoreService;

import java.util.Scanner;

public class ToolStore extends NormalLocation{
    private final Scanner input = new Scanner(System.in);
    private final ToolStoreService toolStoreService = new ToolStoreService();
    public ToolStore(Player player) {
        super(player, "Tool Store");
    }
    @Override
    public void onLocation() {
        System.out.println("Welcome to the Tool Store!");
        System.out.println("1- Weapons");
        System.out.println("2- Armors");
        System.out.println("3- Exit");
        System.out.print("Make your choice: ");
        int choice = input.nextInt();
        while (choice < 1 || choice > 3) {
            System.out.print("Invalid choice! Try again: ");
            choice = input.nextInt();
        }
        switch (choice) {
            case 1 -> toolStoreService.buyWeapon(getPlayer());
            case 2 -> toolStoreService.buyArmor(getPlayer());
            default -> {
            }
        }
    }

}
