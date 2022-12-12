package com.ansen.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by  ansen
 * Create Time 2017-01-06
 */
public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String value=getIntent().getStringExtra("parameter");
        Log.i("ansen",value);
    }
}
