package com.ansen.bitmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //用java代码给imageview设置xml bitmap
        ImageView imageView=findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.bitmap);
    }
}
