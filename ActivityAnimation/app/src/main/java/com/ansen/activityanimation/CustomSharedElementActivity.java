package com.ansen.activityanimation;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ArcMotion;
import android.transition.ChangeBounds;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

import ansen.activityanimation.R;

/**
 * @author ansen
 * @create time 2018/2/26
 */
public class CustomSharedElementActivity extends AppCompatActivity {
    private ViewGroup container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_shared_element);
        container = (ViewGroup) findViewById(R.id.container);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH) {
            //定义ArcMotion
            ArcMotion arcMotion = new ArcMotion();
            arcMotion.setMinimumHorizontalAngle(50f);
            arcMotion.setMinimumVerticalAngle(50f);

            //插值器，控制速度
            Interpolator interpolator = AnimationUtils.loadInterpolator(this, android.R.interpolator.fast_out_slow_in);

            //ChangeBounds捕获共享元素的layout bound，然后播放layout bound变化动画
            ChangeBounds changeBounds = new ChangeBounds();

            changeBounds.setPathMotion(arcMotion);//设置运动路径，动画轨迹
            changeBounds.setInterpolator(interpolator);//插值器
            changeBounds.setDuration(300);//动画时长
            changeBounds.addTarget(container);

            //将切换动画应用到当前的Activity的进入和返回
            getWindow().setSharedElementEnterTransition(changeBounds);
            getWindow().setSharedElementReturnTransition(changeBounds);
        }
    }

    public void dismiss(View v) {
        finishAfterTransition();
    }
}
