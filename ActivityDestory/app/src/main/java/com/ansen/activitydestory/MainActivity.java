package com.ansen.activitydestory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_finish).setOnClickListener(this);
        findViewById(R.id.btn_exit).setOnClickListener(this);
        findViewById(R.id.btn_kill_process).setOnClickListener(this);

        findViewById(R.id.btn_start_first).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_finish){
            finish();
        }else if(v.getId()==R.id.btn_exit) {//
            System.exit(0);//使用系统的方法，强制退出，终止程序
        }else if(v.getId()==R.id.btn_kill_process){
            android.os.Process.killProcess(android.os.Process.myPid());//直接杀死当前进程
        }else if(v.getId()==R.id.btn_start_first){
            Intent intent=new Intent(MainActivity.this,FirstActivity.class);
            startActivity(intent);
        }
    }
}
