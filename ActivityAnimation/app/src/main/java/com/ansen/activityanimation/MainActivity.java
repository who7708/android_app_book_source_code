package com.ansen.activityanimation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import ansen.activityanimation.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_two).setOnClickListener(onClickListener);
        findViewById(R.id.btn_three).setOnClickListener(onClickListener);

        findViewById(R.id.btn_explode).setOnClickListener(onClickListener);
        findViewById(R.id.btn_slide).setOnClickListener(onClickListener);
        findViewById(R.id.btn_fade).setOnClickListener(onClickListener);

        findViewById(R.id.btn_shared_element).setOnClickListener(onClickListener);
        findViewById(R.id.btn_custom_shared_element).setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_two:
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                    //SecondActivity从屏幕左边滑动进来  使用自带的动画xml
                    overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

                    //实现淡入浅出的效果
//                  overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                    break;
                case R.id.btn_three:
                    //实现zoommin 和 zoomout,即类似iphone的进入和退出时的效果
                    intent = new Intent(MainActivity.this, ThreeActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoomin,R.anim.zoomout);
                    break;
                case R.id.btn_explode://爆炸效果
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        Toast.makeText(MainActivity.this,"手机操作系统版本过低",Toast.LENGTH_SHORT).show();
                        return ;
                    }
                    intent = new Intent(MainActivity.this,ExplodeActivity.class);
                    startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
                    break;
                case R.id.btn_slide://滑动
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        Toast.makeText(MainActivity.this,"手机操作系统版本过低",Toast.LENGTH_SHORT).show();
                        return ;
                    }
                    intent = new Intent(MainActivity.this, SlideActivity.class);
                    startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
                    break;
                case R.id.btn_fade://淡出
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        Toast.makeText(MainActivity.this,"手机操作系统版本过低",Toast.LENGTH_SHORT).show();
                        return ;
                    }
                    intent = new Intent(MainActivity.this, FadeActivity.class);
                    startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
                    break;
                case R.id.btn_shared_element://Shared Element（共享元素）效果
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        Toast.makeText(MainActivity.this,"手机操作系统版本过低",Toast.LENGTH_SHORT).show();
                        return ;
                    }

                    intent = new Intent(MainActivity.this, SharedElementActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_custom_shared_element://自定义Shared Element（共享元素）效果
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                        Toast.makeText(MainActivity.this,"手机操作系统版本过低",Toast.LENGTH_SHORT).show();
                        return ;
                    }

                    intent = new Intent(MainActivity.this, CustomSharedElementActivity.class);
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation
                            (MainActivity.this, v, "transition_morph_view");
                    startActivity(intent, options.toBundle());
                    break;
            }
        }
    };

}
