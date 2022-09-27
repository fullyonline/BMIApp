package com.example.bmiapp.util;

public class Bmi {
    // attributes
    private Integer height;
    private Double weight;

    public void clearValues(){
        height = null;
        weight = null;
    }

    // methods
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getBmi() {
        return getWeight() / (getHeight() * getHeight());
    }

    public String getBmiCat(){
        return BmiCat.getBmiCatStringFromValue(getBmi());
    }

}
