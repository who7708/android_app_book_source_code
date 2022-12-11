package com.ansen.dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;

/**
 * @author ansen
 * @create time 2017-01-02
 */
public class MyAlertDialogFragment extends DialogFragment{
    private DialogInterface.OnClickListener onClickListener;

    public static MyAlertDialogFragment newInstance() {
        return new MyAlertDialogFragment();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity())
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(R.string.app_name);
        if(onClickListener!=null){//设置对话框ok&&取消按钮的点击事件
            builder.setPositiveButton(R.string.alert_dialog_ok,onClickListener);
            builder.setNegativeButton(R.string.alert_dialog_cancel,onClickListener);
        }
        return builder.create();
    }

    public void setOnClickListener(DialogInterface.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}