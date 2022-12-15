package com.ansen.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ansen.myapplication.databinding.ActivityBottomNavBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BottomNavActivity extends AppCompatActivity {

    private static final String TAG = BottomNavActivity.class.getSimpleName();

    private ActivityBottomNavBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityBottomNavBinding.inflate(getLayoutInflater());
        // setContentView(R.layout.activity_bottom_nav);
        setContentView(mBinding.getRoot());
        // BottomNavigationView bottomNavView = mBinding.bottomNavView;
        // bottomNavView.setOnNavigationItemSelectedListener();
        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav_view);
        bottomNavView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d(TAG, "onNavigationItemSelected: " + item.getTitle());
                return true;
            }
        });
        bottomNavView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                Log.d(TAG, "onNavigationItemReselected: " + item.getTitle());
            }
        });
    }
}