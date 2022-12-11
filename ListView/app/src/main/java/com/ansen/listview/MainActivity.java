package com.ansen.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private ListView listView;
    private ListViewAdapter adapter;
    private List<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        listView= (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter=new ListViewAdapter(this,items));

        View header=LayoutInflater.from(this).inflate(R.layout.activity_listview_header,null);
        header.setOnClickListener(onClickListener);//给头布局设置一个点击事件
        listView.addHeaderView(header);

        View footer=LayoutInflater.from(this).inflate(R.layout.activity_listview_footer,null);
        footer.setOnClickListener(onClickListener);//给头布局设置一个点击事件
        listView.addFooterView(footer);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"点击Item位置:"+position,Toast.LENGTH_SHORT).show();
            }
        });

        listView.setSelection(items.size()-1);//显示最后一条
    }

    private View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ll_header://点击头部
                    Toast.makeText(MainActivity.this,"点击ListView头布局",
                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.ll_footer://点击底部
                    items.add("点击底部添加的item");
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    };

    //初始化数据
    private void initData(){
        items=new ArrayList<>();
        for(int i=0;i<20;i++){
            items.add("item:"+(i+1));
        }
    }
}
