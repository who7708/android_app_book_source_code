package com.ansen.toast;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author ansen
 * @create time 2018/2/22
 */
public class CustomToast {
    private static CustomToast _instance = null;
    private Toast toast = null;

    private final int MARGIN_DP = 50;

    private CustomToast() {
    }

    public static CustomToast getInstance() {
        if (_instance == null) {
            _instance = new CustomToast();
        }
        return _instance;
    }

    public void cancel() {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
    }

    public void showToastCustom(Context ctx, String msg, int gravity) {
        showToastCustom(ctx, msg,R.layout.toast_msg, R.id.txt_toast_message, gravity);
    }

    /**
     * 显示自定义布局
     * @param ctx 上下文对象
     * @param msg 显示内容
     * @param layoutResId 布局文件资源id
     * @param txtResId 布局文件中TextView控件id
     * @param gravity 显示位置
     */
        public void showToastCustom(Context ctx, String msg, int layoutResId, int txtResId, int gravity) {
        cancel();//显示之前取消上次显示   这样每次都能显示最新的
        try {
            if (TextUtils.isEmpty(msg)) {
                return;
            }
            View layout = View.inflate(ctx, layoutResId, null);
            TextView txtMsg = layout.findViewById(txtResId);
            txtMsg.setText(msg);
            toast = new Toast(ctx);
            toast.setDuration(Toast.LENGTH_SHORT);
            if (gravity == Gravity.TOP) {
                int marginVertical = (int) dip2px(ctx, MARGIN_DP);
                toast.setGravity(gravity, 0,marginVertical);
            } else if (gravity == Gravity.BOTTOM) {
                int marginVertical = (int) dip2px(ctx, MARGIN_DP);
                toast.setGravity(gravity, 0,marginVertical);
            } else {
                toast.setGravity(gravity, 0, 0);
            }
            toast.setView(layout);
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * dp转px
     * @param context
     * @param dpValue
     * @return
     */
    public static float dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        float result = dpValue * scale + 0.5f;
        return result;
    }
}
