package com.example.bmiapp.util;

public class Bmi {
    // attributes
    private Double height;
    private Double weight;

    // methods
    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getBmi() {
        return weight / ((height / 100) * (height / 100));
    }

    public String getBmiCat(){
        return BmiCat.getBmiCatStringFromValue(getBmi());
    }

}
