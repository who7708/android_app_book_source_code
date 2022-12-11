package com.ansen.activityanimation;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;

import ansen.activityanimation.R;

/**
 * 爆炸效果
 * @author ansen
 * @create time 2018/2/24
 */
public class ExplodeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH) {//版本号大于4.4
            Transition explode = TransitionInflater.from(this).inflateTransition(R.transition.explode);
            getWindow().setEnterTransition(explode);//第一次进入时动画
        }

        setContentView(R.layout.activity_explode);

        findViewById(R.id.ll_root).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
