package com.example.tubes_sipasar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class belanjaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_belanja, container, false);
        Button tambah = (Button) view.findViewById(R.id.pisang);
        ImageView lokasi = (ImageView) view.findViewById(R.id.lokasi);
        lokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri page = Uri.parse("https://goo.gl/maps/hYRD6vbSKuUnYuit9");
                Intent intent = new Intent(Intent.ACTION_VIEW, page);
                startActivity(intent);
            }
        });
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView produk = (TextView) view.findViewById(R.id.namaproduk);
                Bundle bundle = new Bundle();
                bundle.putString("pisang", produk.getText().toString());
                getParentFragmentManager().setFragmentResult("dataproduk",bundle);
                produk.setText("");
//                chartFragment fragment  = new chartFragment();
//                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
//                fragment.setArguments(bundle);
//                getFragmentManager().beginTransaction().replace(R.id.fragment_belanja_container, fragment).commit();
            }
        });
        return view;
    }
}