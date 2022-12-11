package com.ansen.fileprovider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private final String Tag = MainActivity.class.getSimpleName();
    private String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private final int PERMS_REQUEST_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv_install).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.LOLLIPOP_MR1&&
                PackageManager.PERMISSION_GRANTED!=checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)){//Android 6.0以上版本需要获取临时权限
            requestPermissions(perms,PERMS_REQUEST_CODE);
        }else{
            String filePath=copyFile();//首先把assets下的apk文件复制到sdcard上
            openAPK(filePath);
        }
    }

    /**
     * 安装apk
     * @param fileSavePath
     */
    private void openAPK(String fileSavePath){
        File file=new File(fileSavePath);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri data;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {//判断版本大于等于7.0
            // "com.ansen.fileprovider.fileprovider"即是在清单文件中配置的authorities
            // 通过FileProvider创建一个content类型的Uri
            data = FileProvider.getUriForFile(this, "com.ansen.fileprovider.fileprovider", file);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);// 给目标应用一个临时授权
        } else {
            data = Uri.fromFile(file);
        }
        intent.setDataAndType(data, "application/vnd.android.package-archive");
        startActivity(intent);
    }

    /**
     * 如果sdcard没有文件就复制过去
     */
    private String copyFile() {
        AssetManager assetManager = this.getAssets();
        String newFilePath = Environment.getExternalStorageDirectory()+"/Download/FileProvider.apk";
        try {
            File file=new File(newFilePath);
            if(!file.exists()){//文件不存在才复制
                InputStream in = assetManager.open("FileProvider.apk");
                OutputStream out = new FileOutputStream(newFilePath);
                byte[] buffer = new byte[1024];
                int read;
                while ((read = in.read(buffer)) != -1) {
                    out.write(buffer, 0, read);
                }
                in.close();
                out.flush();
                out.close();
            }

        } catch (Exception e) {
            Log.i("ansne","错误");
            Log.e(Tag,e.getMessage());
        }
        return newFilePath;
    }

    @Override
    public void onRequestPermissionsResult(int permsRequestCode, String[] permissions, int[] grantResults){
        switch(permsRequestCode){
            case PERMS_REQUEST_CODE:
                boolean storageAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                if(storageAccepted){
                    String filePath=copyFile();//首先把assets下的apk文件复制到sdcard上
                    openAPK(filePath);
                }
                break;
        }
    }
}
