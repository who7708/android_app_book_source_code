package com.ansen.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by  ansen
 * Create Time 2017-02-04
 */
public class StaticBroadcast extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent){
        String data = intent.getStringExtra("data");
        Log.i("data",data);
    }
}
