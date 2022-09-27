package com.example.bmiapp.util;

public enum BmiCat {
    UNDERWEIGHTSEVERETHINNESS(Double.valueOf(16), "Underweight (Severe thinness)"),
    UNDERWEIGHTMODERATETHINNESS(Double.valueOf(17), "Underweight (Moderate thinness)"),
    UNDERWEIGHTMILDTHINNESS(Double.valueOf(18.5), "Underweight (Mild thinness)"),
    NORMALRANGE(Double.valueOf(25), "Normal range"),
    OVERWEIGHTPREOBESE(Double.valueOf(30), "Overweight (Pre-obese)"),
    OBESECLASS1(Double.valueOf(35), "Obese (Class I)"),
    OBESECLASS2(Double.valueOf(40), "Obese (Class II)"),
    OBESECLASS3(null, "Obese (Class III) "); // --> >= 40

    private Double value;
    private String desc;

    BmiCat(Double value, String desc){
        this.value = value;
        this.desc = desc;
    }
    public Double Value(){
        return value;
    }
    public String Desc(){
        return desc;
    }

    public static String getBmiCatStringFromValue(Double value){
        if(value < UNDERWEIGHTSEVERETHINNESS.Value()){
            return UNDERWEIGHTSEVERETHINNESS.Desc();
        }
        else if(value < UNDERWEIGHTMODERATETHINNESS.Value()){
            return UNDERWEIGHTMODERATETHINNESS.Desc();
        }
        else if(value < UNDERWEIGHTMILDTHINNESS.Value()){
            return UNDERWEIGHTMILDTHINNESS.Desc();
        }
        else if(value < NORMALRANGE.Value()){
            return NORMALRANGE.Desc();
        }
        else if(value < OVERWEIGHTPREOBESE.Value()){
            return OVERWEIGHTPREOBESE.Desc();
        }
        else if(value < OBESECLASS1.Value()){
            return OBESECLASS1.Desc();
        }
        else if(value < OBESECLASS2.Value()){
            return OBESECLASS2.Desc();
        }
        return OBESECLASS3.Desc();
    }
}
