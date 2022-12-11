package com.ansen.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 广播接收器
 * Created by  ansen
 * Create Time 2017-02-03
 */
public class DynamicBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        String data = intent.getStringExtra("data");
        Log.i("data",data);
    }
}