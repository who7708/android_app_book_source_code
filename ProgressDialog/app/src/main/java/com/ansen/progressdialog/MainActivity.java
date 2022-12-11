package com.ansen.progressdialog;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog staticDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //创建对象  调用Dialog的show方法显示
//        ProgressDialog dialog = new ProgressDialog(this);
//        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);//水平
//        dialog.incrementProgressBy(20);//设置进度值
//        dialog.setCanceledOnTouchOutside(false);// 设置在点击Dialog外是否取消Dialog进度条
//        dialog.show();//显示

        //调用ProgressDialog的静态方法显示 5秒后关闭。模拟访问网络过程
        findViewById(R.id.btn_show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                staticDialog = ProgressDialog.show(MainActivity.this,"这是标题","这是内容");
                /* 开启一个新线程，在新线程里执行耗时的方法 */
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);//延迟5秒
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        handler.sendEmptyMessage(0);//延迟5秒之后发送消给handler
                    }

                }).start();
            }
        });
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {// handler接收到消息后就会执行此方法
            staticDialog.dismiss();// 关闭ProgressDialog
        }
    };
}
