package com.ansen.privilegemanagement;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String[] perms = {Manifest.permission.CALL_PHONE};
    private final int PERMS_REQUEST_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_call_phone).setOnClickListener(this);
        findViewById(R.id.btn_special_permission).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_call_phone) {//获取拨打电话的权限
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {//Android 6.0以上版本需要获取权限
                requestPermissions(perms,PERMS_REQUEST_CODE);//请求权限
            } else {
                callPhone();
            }
        }else if (v.getId() == R.id.btn_special_permission) {//特殊权限
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1){
                if (Settings.canDrawOverlays(this)) {
                    systemAlert();
                } else {//没有系统弹窗权限,发送一个设置权限的intent
                    Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                    intent.setData(Uri.parse("package:" + getPackageName()));
                    startActivityForResult(intent, PERMS_REQUEST_CODE);
                }
            }
        }
    }

    /**
     * 获取权限回调方法
     * @param permsRequestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int permsRequestCode, String[] permissions, int[] grantResults) {
        switch (permsRequestCode) {
            case PERMS_REQUEST_CODE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {//用户同意
                    callPhone();
                } else {
                    Log.i("MainActivity", "没有权限操作这个请求");
                }
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PERMS_REQUEST_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { //Android M 处理Runtime Permission
                if (Settings.canDrawOverlays(this)){//有系统弹窗权限
                    Log.i("MainActivity","获取系统弹窗(特殊权限)成功");
                    systemAlert();
                } else {
                    Log.i("MainActivity","拒绝系统弹窗(特殊权限)");
                }
            }
        }
        super.onActivityResult(requestCode,resultCode,data);
    }


    //拨打电话
    private void callPhone() {
        //检查拨打电话权限
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + "10086"));
            startActivity(intent);
        }
    }

    //系统弹窗
    private void systemAlert(){
        Log.i("MainActivity", "系统弹窗");
    }
}
