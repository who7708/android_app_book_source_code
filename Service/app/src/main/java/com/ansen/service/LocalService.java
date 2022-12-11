package com.ansen.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by  ansen
 * Create Time 2017-01-18
 */
public class LocalService extends Service{
    private final IBinder mBinder = new LocalBinder();

    @Override
    public void onCreate() {
        Log.i("LocalService","onCreate ThreadId:"+android.os.Process.myTid());
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("LocalService","onStartCommand start id " + startId);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("LocalService","onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent){
        Log.i("LocalService","onBind");
        return mBinder;
    }

    //下载音乐的方法
    public void downMusic(){
        //这里我只是打印了一个Log 如果在开发中需要下载音乐，开一个线程去下载
        Log.i("LocalService","downMusic");
    }

    public class LocalBinder extends Binder{
        //返回当前的Service对象
        LocalService getService() {
            return LocalService.this;
        }
    }
}
