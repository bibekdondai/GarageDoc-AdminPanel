package com.example.garagedoc.models;

public class BikePart {
    private String part;
    private double price;
    private int quantity;

    public BikePart() {
        // Default constructor required for calls to DataSnapshot.getValue(BikePart.class)
    }

    public BikePart(String part, double price, int quantity) {
        this.part = part;
        this.price = price;
        this.quantity = quantity;
    }

    public String getPart() {
        return part;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
