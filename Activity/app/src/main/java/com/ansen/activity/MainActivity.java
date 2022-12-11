package com.ansen.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final int REQUEST_FOURACTIVITY_CODE=1;
    private String TAG="ansen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"onCreate");

        findViewById(R.id.btn_start_activity).setOnClickListener(this);
        findViewById(R.id.btn_start_three_activity).setOnClickListener(this);
        findViewById(R.id.btn_start_four_activity).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start_activity:
                Intent intent=new Intent(this,SecondActivity.class);
                //参数1:key  参数2:value
                intent.putExtra("parameter","SecondActivity parameter");
                startActivity(intent);
                break;
            case R.id.btn_start_three_activity:
                Intent threeIntent=new Intent("com.ansen.activity.ThreeActivity");
                startActivity(threeIntent);
                break;
            case R.id.btn_start_four_activity:
                Intent fourIntent=new Intent(this,FourActivity.class);
                fourIntent.putExtra("parameter","FourActivity parameter");
                startActivityForResult(fourIntent,REQUEST_FOURACTIVITY_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_FOURACTIVITY_CODE&&resultCode==RESULT_OK){
            String resultStr=data.getStringExtra("result");
            Log.i("ansen",resultStr);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
