package model;

public class Knight extends Character{
    public Knight() {
        super(3, 8, 24, 5);
    }

    @Override
    public String getName() {
        return "Knight";
    }
}
