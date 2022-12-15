package com.ansen.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ansen.myapplication.base.BaseActivity;
import com.ansen.myapplication.databinding.ActivityMainBinding;

/**
 * @author Chris
 * @version 1.0
 * @since 2022-12-15
 */
public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());
        binding.btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent starter = new Intent(MainActivity.this, BottomNavActivity.class);
                starter.putExtra("aa", "aa");
                MainActivity.this.startActivity(starter);
            }
        });
    }
}
