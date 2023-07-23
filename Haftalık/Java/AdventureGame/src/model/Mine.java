package model;

import service.BattleLocationService;

import java.util.Scanner;

public class Mine extends BattleLocation{
    public Mine(Player player) {
        super(player, new Snake(), "Mine", (int) (Math.random() * 4 + 1));
    }

    @Override
    public void onLocation() {
        int obsNum = this.getObNum();
        int i = 0;
        BattleLocationService battleLocationService = new BattleLocationService();
        Scanner input = new Scanner(System.in);
        while (i < obsNum)
        {
            this.setObstacle(new Snake());
            System.out.println("You are in the " + this.getName() + "!");
            System.out.println("Be careful! There are " + obsNum + " " +  this.getObstacle().getName() + " here!");
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
                if (battleLocationService.combat(this.getPlayer(), this.getObstacle()))
                {
                    System.out.println("You killed the " + this.getObstacle().getName() + "!");
                    getRandomItem();
                    i++;
                    if (i < obsNum)
                    {
                        System.out.println("There are " + (obsNum - i) + " more " + this.getObstacle().getName() + "s left.");
                    }
                }
                else
                {
                    System.out.println("You are dead!");
                    break;
                }
            }
            else
            {
                System.out.println("You ran away from the " + this.getObstacle().getName() + "!");
                break;
            }
        }
        if (i == obsNum)
        {
            System.out.println("You killed all the " + this.getObstacle().getName() + "s!");
        }
        else
        {
            System.out.println("You couldn't kill all the " + this.getObstacle().getName() + "s!");
        }
    }

    public void getRandomItem() {
        int random = (int) (Math.random() * 100 + 1);
        if (random <= 15) {
            System.out.println("You got a Sword!");
            getPlayer().getInventory().setWeapon("Sword", 3);
        }
        else if (random <= 35) {
            System.out.println("You got a Rifle!");
            getPlayer().getInventory().setWeapon("Rifle", 7);
        }
        else if (random <= 65) {
            System.out.println("You got a Gun!");
            getPlayer().getInventory().setWeapon("Gun", 2);
        }
        else if (random <= 80) {
            System.out.println("You got a Heavy Armor!");
            getPlayer().getInventory().setArmor("Heavy", 5);
        }
        else if (random <= 100) {
            System.out.println("You got a Medium Armor!");
            getPlayer().getInventory().setArmor("Medium", 3);
        }
        else if (random <= 120) {
            System.out.println("You got a Light Armor!");
            getPlayer().getInventory().setArmor("Light", 1);
        }
        else if (random <= 145) {
            System.out.println("You got 10 Money!");
            getPlayer().setMoney(getPlayer().getMoney() + 10);
        }
        else if (random <= 175) {
            System.out.println("You got 5 Money!");
            getPlayer().setMoney(getPlayer().getMoney() + 5);
        }
        else if (random <= 225) {
            System.out.println("You got 1 Money!");
            getPlayer().setMoney(getPlayer().getMoney() + 1);
        }
        else {
            System.out.println("You got nothing!");
        }
    }
}
