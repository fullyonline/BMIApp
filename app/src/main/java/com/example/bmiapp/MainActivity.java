package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.bmiapp.calculate.BmiActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        var button = findViewById(R.id.buttonGoToCalculator);
        button.setOnClickListener(view -> openBmiInputActivity());

    }

    public void openBmiInputActivity(){
        Intent intent = new Intent(this, BmiActivity.class);
        startActivity(intent);
    }
}