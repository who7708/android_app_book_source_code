package com.ansen.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvResult;//用来显示结果

    private String javaResult="",phpResult="",cResult="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult= (TextView) findViewById(R.id.tv_result);

        //查找控件  并且设置选中改变监听
        CheckBox cbJava= (CheckBox) findViewById(R.id.cb_java);
        CheckBox cbPhp= (CheckBox) findViewById(R.id.cb_php);
        CheckBox cbC= (CheckBox) findViewById(R.id.cb_c);
        cbJava.setOnCheckedChangeListener(onCheckedChangeListener);
        cbPhp.setOnCheckedChangeListener(onCheckedChangeListener);
        cbC.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener=new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
            if(buttonView.getId()==R.id.cb_java){//通过id区分不同的复选框
                //如果java选中了 把"java"赋值给javaResult 否则""赋值给javaResul
                //这里用到了三元表达式  如果不会请先去学习java基础
                javaResult=isChecked?"Java":"";
            }else if(buttonView.getId()==R.id.cb_php){
                phpResult=isChecked?"Php":"";
            }else if(buttonView.getId()==R.id.cb_c){
                cResult=isChecked?"C":"";
            }
            //展示选中结果
            tvResult.setText(javaResult+" "+phpResult+" "+cResult);
        }
    };
}
