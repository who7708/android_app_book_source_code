package com.ansen.popupwindow;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnShowPopupwindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowPopupwindow = (Button) findViewById(R.id.btn_show_popupwindow);
        btnShowPopupwindow.setOnClickListener(this);

        findViewById(R.id.btn_bottom_popupwindow).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_show_popupwindow){//点击第一个按钮
            showAsDropDown();
        }else if(v.getId()==R.id.btn_bottom_popupwindow){
            showBottomPopupwindow();
        }
    }

    private void showAsDropDown(){
        View popView = LayoutInflater.from(this).inflate(R.layout.popup_drop_down,null);
        //设置PopupWindow View,宽度，高度
        PopupWindow popupWindow=new PopupWindow(popView, LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        //设置允许在外点击消失,必须要给popupWindow设置背景才会有效
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //显示在btnShowPopupwindow按钮下面，x位置偏移100px 就是偏移屏幕左边100px
        popupWindow.showAsDropDown(btnShowPopupwindow,100,0);
    }

    private void showBottomPopupwindow(){
        View popView = LayoutInflater.from(this).inflate(R.layout.popup_bottom,null);

        final PopupWindow popupWindow=new PopupWindow(popView, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);// 设置允许在外点击消失
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x30000000));//设置背景颜色
        popupWindow.setAnimationStyle(R.style.Animation_Bottom_Dialog);//设置动画
        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.btn_camera_album){
                    Toast.makeText(MainActivity.this,"点击拍照按钮",Toast.LENGTH_SHORT).show();
                }else if(v.getId()==R.id.btn_camera_cancel){
                    Toast.makeText(MainActivity.this,"点击了取消按钮",Toast.LENGTH_SHORT).show();
                }
                popupWindow.dismiss();
            }
        };
        popView.findViewById(R.id.btn_camera_album).setOnClickListener(onClickListener);
        popView.findViewById(R.id.btn_camera_cancel).setOnClickListener(onClickListener);
        //参数1:根视图，整个Window界面的最顶层View  参数2:显示位置
        popupWindow.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM , 0, 0);
    }


}
