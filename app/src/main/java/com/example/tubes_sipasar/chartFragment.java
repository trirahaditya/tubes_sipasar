package com.example.tubes_sipasar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link chartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class chartFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public chartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment chartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static chartFragment newInstance(String param1, String param2) {
        chartFragment fragment = new chartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart, container, false);
        TextView harga = (TextView) view.findViewById(R.id.hargabarang);
        TextView nama = (TextView) view.findViewById(R.id.produkkeranjang);
        TextView namabarang = (TextView) view.findViewById(R.id.namabarang);
        Button bayar = (Button) view.findViewById(R.id.btnbayar);
        bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(getActivity(), ReviewBarang.class);
                m.putExtra("namabarang", namabarang.getText().toString());
                m.putExtra("harga",harga.getText().toString());
                startActivity(m);
            }
        });
        getParentFragmentManager().setFragmentResultListener("dataproduk", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String data = result.getString("pisang");
                nama.setText(data);
            }
        });
//        Bundle bundle = this.getArguments();
//        String data = bundle.getString("pisang");
//        nama.setText(data);
        return view;
    }
}