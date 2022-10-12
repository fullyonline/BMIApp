package com.example.bmiapp.util;

import com.example.bmiapp.R;

public enum BmiCat {
    UNDERWEIGHTSEVERETHINNESS(Double.valueOf(0), Double.valueOf(16), "Underweight (Severe thinness)"),
    UNDERWEIGHTMODERATETHINNESS(Double.valueOf(16), Double.valueOf(17), "Underweight (Moderate thinness)"),
    UNDERWEIGHTMILDTHINNESS(Double.valueOf(17), Double.valueOf(18.5), "Underweight (Mild thinness)"),
    NORMALRANGE(Double.valueOf(18.5), Double.valueOf(25), "Normal range"),
    OVERWEIGHTPREOBESE(Double.valueOf(25), Double.valueOf(30), "Overweight (Pre-obese)"),
    OBESECLASS1(Double.valueOf(30), Double.valueOf(35), "Obese (Class I)"),
    OBESECLASS2(Double.valueOf(35), Double.valueOf(40), "Obese (Class II)"),
    OBESECLASS3(Double.valueOf(40),null, "Obese (Class III) "); // --> >= 40

    private Double high;
    private Double low;
    private String desc;

    BmiCat(Double low, Double high, String desc){
        this.low = low;
        this.high = high;
        this.desc = desc;
    }

    public static String GetDetailDesc(int index){
        String result = "";
        BmiCat[] tmp = BmiCat.NORMALRANGE.getDeclaringClass().getEnumConstants();
        if(tmp != null && tmp[index] != null){
            BmiCat bmicat = tmp[index];
            result = "This categorie starts at " + bmicat.low;
            if(bmicat.high != null){
                result = result + " and stops at " + bmicat.high;
            }
        }
        return result;
    }

    public String GetDesc(){
        return desc;
    }

    public static String GetDescFromIndex(int index){
        BmiCat[] tmp = BmiCat.NORMALRANGE.getDeclaringClass().getEnumConstants();
        if(tmp != null && tmp[index] != null){
            return tmp[index].GetDesc();
        }
        return "";
    }

    public static String getBmiCatStringFromValue(Double value){
        if(value < UNDERWEIGHTSEVERETHINNESS.high){
            return UNDERWEIGHTSEVERETHINNESS.GetDesc();
        }
        else if(value < UNDERWEIGHTMODERATETHINNESS.high){
            return UNDERWEIGHTMODERATETHINNESS.GetDesc();
        }
        else if(value < UNDERWEIGHTMILDTHINNESS.high){
            return UNDERWEIGHTMILDTHINNESS.GetDesc();
        }
        else if(value < NORMALRANGE.high){
            return NORMALRANGE.GetDesc();
        }
        else if(value < OVERWEIGHTPREOBESE.high){
            return OVERWEIGHTPREOBESE.GetDesc();
        }
        else if(value < OBESECLASS1.high){
            return OBESECLASS1.GetDesc();
        }
        else if(value < OBESECLASS2.high){
            return OBESECLASS2.GetDesc();
        }
        return OBESECLASS3.GetDesc();
    }
}
