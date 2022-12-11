package com.ansen.linearlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        setContentView(R.layout.linearlayout_horizontal);//水平显示
//        setContentView(R.layout.linearlayout_vertical);//垂直
//        setContentView(R.layout.linearlayout_layout_gravity);//子View在linearlayout中显示位置
        setContentView(R.layout.linearlayout_weight);//权重显示
    }
}
