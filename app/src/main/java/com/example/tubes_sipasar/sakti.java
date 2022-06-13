package com.example.tubes_sipasar;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class sakti extends AppCompatActivity {

    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sakti);

        getSupportActionBar().hide();

        navigation = findViewById(R.id.bottomnav);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new belanjaFragment()).commit();
        navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectFragment = null;

                switch (item.getItemId()){
                    case R.id.home:
                        selectFragment = new belanjaFragment();
                        break;
                    case R.id.explore:
                        selectFragment = new exploreFragment();
                        break;
                    case R.id.keranjang:
                        selectFragment = new chartFragment();
                        break;
                    case R.id.profile:
                        selectFragment = new accountFragment();
                        break;
                    case R.id.favorite:
                        selectFragment = new FavFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectFragment).commit();
                return true;
            }
        });
    }
}