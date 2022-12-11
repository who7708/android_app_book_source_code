package com.ansen.activitydestory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * @author ansen
 * @create time 2018/2/28
 */
public class FirstActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_first);

        findViewById(R.id.btn_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAllActivity();
            }
        });
    }
}
