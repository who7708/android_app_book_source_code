package com.ansen.jnitest;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JNITest jniTest=new JNITest();

        TextView tvResult= findViewById(R.id.tv_result);
        tvResult.setText("运行结果:"+jniTest.plus(100,10));
    }

    static {
        //libname就是我们在app/build.gradle中moduleName的值
        System.loadLibrary("mylib");
    }
}
