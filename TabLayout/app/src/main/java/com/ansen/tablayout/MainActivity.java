package com.ansen.tablayout;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.ansen.tablayout.fragment.FragmentTest;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //设置标题内容以及标题文字颜色
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("关注公众号[Android开发者666]");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        ViewPager vPager = (ViewPager) findViewById(R.id.viewPager);
        vPager.setOffscreenPageLimit(2);//设置缓存页数
        vPager.setCurrentItem(0);//设置当前显示的item 0表示显示第一个

        FragmentAdapter pagerAdapter = new FragmentAdapter(getSupportFragmentManager());
        FragmentTest fragmentOne=new FragmentTest();
        FragmentTest fragmentTwo=new FragmentTest();
        FragmentTest fragmentThree=new FragmentTest();

        //把Fragment一个个的添加到适配器中 参数2是选项卡的标题
        pagerAdapter.addFragment(fragmentOne,"选项卡1");//
        pagerAdapter.addFragment(fragmentTwo,"选项卡2");
        pagerAdapter.addFragment(fragmentThree,"选项卡3");

        //给ViewPager设置适配器
        vPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        //通过TabLayout的setupWithViewPager把ViewPager设置进去
        tabLayout.setupWithViewPager(vPager);

        FloatingActionButton fab= (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Snackbar.make(view, "这是内容", Snackbar.LENGTH_SHORT).setAction
                ("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "cancel",Toast.LENGTH_SHORT).show();
                    }
         }).show();
    }
}
