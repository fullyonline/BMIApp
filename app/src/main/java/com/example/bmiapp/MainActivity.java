package com.example.bmiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bmiapp.calculate.BmiActivity;
import com.example.bmiapp.option.OptionActivity;
import com.example.bmiapp.util.OptionMenu;

public class MainActivity extends OptionMenu {

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

    @Override
    public int GetActiveActivityId() {
        return R.id.menu_general_item_home;
    }
}