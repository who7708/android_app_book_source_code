package com.ansen.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private LocalService localService;//service对象
    private boolean mIsBound;//是否绑定

    ServiceConnection serviceConnection=new ServiceConnection() {
        //Activity跟Service绑定的时候回掉
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder){
            localService=((LocalService.LocalBinder)binder).getService();
            localService.downMusic();//调用下载音乐的方法
        }

        //Activity跟Service解绑时回掉
        @Override
        public void onServiceDisconnected(ComponentName name) {
            localService=null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("MainActivity","onCreate ThreadId:"+android.os.Process.myTid());

        findViewById(R.id.btn_start_service).setOnClickListener(this);
        findViewById(R.id.btn_stop_service).setOnClickListener(this);

        findViewById(R.id.btn_bind_service).setOnClickListener(this);
        findViewById(R.id.btn_unbind_service).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start_service://启动Service
                Intent startIntent=new Intent(this,LocalService.class);
                startService(startIntent);
                break;
            case R.id.btn_stop_service://停止Service
                Intent stopIntent=new Intent(this,LocalService.class);
                stopService(stopIntent);
                break;
            case R.id.btn_bind_service://绑定Service
                Intent bindIntent=new Intent(this,LocalService.class);
                bindService(bindIntent,serviceConnection,BIND_AUTO_CREATE);
                mIsBound = true;
                break;
            case R.id.btn_unbind_service://取消绑定Service
                unbindService();
                break;
        }
    }

    private void unbindService(){
        if(mIsBound){
            unbindService(serviceConnection);
            mIsBound=false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService();
    }
}
