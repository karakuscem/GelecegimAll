package model;

public class Archer extends Character{
    public Archer() {
        super(2, 7, 18, 20);
    }

    @Override
    public String getName() {
        return "Archer";
    }
}
