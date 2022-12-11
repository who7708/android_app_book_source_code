package com.ansen.swiperefreshlayout;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ansen.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnRefreshListener{
    public static final int PULL_TO_REFRESH=1;//下拉刷新
    public static final int UP_TO_REFRESH=2;//上拉加载更多

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private List<String> datas;

    private boolean isLoadMore = false;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout= (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        //监听刷新状态
        swipeRefreshLayout.setOnRefreshListener(this);
        //设置下拉刷新的箭头颜色(可以设置多个颜色)
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent,
                android.R.color.holo_green_light,R.color.colorPrimary);

        initData();

        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//设置布局管理器
        recyclerView.setAdapter(adapter=new RecyclerViewAdapter(this,datas));
        recyclerView.addOnScrollListener(onScrollListener);
    }

    private RecyclerView.OnScrollListener onScrollListener=new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            RecyclerView.LayoutManager mLayoutManager = recyclerView.getLayoutManager();
            int lastVisibleItem = ((LinearLayoutManager) mLayoutManager).findLastVisibleItemPosition();
            int totalItemCount = mLayoutManager.getItemCount();
            //最后一项显示&&下滑状态的时候 加载更多
            if (lastVisibleItem >= totalItemCount-1 && dy > 0) {
                if(!isLoadMore){
                    loadMore();//加载更多
                    isLoadMore=true;
                }
            }
        }
    };

    @Override
    public void onRefresh() {
        //延迟3000毫秒,发送空消息跟handle，handle的handleMessage方法会接收到
        handler.sendEmptyMessageDelayed(PULL_TO_REFRESH,3000);
    }

    public void loadMore() {
        handler.sendEmptyMessageDelayed(UP_TO_REFRESH,1000);
    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case PULL_TO_REFRESH://下拉刷新
                    if(datas.size()>0){
                        datas.remove(0);//删除第一条
                        adapter.notifyDataSetChanged();//更新第一条记录
                        swipeRefreshLayout.setRefreshing(false);//false:刷新完成  true:正在刷新
                    }
                    break;
                case UP_TO_REFRESH://上拉加载更多
                    for(int i=0;i<3;i++){
                        datas.add("load more item:"+i);
                    }
                    adapter.notifyDataSetChanged();//更新列表
                    isLoadMore=false;//加载更多完成
                    break;
            }
        }
    };

    private void initData(){
        datas=new ArrayList<>();
        for(int i=0;i<15;i++){
            datas.add("item:"+i);
        }
    }
}
