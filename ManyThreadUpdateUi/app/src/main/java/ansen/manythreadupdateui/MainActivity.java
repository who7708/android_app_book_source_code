package ansen.manythreadupdateui;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvContent=findViewById(R.id.tv_content);

        findViewById(R.id.btn_runonui).setOnClickListener(onClickListener);
        findViewById(R.id.btn_viewpost).setOnClickListener(onClickListener);

        Log.i("MainActivity","主线程id:"+android.os.Process.myTid());
    }


    private View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_runonui:
                    activityRunOnUiThread();
                    break;
                case R.id.btn_viewpost:
                    viewPost();
                    break;
            }
        }
    };

    private void activityRunOnUiThread(){
        new Thread(){
            @Override
            public void run() {
                Log.i("MainActivity","子线程id:"+android.os.Process.myTid());
                //用activity的runOnUiThread方法更新ui 底层也是handler实现
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("MainActivity","主线程id:"+android.os.Process.myTid());
                        tvContent.setText("runOnUiThread更新ui");
                    }
                });
            }
        }.start();
    }

    public void viewPost(){
        new Thread(){
            @Override
            public void run() {
                tvContent.post(new Runnable() {
                    @Override
                    public void run() {
                        tvContent.setText("View Post方式");
                    }
                });
            }
        }.start();
    }
}
