package com.ansen.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup= (RadioGroup) findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    private OnCheckedChangeListener onCheckedChangeListener=new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId==R.id.rb_male){
                Toast.makeText(MainActivity.this,"您的性别是男",Toast.LENGTH_SHORT).show();
            }else if(checkedId==R.id.rb_girl){
                Toast.makeText(MainActivity.this,"您的性别是女",Toast.LENGTH_SHORT).show();
            }
        }
    };
}
