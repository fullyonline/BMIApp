package com.example.bmiapp.settings;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.bmiapp.R;
import com.example.bmiapp.util.OptionMenu;

import java.util.ArrayList;
import java.util.HashSet;

public class UserSettingActivity extends OptionMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setting);

        loadDataFromPrefrencesIntoSpinner();

        // spinner
        /* Events behandeln */
        var spinner = (Spinner) findViewById(R.id.spinnerUserSettingsUser);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                var entries = loadDataFromPrefrences();
                var entry = entries.get(position);
                SharedPreferences prefs = getSharedPreferences("usersettings", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("currentusers", entry);
                editor.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // OnClick
        var newUserBtn = (Button) findViewById(R.id.buttonUserSettingsNewUser);
        newUserBtn.setOnClickListener(view -> {
            /* eigenes Layout für Dialog beziehen */
            var dialogView = getLayoutInflater().inflate(R.layout.user_dialog, null);

            new AlertDialog.Builder(this)

                    /* Layout setzen */
                    .setView(dialogView)

                    /* OK-Button behandeln */
                    .setPositiveButton(this.getText(R.string.add_user), (dialog, id) -> {
                        EditText editText = dialogView.findViewById(R.id.editTextTextPersonName);
                        String user = editText.getText().toString();

                        // Persistieren
                        addNewUserToPreferences(user);
                        // Neu Laden
                        loadDataFromPrefrencesIntoSpinner();
                    })

                    /* Cancel-Button behandeln */
                    .setNegativeButton(this.getText(R.string.cancel), (dialog, id) -> dialog.cancel())
                    .create()

                    /* Dialog anzeigen */
                    .show();
        });

    }

    private void addUserToExisting(String user){
        var array = loadDataFromPrefrences();
        array.add(user);
        SharedPreferences prefs = getSharedPreferences("usersettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putStringSet("users", new HashSet<>(array));
        editor.apply();
    }

    private void setCurrentUser(String user){
        SharedPreferences prefs = getSharedPreferences("usersettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("currentusers", user);
        editor.apply();
    }

    private String getCurrentUser(){
        SharedPreferences prefs = getSharedPreferences("usersettings", MODE_PRIVATE);
        return prefs.getString("currentusers", "");
    }

    private void addNewUserToPreferences(String user){
        addUserToExisting(user);
        setCurrentUser(user);
    }

    private ArrayList<String> loadDataFromPrefrences(){
        SharedPreferences prefs = getSharedPreferences("usersettings", MODE_PRIVATE);
        var list = prefs.getStringSet("users", new HashSet<String>());
        return new ArrayList<>(list);
    }

    private void loadDataFromPrefrencesIntoSpinner(){
        // set posible selections
        var arrayList = loadDataFromPrefrences();
        var adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, arrayList);
        var spinner = (Spinner) findViewById(R.id.spinnerUserSettingsUser);
        spinner.setAdapter(adapter);

        // set current selection
        var currentUser = getCurrentUser();
        var index = arrayList.indexOf(currentUser);
        if(index >= 0){
            spinner.setSelection(index);
        }
    }

    @Override
    public int GetActiveActivityId() {
        return R.id.menu_general_item_setting;
    }
}