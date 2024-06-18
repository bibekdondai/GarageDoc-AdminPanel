package com.example.garagedoc.models;

public class BikeModel {
    private String model;
    private String price;

    public BikeModel() {
        // Default constructor required for calls to DataSnapshot.getValue(BikeModel.class)
    }

    public BikeModel(String model, String price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getPrice() {
        return price;
    }
}
