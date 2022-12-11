package com.ansen.dialogfragment;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_my_dialog).setOnClickListener(this);
        findViewById(R.id.btn_dialogfragment).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_dialogfragment){//对话框
            MyAlertDialogFragment myAlertDialogFragment=MyAlertDialogFragment.newInstance();
            myAlertDialogFragment.setOnClickListener(onClickListener);
            myAlertDialogFragment.show(getSupportFragmentManager(),"MyAlertDialogFragment");
        }else if(v.getId()==R.id.btn_my_dialog){
            MyDialogFragment.newInstance().show(getSupportFragmentManager(),"MyDialogFragment");
        }
    }

    private DialogInterface.OnClickListener onClickListener=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE://ok
                    Log.i("ansen","ok");
                    break;
                case DialogInterface.BUTTON_NEGATIVE://cancel
                    Log.i("ansen","cancel");
                    break;
            }
        }
    };
}
