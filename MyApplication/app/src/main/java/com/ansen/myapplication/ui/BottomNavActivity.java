package com.ansen.myapplication.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.ansen.myapplication.R;
import com.ansen.myapplication.databinding.ActivityBottomNavBinding;
import com.ansen.myapplication.fragment.DashBoardFragment;
import com.ansen.myapplication.fragment.HomeFragment;
import com.ansen.myapplication.fragment.NotificationFragment;
import com.ansen.myapplication.fragment.PersonalFragment;
import com.ansen.myapplication.util.ActivityUtils;
import com.ansen.myapplication.util.BottomNavigationViewHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris
 * @version 1.0
 * @since 2022-12-15
 */
public class BottomNavActivity extends AppCompatActivity {

    private static final String TAG = BottomNavActivity.class.getSimpleName();

    /**
     * menu中所有的fragment
     */
    private List<Fragment> mFragmentList;

    /**
     * 当前fragment
     */
    private Fragment mCurrentFragment;

    /**
     * menuItem 选中事件
     */
    private final BottomNavigationView.OnItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int itemId = item.getItemId();
            if (itemId == R.id.menu_item_home) {
                switchFragment(mCurrentFragment, mFragmentList.get(0), item.getTitle());
                return true;
            } else if (itemId == R.id.menu_item_dashboard) {
                switchFragment(mCurrentFragment, mFragmentList.get(1), item.getTitle());
                return true;
            } else if (itemId == R.id.menu_item_notifications) {
                switchFragment(mCurrentFragment, mFragmentList.get(2), item.getTitle());
                return true;
            } else if (itemId == R.id.menu_item_person) {
                switchFragment(mCurrentFragment, mFragmentList.get(3), item.getTitle());
                return true;
            }
            return false;
        }

    };

    public void switchFragment(Fragment from, Fragment to, CharSequence title) {
        Log.d(TAG, "switchFragment: " + title);
        if (mCurrentFragment != to) {
            mCurrentFragment = to;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            // mToolbar.setTitle(title);
            if (!to.isAdded()) {
                transaction.hide(from).add(R.id.fragment, to).commit();
            } else {
                transaction.hide(from).show(to).commit();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBottomNavBinding mBinding = ActivityBottomNavBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // 添加所有的fragment
        mFragmentList = new ArrayList<>();
        mFragmentList.add(HomeFragment.newInstance());
        mFragmentList.add(DashBoardFragment.newInstance());
        mFragmentList.add(NotificationFragment.newInstance());
        mFragmentList.add(PersonalFragment.newInstance());

        // 默认进行的fragment
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mFragmentList.get(0), R.id.fragment);
        mCurrentFragment = mFragmentList.get(0);

        // 底部导航
        BottomNavigationView bottomNavView = mBinding.bottomNavView;
        BottomNavigationViewHelper.disableShiftMode(bottomNavView);
        bottomNavView.setOnItemSelectedListener(mOnNavigationItemSelectedListener);
        // bottomNavView.setOnItemReselectedListener(mOnNavigationItemSelectedListener);
    }

}