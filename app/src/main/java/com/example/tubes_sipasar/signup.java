package com.example.tubes_sipasar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {

    private TextView txtlogin;
    private EditText editUser, editEmail, editPass;
    private Button btnregis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getSupportActionBar().hide();

        txtlogin = findViewById(R.id.logintext);
        editUser = findViewById(R.id.user);
        editEmail = findViewById(R.id.email);
        editPass = findViewById(R.id.pass);
        btnregis = findViewById(R.id.btnregis);

        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(signup.this, login.class);
                startActivity(t);
            }
        });

        btnregis.setOnClickListener(view -> {
            if(editUser.getText().length()>0 && editEmail.getText().length()>0 && editPass.getText().length()>0){
                register(editUser.getText().toString(), editEmail.getText().toString(), editPass.getText().toString());
            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(signup.this);
                builder.setMessage("Silahkan Lengkapi Semua Data Anda").setNegativeButton("Retry", null).create().show();
            }
        });
    }

    public void  register (String username, String email, String pass){
        Toast.makeText(getApplicationContext(), "REGISTRASI BERHASIL", Toast.LENGTH_LONG).show();
        Intent i = new Intent(signup.this, nomor_telp.class);
        i.putExtra("email", editEmail.getText().toString());
        i.putExtra("password", editPass.getText().toString());
        i.putExtra("username", editUser.getText().toString());
        startActivity(i);

    }
}