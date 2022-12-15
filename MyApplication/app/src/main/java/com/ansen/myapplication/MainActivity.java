package com.ansen.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ansen.myapplication.databinding.ActivityMainBinding;
import com.ansen.myapplication.ui.BottomNavActivity;

public class MainActivity extends AppCompatActivity {

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
