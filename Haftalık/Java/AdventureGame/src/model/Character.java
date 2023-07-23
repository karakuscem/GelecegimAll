package model;

public abstract class Character {
    private final int id;
    private final int damage;
    private final int health;
    private final int money;

    public Character(int id, int damage, int health, int money) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getMoney() {
        return money;
    }

    public abstract String getName();
}
