package com.ansen.myapplication.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ansen.myapplication.R;
import com.ansen.myapplication.databinding.ActivityBottomNavBinding;
import com.google.android.material.badge.BadgeDrawable;
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
                BadgeDrawable badge = bottomNavView.getOrCreateBadge(item.getItemId());
                badge.setNumber(100);
                Log.d(TAG, "onNavigationItemSelected: " + item.getTitle());
                // 选择是否生效
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