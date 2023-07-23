package service;

import model.*;

import java.util.Scanner;

public class GameService {
    private final Scanner input = new Scanner(System.in);
    PlayerService playerService = new PlayerService();
    LocationService locationService = new LocationService();

    public void start(){
        System.out.println("Welcome to adventure game !\n");
        System.out.println("In order to win the game, you must collect all items from battle locations");
        System.out.println("Please enter a name for your character: ");
        System.out.print("Enter a name: ");

        String playerName = input.nextLine();
        Player player = new Player(playerName);
        Location safeHouse = new SafeHouse(player);
        Location toolStore = new ToolStore(player);
        Location forest = new Forest(player);
        Location cave = new Cave(player);
        Location river = new River(player);
        Location mine = new Mine(player);


        System.out.println("Welcome " + player.getName());
        System.out.println("\n####Select a character####");
        System.out.println("1- Samurai " + "\n2- Archer " + "\n3- Knight");

        int selectChar = input.nextInt();
        while (selectChar < 1 || selectChar > 3) {
            System.out.println("Wrong selection, please try again");
            selectChar = input.nextInt();
        }
        switch (selectChar) {
            case 1 -> playerService.setCharacter(player, new Samurai());
            case 2 -> playerService.setCharacter(player, new Archer());
            case 3 -> playerService.setCharacter(player, new Knight());
        }
        System.out.println("Your character is " + player.getCharacter().getName());

        System.out.println("Let the adventure begin !");

        while (true) {
            if (player.getHealth() <= 0)
                break;
            locationService.selectLocation(player);
            int selectLocation = input.nextInt();
            while (selectLocation < 0 || selectLocation > 6) {
                System.out.println("Wrong selection, please try again");
                selectLocation = input.nextInt();
            }
            if (selectLocation == 0) {
                System.out.println("Exiting game...");
                break;
            }
            else if (selectLocation == 1) {
                if (player.getInventory().isFirewood() && player.getInventory().isFood()
                        && player.getInventory().isWater()) {
                    System.out.println("\nYou have collected all items.");
                    System.out.println("You win the game.");
                    break;
                } else {
                    locationService.safeHouse(player, safeHouse);
                }
            }
            else {
                switch (selectLocation) {
                    case 2 -> locationService.toolStore(player, toolStore);
                    case 3 -> locationService.forest(player, forest);
                    case 4 -> locationService.cave(player, cave);
                    case 5 -> locationService.river(player, river);
                    case 6 -> locationService.mine(player, mine);
                }
            }
        }

    }
}
