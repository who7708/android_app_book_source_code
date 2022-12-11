package com.ansen.activitydestory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * @author ansen
 * @create time 2018/2/28
 */
public class BaseActivity extends AppCompatActivity {
    private MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (myApplication == null) {
            // 得到Application对象
            myApplication = (MyApplication) getApplication();
        }
        myApplication.addActivity(this);
    }

    //销毁所有Activity方法
    public void finishAllActivity() {
        myApplication.finishAllActivity();//调用myApplication销毁所有Activity方法
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        myApplication.removeActivity(this);
    }
}
