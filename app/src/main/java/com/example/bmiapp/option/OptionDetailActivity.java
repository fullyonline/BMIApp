package com.example.bmiapp.option;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.bmiapp.R;
import com.example.bmiapp.util.Bmi;
import com.example.bmiapp.util.BmiCat;

import java.text.MessageFormat;

public class OptionDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_detail);

        Bundle bundle = getIntent().getExtras();
        Integer pos = bundle.getInt("selection_position");
        BmiCat [] bmicats = BmiCat.NORMALRANGE.getDeclaringClass().getEnumConstants();
        if(bmicats[pos] != null){
            getTextView(R.id.textViewOptionDetailTitel).setText(bmicats[pos].Desc().toString());
        }
    }

    private TextView getTextView(int id){
        return findViewById(id);
    }
}