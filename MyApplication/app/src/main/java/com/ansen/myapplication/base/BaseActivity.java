package com.ansen.myapplication.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ansen.myapplication.util.ActivityController;

/**
 * @author Chris
 * @version 1.0
 * @since 1.0
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityController.addActivity(this);
        ActivityController.setCurrentActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityController.removeActivity(this);
    }
}
