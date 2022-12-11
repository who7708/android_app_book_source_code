package com.ansen.listviewchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.ansen.adapter.ListViewAdapter;
import com.ansen.entity.Message;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listview;
    private ListViewAdapter adapter;
    private List<Message> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        listview= (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter=new ListViewAdapter(this,messages));
    }

    private void init(){
        messages=new ArrayList<>();
        messages.add(new Message("为什么程序员到哪里都背着电脑包",false));
        messages.add(new Message("因为他们没有别的包包。",true));

        messages.add(new Message("程序员最烦两件事，第一件事是别人要他给自己的代码写文档，第二件呢？",false));
        messages.add(new Message("是别人的程序没有留下文档。",true));

        messages.add(new Message("如何生成一个随机的字符串？",false));
        messages.add(new Message("让新手退出VIM",true));
    }
}
