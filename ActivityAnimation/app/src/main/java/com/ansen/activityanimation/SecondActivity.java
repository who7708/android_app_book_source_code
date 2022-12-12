package com.ansen.activityanimation;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import ansen.activityanimation.R;

/**
 * @author ansen
 * @create time 2018/2/24
 */
public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        findViewById(R.id.ll_root).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
