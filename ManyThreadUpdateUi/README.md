既然有子线程，那就肯定需要更新UI，在Android中子线程更新UI的方法有以下四种:
- 用Activity对象的runOnUiThread方法更新
- View.post(Runnable r) 
- AsyncTask
- Handler

其实底层原理都是Handler实现。AsyncTask跟Handler放到后面单独讲。

### Activity对象的runOnUiThread方法更新
tvContent是界面上的一个TextView，开启一个线程，想要在线程中更新TextView的值，调用activity的runOnUiThread方法，需要传入一个Runnable对象，在Runnable对象的run方法中去更新ui。
```
new Thread(){
    @Override
    public void run() {
        //用activity的runOnUiThread方法更新ui 底层也是handler实现
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
              tvContent.setText("runOnUiThread更新ui");
            }
        });

    }
}.start();
```

### View.post
同样开启一个线程，在子线程中调用我们要更新的TextView控件的post方法，同样传入一个Runnable对象，在Runnable对象的run方法中更新TextView的字符串。
```
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
```

这四种方法都能在子线程中更新UI，大家根据自己的需求来决定哪种方式。
