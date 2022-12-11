package com.ansen.fragment;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private FragmentContainer fragmentOne;
    private FragmentContainer fragmentTwo;
    private FragmentContainer fragmentThree;

    private FragmentOne staticFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        staticFragment= (FragmentOne) getSupportFragmentManager().findFragmentById(R.id.fragment_one);
        staticFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MainActivity","动态加载的Fragment被点击了");
            }
        });

        fragmentOne=new FragmentContainer(1);
        fragmentTwo=new FragmentContainer(2);
        fragmentThree=new FragmentContainer(3);

        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_remove).setOnClickListener(this);
        findViewById(R.id.btn_replace).setOnClickListener(this);
        findViewById(R.id.btn_hide).setOnClickListener(this);
        findViewById(R.id.btn_show).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //开启一个Fragment事务
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(v.getId()==R.id.btn_add){//添加2个Fragment
            transaction.add(R.id.fl_container,fragmentOne);
            transaction.add(R.id.fl_container,fragmentTwo);
        }else if(v.getId()==R.id.btn_remove){//删除
            transaction.remove(fragmentTwo);
        }else if(v.getId()==R.id.btn_replace){//替换
            transaction.replace(R.id.fl_container,fragmentThree);
        }else if(v.getId()==R.id.btn_hide){//隐藏
            transaction.hide(fragmentThree);
        }else if(v.getId()==R.id.btn_show){//显示
            transaction.show(fragmentThree);
        }
        //提交事物
        transaction.commit();
    }
}
