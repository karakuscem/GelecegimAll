package model;

public class Notebook extends Product{
    private int ram;
    private double screenSize;

    public Notebook(int id, int price, int discount, int stock, String name, Brand brand, int ram, int storage, double screenSize) {
        super(id, price, discount, stock, storage, name, brand);
        this.ram = ram;
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }
}
