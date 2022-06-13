package com.example.tubes_sipasar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class nomor_telp extends AppCompatActivity {

    private Button nextstep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nomor_telp);

        getSupportActionBar().hide();

        nextstep = findViewById(R.id.btnnext);

        nextstep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(nomor_telp.this, lokasi.class);
                startActivity(next);
            }
        });
            }
    }