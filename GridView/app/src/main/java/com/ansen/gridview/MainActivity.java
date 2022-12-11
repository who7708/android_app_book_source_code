package com.ansen.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridView gridview;
    private List<Integer> images;
    private GridAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        gridview= (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(gridAdapter=new GridAdapter(this,images));

        //item设置点击事件
        gridview.setOnItemClickListener(onItemClickListener);
    }

    private AdapterView.OnItemClickListener onItemClickListener=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this,"当前选中了" +
                    ":"+position,Toast.LENGTH_SHORT).show();
        }
    };

    //初始化数据源
    private void initData(){
        images=new ArrayList<>();
        for(int i=0;i<100;i++){
            if(i%2==1){//对2取余数结果为1
                images.add(R.mipmap.test_one);
            }else{
                images.add(R.mipmap.test_two);
            }
        }
    }
}
