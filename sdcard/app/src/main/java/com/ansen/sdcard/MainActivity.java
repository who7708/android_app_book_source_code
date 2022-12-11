package com.ansen.sdcard;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 获取sdcard路径
     * @param view
     */
    public void getSdcard(View view){
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {//判断有没有sdcard
            File sdCard = Environment.getExternalStorageDirectory();
            Log.i("MainActivity",sdCard.getPath());
        }
    }

    /**
     * 获取应用程序下的存储目录(应用卸载文件也会被删除)
     * @param view
     */
    public void getAppPath(View view){
        File getFilesDir =getFilesDir();
        Log.i("MainActivity",getFilesDir.getPath());
    }
}
