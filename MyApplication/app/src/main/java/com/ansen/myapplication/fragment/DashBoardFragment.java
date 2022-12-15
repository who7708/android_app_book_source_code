package com.ansen.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ansen.myapplication.R;
import com.ansen.myapplication.base.BaseFragment;

/**
 * @author Chris
 * @version 1.0
 * @since 2022-12-15
 */
public class DashBoardFragment extends BaseFragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        textView.setText(getString(R.string.menu_dashboard));
        return textView;
    }

    public static DashBoardFragment newInstance() {
        return new DashBoardFragment();
    }
}
