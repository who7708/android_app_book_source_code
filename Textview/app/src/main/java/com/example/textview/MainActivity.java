package com.example.textview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private TextView tv1,tv3,tv4,tv7,tv8;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv1=(TextView) findViewById(R.id.tv1);
		tv3=(TextView) findViewById(R.id.tv3);
		tv4=(TextView) findViewById(R.id.tv4);
		tv7=(TextView) findViewById(R.id.tv7);
		tv8=(TextView) findViewById(R.id.tv8);
		
		//如何在程序里面动态赋值  这里可以直接是字符串,也可以是字符串资源id
//		TextView tv0=(TextView) findViewById(R.id.tv0);
//		tv0.setText("如何在程序里面动态赋值");
		
		//实现多字符串的动态处理
		tv1.setText(getString(R.string.testing,new Object[]{11,21,31}));
		
		//TextVie显示html 字体颜色为红色  需要注意不支持html标签的style属性
		String html="<font color ='red'>TextVie显示html 字体颜色为红色</font><br/>";
		tv3.setText(Html.fromHtml(html));
		
		//给TextView设置点击事件,这个事件是父类View的,所以所有的android控件都有这个事件
		tv4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "点击了TextView4", Toast.LENGTH_LONG).show();
			}
		});
		
		
//		1. TextView的样式类Span的使用详解
		SpannableString spannableString = new SpannableString("TextView的样式类Span的使用详解") ;
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.RED);
        //0到10的字符设置红色背景
        spannableString.setSpan(backgroundColorSpan, 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv7.setText(spannableString); 
        
//      2.ClickableSpan: 点击事件相关的Span
//        注意：在使用ClickableSpan的时候，在单击链接时凡是有要执行的动作，都必须设置MovementMethod对象。
        SpannableString spannableClickString = new SpannableString("TextView设置点击事件Span") ;
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
            		Toast.makeText(MainActivity.this,"TextView设置点击事件Span", Toast.LENGTH_LONG).show();
            }
        };
        spannableClickString.setSpan(clickableSpan,11,15, Spannable.SPAN_EXCLUSIVE_INCLUSIVE) ;
        tv8.setMovementMethod(LinkMovementMethod.getInstance());
        tv8.setText(spannableClickString);
        
        //必须要给TextView加上点击事件点击之后才能改变背景颜色
        findViewById(R.id.tv9).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this,"点击了TextView9", Toast.LENGTH_LONG).show();
			}
		});
        
	}
}
