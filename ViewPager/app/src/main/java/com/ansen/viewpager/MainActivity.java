package com.ansen.viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager vPager = (ViewPager) findViewById(R.id.viewPager);
        vPager.setOffscreenPageLimit(2);//设置缓存页数
        vPager.setCurrentItem(0);//设置当前显示的item 0表示显示第一个

        FragmentAdapter pagerAdapter = new FragmentAdapter(getSupportFragmentManager());

        pagerAdapter.addFragment(new FragmentTest("页面1",android.R.color.holo_red_dark));
        pagerAdapter.addFragment(new FragmentTest("页面2",android.R.color.holo_green_dark));
        pagerAdapter.addFragment(new FragmentTest("页面3",android.R.color.holo_red_dark));
        pagerAdapter.addFragment(new FragmentTest("页面4",android.R.color.holo_green_dark));

        //给ViewPager设置适配器
        vPager.setAdapter(pagerAdapter);

        //页面改变监听
        vPager.addOnPageChangeListener(onPageChangeListener);
    }

    private ViewPager.OnPageChangeListener onPageChangeListener=new ViewPager.OnPageChangeListener() {
        //页面滑动
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

        //页面选择
        @Override
        public void onPageSelected(int position) {
            Log.i("MainActivity","选中了页面"+(position+1));
        }

        //页面滑动状态改变
        @Override
        public void onPageScrollStateChanged(int state) {}
    };
}
