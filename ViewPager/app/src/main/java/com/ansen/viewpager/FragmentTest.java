package com.ansen.viewpager;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by  ansen
 * Create Time 2017-04-11
 */
@SuppressLint("ValidFragment")
public class FragmentTest extends Fragment {
    private String content;
    private int backgroundResourceId;

    public FragmentTest(String content,int backgroundResourceId){
        this.content=content;
        this.backgroundResourceId=backgroundResourceId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_test, null);
        TextView tvContent= (TextView) rootView.findViewById(R.id.tv_content);
        tvContent.setText(content);

        rootView.setBackgroundResource(backgroundResourceId);
        return rootView;
    }
}
