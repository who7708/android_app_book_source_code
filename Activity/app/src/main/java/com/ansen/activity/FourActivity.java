package com.ansen.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;

/**
 * Created by  ansen
 * Create Time 2017-01-13
 */
public class FourActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        String value=getIntent().getStringExtra("parameter");
        Log.i("ansen",value);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //系统返回键
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            Intent intent = new Intent();
            intent.putExtra("result","FourActivityResultValue");//封装回传值
            setResult(RESULT_OK,intent);
            finish();//结束当前Activity
        }
        return super.onKeyDown(keyCode, event);
    }
}
