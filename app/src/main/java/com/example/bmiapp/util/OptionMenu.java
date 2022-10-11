package com.example.bmiapp.util;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bmiapp.MainActivity;
import com.example.bmiapp.R;
import com.example.bmiapp.calculate.BmiActivity;
import com.example.bmiapp.option.OptionActivity;

public abstract class OptionMenu extends AppCompatActivity {

    public abstract int GetActiveActivityId();

    @Override
    public boolean onPrepareOptionsMenu (Menu menu) {
        MenuItem menuItem = menu.findItem(GetActiveActivityId());
        menuItem.setEnabled(false);
        return true;
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
            case R.id.menu_general_item_home:
                startActivity(new Intent(this, MainActivity.class));
                return true;
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
