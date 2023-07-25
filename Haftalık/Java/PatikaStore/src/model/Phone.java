package model;

public class Phone extends Product{
    private double screenSize;
    private int ram;
    private int batteryPower;
    private String color;

    public Phone(int id, int price, int discount, int stock, String name, Brand brand, int storage,
                 double screenSize, int ram, int batteryPower, String color) {
        super(id, price, discount, stock, storage, name, brand);
        this.screenSize = screenSize;
        this.ram = ram;
        this.batteryPower = batteryPower;
        this.color = color;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
