package org.example.data.entity;

public class Game {
    private int id;
    private String name;
    private double price;
    private SpecialOffer specialOffer;

    public Game() {
    }

    public Game(int id, String name, double price, SpecialOffer specialOffer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.specialOffer = specialOffer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public SpecialOffer getSpecialOffer() {
        return specialOffer;
    }

    public void setSpecialOffer(SpecialOffer specialOffer) {
        this.specialOffer = specialOffer;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", specialOffer=" + specialOffer +
                '}';
    }
}
