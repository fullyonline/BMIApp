package com.example.bmiapp.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.bmiapp.R;
import com.example.bmiapp.util.Bmi;

public class BmiResultActivity extends AppCompatActivity {

    private Bmi bmi;

    private TextView getTextView(int id){
        return findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        Bundle bundle = getIntent().getExtras();
        // set up bmi class
        bmi = new Bmi();
        bmi.setHeight(bundle.getInt("bmi_height"));
        bmi.setWeight(bundle.getDouble("bmi_weight"));

        // set text views
        getTextView(R.id.textViewResultHeigthShow).setText(bmi.getHeight().toString());
        getTextView(R.id.textViewResultWeightShow).setText(bmi.getWeight().toString());

        getTextView(R.id.textViewResultBmiShow).setText(bmi.getBmiCat());
    }
}