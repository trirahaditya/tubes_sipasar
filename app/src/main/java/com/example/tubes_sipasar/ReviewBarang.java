package com.example.tubes_sipasar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class ReviewBarang extends AppCompatActivity {

    private EditText edtnamapel, edtnamabar, edtjumlahbel, edtharga;
    private Button btnproses;
    private Button lanjutbayar;
    private TextView txtnamapel;
    private TextView txtnamabar;
    private TextView txtjumlahbel;
    private TextView txtharga;
    private TextView hargatotalbelanja;
    private TextView txttotalbelanja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_barang);

        edtnamapel = (EditText) findViewById(R.id.namapelanggan);
        edtnamabar = (EditText) findViewById(R.id.namabarang);
        edtjumlahbel = (EditText) findViewById(R.id.jumlahbeli);
        edtharga = (EditText) findViewById(R.id.harga);
        btnproses = (Button) findViewById(R.id.tombol1);
        lanjutbayar = (Button) findViewById(R.id.tombol3);
        txtnamapel = (TextView) findViewById(R.id.namapelanggan);
        txtnamabar = (TextView) findViewById(R.id.namabarang);
        txtjumlahbel = (TextView) findViewById(R.id.jumlahbeli);
        txtharga = (TextView) findViewById(R.id.harga);
        hargatotalbelanja = (TextView) findViewById(R.id.hargatotal);

        edtnamabar.setText(getIntent().getStringExtra("namabarang"));
        edtharga.setText(getIntent().getStringExtra("harga"));

        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namapelanggan = edtnamapel.getText().toString().trim();
                String namabarang = edtnamabar.getText().toString().trim();
                String jumlahbeli = edtjumlahbel.getText().toString().trim();
                String harga = edtharga.getText().toString().trim();


                double jb = Double.parseDouble(jumlahbeli);
                double h = Double.parseDouble(harga);
                double total = (jb * h);
                hargatotalbelanja.setText("Total Belanja : " + total);


            }
        });

        lanjutbayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        ReviewBarang.this, R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(
                        R.layout.activity_chart, (LinearLayout)findViewById(R.id.bottom_sheet_container)
                );
                bottomSheetView.findViewById(R.id.showbayar).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent berhasil = new Intent(ReviewBarang.this, order_berhasil.class);
                        berhasil.putExtra("totalbelanja", hargatotalbelanja.getText().toString());
                        startActivity(berhasil);
                    }
                });
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
//                Intent bayar = new Intent(ReviewBarang.this, chartActivity.class);
//                startActivity(bayar);
            }
        });
    }
}