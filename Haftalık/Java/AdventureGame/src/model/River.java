package model;

import service.BattleLocationService;

import java.util.Scanner;

public class River extends BattleLocation{
    public River(Player player) {
        super(player, new Bear(), "River", (int) (Math.random() * 3 + 1));
    }

    @Override
    public void onLocation() {
        int obsNum = this.getObNum();
        int i = 0;
        BattleLocationService battleLocationService = new BattleLocationService();
        Scanner input = new Scanner(System.in);
        while (i < obsNum)
        {
            this.setObstacle(new Bear());
            System.out.println("You are in the " + this.getName() + "!");
            System.out.println("Be careful! There are " + (obsNum - i) + " " +  this.getObstacle().getName() + " here!");
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
                    getPlayer().setMoney(getPlayer().getMoney() + this.getObstacle().getMoney());
                    i++;
                    System.out.println(i);
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
            getPlayer().getInventory().setWater(true);
            setCompleted(true);
        }
        else
        {
            System.out.println("You couldn't kill all the " + this.getObstacle().getName() + "s!");
        }
    }
}
