package com.ansen.layoutnesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout llRootView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //通过id查找LinearLayout
        llRootView= (LinearLayout) findViewById(R.id.ll_root_view);
        //给按钮设置点击事件
        findViewById(R.id.btn_add_view).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView textView=new TextView(this);
        textView.setText("动态添加View");
        llRootView.addView(textView);//通过addView方法动态添加控件
    }
}
