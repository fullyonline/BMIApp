package com.example.bmiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bmiapp.calculate.BmiActivity;
import com.example.bmiapp.option.OptionActivity;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_general, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.menu_general_item_rating:
                startActivity(new Intent(this, OptionActivity.class));
                return true;
            case R.id.menu_general_item_calculator:
                startActivity(new Intent(this, BmiActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}