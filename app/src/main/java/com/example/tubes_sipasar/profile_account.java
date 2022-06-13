package com.example.tubes_sipasar;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class profile_account extends AppCompatActivity {

    private EditText EditNama, EditEmail,EditTelp, EditAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_account);

        EditNama = findViewById(R.id.detnama);
        EditEmail = findViewById(R.id.detmail);

        EditNama.setText(getIntent().getStringExtra("Nama"));
        EditEmail.setText(getIntent().getStringExtra("email"));

    }
}