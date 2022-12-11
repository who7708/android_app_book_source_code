package com.ansen.progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar pbHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbHorizontal= (ProgressBar) findViewById(R.id.pb_horizontal);

        findViewById(R.id.btn_add).setOnClickListener(onClickListener);
        findViewById(R.id.btn_reduce).setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_add:
                    pbHorizontal.setProgress(pbHorizontal.getProgress()+10);
                    break;
                case R.id.btn_reduce:
                    pbHorizontal.setProgress(pbHorizontal.getProgress()-10);
                    break;
            }
        }
    };
}
