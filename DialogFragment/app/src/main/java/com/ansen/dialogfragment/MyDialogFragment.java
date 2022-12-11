package com.ansen.dialogfragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author ansen
 * @create time 2017-01-02
 */
public class MyDialogFragment extends DialogFragment {
    static MyDialogFragment newInstance() {
        return new MyDialogFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.hello_world, container, false);
        TextView tv = (TextView) v.findViewById(R.id.textview);
        tv.setText("This is an instance of MyDialogFragment");
        return v;
    }
}
