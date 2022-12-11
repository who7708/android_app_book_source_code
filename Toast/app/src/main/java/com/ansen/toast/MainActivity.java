package com.ansen.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_toast).setOnClickListener(this);
        findViewById(R.id.btn_toast_two).setOnClickListener(this);
        findViewById(R.id.btn_toast_three).setOnClickListener(this);
        findViewById(R.id.btn_toast_four).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_toast:
                Toast.makeText(this,"提示",Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_toast_two:
                CustomToast.getInstance().showToastCustom(MainActivity.this,"显示顶部",Gravity.TOP);
                break;
            case R.id.btn_toast_three:
                CustomToast.getInstance().showToastCustom(MainActivity.this,"显示中间",Gravity.CENTER);
                break;
            case R.id.btn_toast_four:
                CustomToast.getInstance().showToastCustom(MainActivity.this,"显示底部",Gravity.BOTTOM);
                break;
        }
    }
}
