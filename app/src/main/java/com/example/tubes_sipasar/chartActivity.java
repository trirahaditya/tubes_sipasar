package com.example.tubes_sipasar;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class chartActivity extends AppCompatActivity {

    private TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        total = findViewById(R.id.hargatotalbelanja);

        total.setText(getIntent().getStringExtra("totalbelanja"));

//        Button buttonShow = findViewById(R.id.showbayar);
//        buttonShow

    }
}