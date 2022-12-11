package com.ansen.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void contextPut(View view){
        SharedPreferences sp=getApplicationContext().getSharedPreferences("filename", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit=sp.edit();
        edit.putString("username","ansen");
        edit.commit();
    }

    public void contextGet(View view){
        SharedPreferences sp=getApplicationContext().getSharedPreferences("filename", Context.MODE_PRIVATE);
        String username=sp.getString("username","");
        Log.i("MainActivity","username:"+username);
    }
}
