package com.ansen.threadpoolexecutor;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_thread_pool_executor).setOnClickListener(this);
        findViewById(R.id.btn_new_cached_thread_pool).setOnClickListener(this);
        findViewById(R.id.btn_new_fixed_thread_pool).setOnClickListener(this);
        findViewById(R.id.btn_new_single_thread_executor).setOnClickListener(this);
        findViewById(R.id.btn_scheduled_thread_pool_executor).setOnClickListener(this);

    }

    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
        //可以在并发情况下达到原子化更新，避免使用了synchronized，而且性能非常高
        private final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable r) {
            return new Thread(r,"ThreadPoolExecutor new Thread #" + mCount.getAndIncrement());
        }
    };

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_thread_pool_executor){
            MyRejectedExecutionHandler handler=new MyRejectedExecutionHandler();

            //会启动非核心线程
//            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
//                    2, 5, 30, TimeUnit.SECONDS,
//                    new LinkedBlockingQueue<Runnable>(6), sThreadFactory,handler);


            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                    2, 5, 30, TimeUnit.SECONDS,
                    new LinkedBlockingQueue<Runnable>(128), sThreadFactory,handler);

            //拒绝任务
//            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
//                    2, 3, 30, TimeUnit.SECONDS,
//                    new LinkedBlockingQueue<Runnable>(6), sThreadFactory,handler);

            for(int i=0;i<10;i++){
                final int iValue=i;
                Runnable runnable=new Runnable(){
                    @Override
                    public void run(){
                        SystemClock.sleep(1000);
                        Log.i("ansen","当前线程id:"+android.os.Process.myTid()+" iValue:"+iValue);
                    }
                };
                threadPoolExecutor.execute(runnable);
            }
        }else if(v.getId()==R.id.btn_new_cached_thread_pool){
            ExecutorService executorService=Executors.newCachedThreadPool();
            for(int i=0;i<5;i++){
                final int iValue=i;
                Runnable runnable=new Runnable(){
                    @Override
                    public void run(){
                        SystemClock.sleep(1000);
                        Log.i("ansen","当前线程id:"+android.os.Process.myTid()+" iValue:"+iValue);
                    }
                };
                executorService.execute(runnable);
            }
        }else if(v.getId()==R.id.btn_new_fixed_thread_pool){
            ExecutorService executorService=Executors.newFixedThreadPool(5);
            for(int i=0;i<10;i++){
                final int iValue=i;
                Runnable runnable=new Runnable(){
                    @Override
                    public void run(){
                        SystemClock.sleep(1000);
                        Log.i("ansen","当前线程id:"+android.os.Process.myTid()+" iValue:"+iValue);
                    }
                };
                executorService.execute(runnable);
            }
        }else if(v.getId()==R.id.btn_new_single_thread_executor){
            ExecutorService executorService=Executors.newSingleThreadExecutor();
            for(int i=0;i<10;i++){
                final int iValue=i;
                Runnable runnable=new Runnable(){
                    @Override
                    public void run(){
                        SystemClock.sleep(1000);
                        Log.i("ansen","当前线程id:"+android.os.Process.myTid()+" iValue:"+iValue);
                    }
                };
                executorService.execute(runnable);
            }
        }else if(v.getId()==R.id.btn_scheduled_thread_pool_executor){//
            ScheduledThreadPoolExecutor executorService=new ScheduledThreadPoolExecutor(1);

            Runnable runnable=new Runnable() {
                @Override
                public void run() {
                    Log.i("ansen", "ScheduledThreadPoolExecutor 任务执行完成");
                }
            };
            Log.i("ansen", "ScheduledThreadPoolExecutor 任务开始完成");
            executorService.schedule(runnable,5,TimeUnit.SECONDS);
        }
    }

    public static class MyRejectedExecutionHandler implements RejectedExecutionHandler {
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            throw new RejectedExecutionException("任务被拒绝");
        }
    }
}
