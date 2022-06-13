package com.example.tubes_sipasar;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    private TextView txtDaftar,txtLupa;
    private EditText editEmail, editPass;
    private Button login;
    private CheckBox showpass;
    String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        editEmail = findViewById(R.id.editmail);
        editPass = findViewById(R.id.editpass);
        login = findViewById(R.id.login);
        txtDaftar = findViewById(R.id.daftar);
        showpass = findViewById(R.id.cekpass);
        txtLupa = findViewById(R.id.lupapass);

        editEmail.setText(getIntent().getStringExtra("email"));
        editPass.setText(getIntent().getStringExtra("password"));

        txtDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(login.this, signup.class);
                startActivity(d);
            }
        });
        login.setOnClickListener(view -> {
            nama = editEmail.getText().toString();
            if(editEmail.getText().length()>0 && editPass.getText().length()>0){
                login(editEmail.getText().toString(), editPass.getText().toString());
            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(login.this);
                builder.setMessage("Silahkan Masukkan Email dan Password Anda!").setNegativeButton("Retry", null).create().show();
            }
        });
        showpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(!isChecked){
                    editPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else{
                    editPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

    }
    public void login(String email, String password){
        Toast.makeText(getApplicationContext(), "Halo, "+nama, Toast.LENGTH_LONG).show();
        Intent l = new Intent(login.this, sakti.class);
        l.putExtra("username", editEmail.getText().toString());
        startActivity(l);
    }
}