package com.example.bmiapp.settings;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.bmiapp.R;
import com.example.bmiapp.util.OptionMenu;

public class SettingsActivity extends OptionMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        var createUserBtn = (Button) findViewById(R.id.buttonSettingsUser);
        createUserBtn.setOnClickListener(view -> {
            startActivity(new Intent(this, UserSettingActivity.class));
        });
    }

    @Override
    public int GetActiveActivityId() {
        return R.id.menu_general_item_setting;
    }
}