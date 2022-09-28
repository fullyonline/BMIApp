package com.example.bmiapp.option;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bmiapp.R;
import com.example.bmiapp.util.BmiCat;

import java.util.ArrayList;

public class OptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        ListView listView = findViewById(R.id.listViewOption);
        BmiCat[] bmis = BmiCat.NORMALRANGE.getDeclaringClass().getEnumConstants();
        ArrayList<String> array = new ArrayList();

        for (BmiCat bmi : bmis) {
            array.add(bmi.Desc());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
        android.R.layout.simple_list_item_1, array);
        listView.setAdapter(adapter);
    }

}