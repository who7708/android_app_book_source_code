package com.ansen.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author ansen
 * @create time 2017-01-19
 */
public class FragmentOne extends Fragment{
    private View rootView;
    private View.OnClickListener onClickListener;

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("FragmentOne","onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        Log.i("FragmentOne","onCreateView");
        rootView=inflater.inflate(R.layout.fragment_one,null);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("FragmentOne","onActivityCreated");
        if(onClickListener!=null){
            rootView.setOnClickListener(onClickListener);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("FragmentOne","onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("FragmentOne","onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("FragmentOne","onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("FragmentOne","onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("FragmentOne","onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Fragment1","onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("FragmentOne","onDetach");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("FragmentOne","onAttach");
    }
}
