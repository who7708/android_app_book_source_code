package com.ansen.activityanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ansen.activityanimation.R;

/**
 * @author ansen
 * @create time 2018/2/24
 */
public class ThreeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        findViewById(R.id.ll_root).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
