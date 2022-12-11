package com.ansen.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity{
    private SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //创建数据库
    public void createDb(View view){
        SQLiteHelper sqLiteHelper=new SQLiteHelper(this);
        sqLiteDatabase=sqLiteHelper.getReadableDatabase();
    }

    //往学生表添加数据
    public void addRecord(View view){
        ContentValues values = new ContentValues();
        //参数1:表的字段  参数2:字段对应的值
        values.put("id",1);
        values.put("name","test1");
        values.put("age",11);
        //参数1:表名  参数三:插入的数据
        sqLiteDatabase.insert("user",null,values);
        Log.i("MainActivity","往学生表添加一条数据");
    }

    /**
     * 更新数据
     * @param view
     */
    public void updateRecord(View view){
        Log.i("MainActivity","updateRecord");

        ContentValues contentValues = new ContentValues();
        contentValues.put("age", "88");
        //参数1:表名 参数2:修改的值 参数三:查询条件 参数4:查询条件需要的参数
        sqLiteDatabase.update("user", contentValues, "name=?", new String[]{"test1"});
    }

    //查找学生表数据
    public void findStudent(View view){
        Cursor cursor=sqLiteDatabase.query("user",new String[]{"id","name","age"},null,null,null,null,null);
        while (cursor.moveToNext()){//判断下一条有没有数据
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            int age = cursor.getInt(2);
            Log.i("MainActivity","id:"+id+" name:"+name+" age:"+age);
        }
        cursor.close();
    }

    //往学生表删除数据
    public void delete(View view){
        sqLiteDatabase.delete("user","name=?",new String[]{"test1"});

        Log.i("MainActivity","删除一条数据");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(sqLiteDatabase!=null){
            sqLiteDatabase.close();
            sqLiteDatabase=null;
        }
    }
}
