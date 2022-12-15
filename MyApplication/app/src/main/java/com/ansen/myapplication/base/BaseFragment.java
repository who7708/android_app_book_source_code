package com.ansen.myapplication.base;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author Chris
 * @version 1.0
 * @since 2022-12-15
 */
public class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("A_And_F", "onCreate: " + this.getClass().getSimpleName());
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            Log.d("A_And_F", "onHiddenChanged: " + this.getClass().getSimpleName());
        }
    }

}
