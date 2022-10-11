package com.example.bmiapp.option;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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
        Integer index = bundle.getInt("selection_position");
        getTextView(R.id.textViewOptionDetailTitel).setText(BmiCat.GetDescFromIndex(index));
        getTextView(R.id.textViewOptionDetailText).setText(BmiCat.GetDetailDesc(index));

        // Big Chungus
        if(BmiCat.NORMALRANGE.getDeclaringClass().getEnumConstants().length -1 == index){
            findViewById(R.id.buttonBigChungus).setVisibility(View.VISIBLE);
        }
        else{
            findViewById(R.id.buttonBigChungus).setVisibility(View.GONE);
        }
        findViewById(R.id.buttonBigChungus).setOnClickListener(view -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://dbxfanon.fandom.com/wiki/Big_Chungus"));
            startActivity(browserIntent);
        });
    }

    private TextView getTextView(int id){
        return findViewById(id);
    }
}