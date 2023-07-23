package model;

public class SafeHouse extends NormalLocation{
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public void onLocation() {
        System.out.println("You are in the safe house.");
        System.out.println("Your health is full.");
        getPlayer().setHealth(getPlayer().getOriginalHealth());
    }
}
