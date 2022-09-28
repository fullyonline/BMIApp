package com.example.bmiapp.calculate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bmiapp.R;

public class BmiActivity extends AppCompatActivity {

    private EditText getEditText(int id){
        return findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        // button Clear all values
        var clearButton = (Button)findViewById(R.id.buttonClear);
        clearButton.setOnClickListener(view -> {
            getEditText(R.id.editTextHeight).setText("");
            getEditText(R.id.editTextWeight).setText("");
        });

        // get bmi and transfer to new activity
        var calculateBmiButton = (Button)findViewById(R.id.buttonCalculateBmi);
        calculateBmiButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, BmiResultActivity.class);
            intent.putExtra("bmi_height", Double.parseDouble(getEditText(R.id.editTextHeight).getText().toString()));
            intent.putExtra("bmi_weight", Double.parseDouble(getEditText(R.id.editTextWeight).getText().toString()));
            startActivity(intent);
        });
    }
}