package model;

public class Samurai extends Character {
    public Samurai() {
        super(1, 5, 21, 1500);
    }

    @Override
    public String getName() {
        return "Samurai";
    }
}
