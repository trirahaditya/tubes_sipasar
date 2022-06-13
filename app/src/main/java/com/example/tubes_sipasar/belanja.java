package com.example.tubes_sipasar;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class belanja extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belanja);

        getSupportActionBar().hide();
    }
}