package com.ansen.myapplication;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * @author Chris
 * @version 1.0.0
 * @date 2020/6/9
 */
public class MyApp extends Application {
    private static MyApp mInstance;

    public static MyApp getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化 AndroidUtilCode
        Utils.init(this);
        mInstance = this;
    }
}
