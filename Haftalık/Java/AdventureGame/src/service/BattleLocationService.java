package service;

import model.Obstacle;
import model.Player;

import java.util.Scanner;

public class BattleLocationService {
    public boolean combat(Player player, Obstacle obstacle) {
        int turn = Math.random() < 0.5 ? 0 : 1;
        Scanner input = new Scanner(System.in);
        while (player.getHealth() > 0 && obstacle.getHealth() > 0)
        {
            if (turn == 0)
            {
                System.out.println("\nYour health: " + player.getHealth());
                System.out.println(obstacle.getName() + "'s health: " + obstacle.getHealth());
                System.out.println("1- Attack");
                System.out.println("2- Run");
                System.out.print("Make your choice: ");
                int choice = input.nextInt();
                while (choice < 1 || choice > 2) {
                    System.out.print("Invalid choice! Try again: ");
                    choice = input.nextInt();
                }
                if (choice == 1)
                {
                    System.out.println("\nYou attacked the " + obstacle.getName() + "!");
                    int damage = Math.max(0, player.getDamage());
                    obstacle.setHealth(obstacle.getHealth() - damage);
                    System.out.println("You gave " + damage + " damage to the " + obstacle.getName() + "!");
                    turn = 1;
                }
                else
                {
                    System.out.println("\nYou ran away from the " + obstacle.getName() + "!");
                    break;
                }
            }
            else
            {
                System.out.println("\nYour health: " + player.getHealth());
                System.out.println(obstacle.getName() + "'s health: " + obstacle.getHealth());
                System.out.println("The " + obstacle.getName() + " attacked you!");
                int damage = Math.max(0, obstacle.getDamage() - player.getInventory().getArmorBlock());
                player.setHealth(player.getHealth() - damage);
                System.out.println("The " + obstacle.getName() + " gave " + damage + " damage to you!");
                turn = 0;
            }
        }
        return player.getHealth() > 0;
    }
}
