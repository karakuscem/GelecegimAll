package model;

public abstract class Product {
    private final int id;
    private int price;
    private int discount;
    private int stock;
    private int storage;
    private String name;
    private Brand brand;

    public Product(int id, int price, int discount, int stock, int storage, String name, Brand brand) {
        this.id = id;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
        this.storage = storage;
        this.name = name;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }
}
