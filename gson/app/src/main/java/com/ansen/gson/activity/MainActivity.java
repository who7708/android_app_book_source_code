package com.ansen.gson.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ansen.gson.R;
import com.ansen.gson.entity.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parseObject();
        parseArrayList();
        parseMap();
        objectToJson();
    }

    private void parseObject(){
        String jsonStr="{ 'name':'Ansen', 'age':20}";
        User user=gson.fromJson(jsonStr, User.class);
        Log.i("MainActivity","parseObject user:"+user.toString());
    }

    private void parseArrayList(){
        String jsonStr="[{'name':'Uini', 'age':30},{'name':'Lina', 'age':10}]";
        List<User> users=gson.fromJson(jsonStr,new TypeToken<List<User>>() {}.getType());
        for(int i=0;i<users.size();i++){
            Log.i("MainActivity","parseArrayList user:"+users.get(i));
        }
    }

    private void parseMap(){
        String jsonStr="{'1': {'name':'haha', 'age':11},'2': {'name':'nihao', 'age':22}}";
        Map<String, User> users = gson.fromJson(jsonStr, new TypeToken<Map<String,User>>() {}.getType());
        for(String key:users.keySet()){
            Log.i("MainActivity","parseMap key:"+key+" user:"+users.get(key));
        }
    }

    private void  objectToJson(){
        User user=new User();
        user.setAge(111);
        user.setName("nime");
        String jsonStr=gson.toJson(user);
        Log.i("MainActivity","jsonStr:"+jsonStr);
    }
}
