package com.ansen.select;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView= (ImageView) findViewById(R.id.imageview);
        imageView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        //获取状态 取反  设置取反后的状态
        imageView.setSelected(!imageView.isSelected());
    }
}
