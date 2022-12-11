package com.ansen.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new DownloadFilesTask().execute("www.downloadfile.com");
    }

    private class DownloadFilesTask extends AsyncTask<String,Integer,Long> {
        @Override
        protected void onPreExecute() {
            Log.i("DownloadFilesTask","执行任务之前");
        }

        protected Long doInBackground(String... url) {
            int count = url[0].length();//第一个字符串
            long totalSize = 0;
            for (int i = 0; i < count; i++) {
                totalSize += i;
                publishProgress(i);//此方法执行  会调用onProgressUpdate方法更新下载进度
                // 如果取消就结束任务
                if (isCancelled()) break;
            }
            return totalSize;
        }

        protected void onProgressUpdate(Integer... progress){
            Log.i("DownloadFilesTask","当前下载进度:"+progress[0].intValue());
        }

        protected void onPostExecute(Long result) {
            Log.i("DownloadFilesTask","下载完成:"+result);
        }
    }
}
