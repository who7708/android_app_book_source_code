package com.ansen.clipboardmanager;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etContent,etPasteContent;
    private ClipboardManager cmb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etContent= (EditText) findViewById(R.id.et_content);
        etPasteContent= (EditText) findViewById(R.id.et_paste_content);

        cmb = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        findViewById(R.id.btn_copy).setOnClickListener(this);
        findViewById(R.id.btn_paste).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_copy://复制
                String content=etContent.getText().toString().trim();
                if(TextUtils.isEmpty(content)){
                    Toast.makeText(this,"请输入要复制的内容",Toast.LENGTH_LONG).show();
                    return ;
                }

                cmb.setPrimaryClip(ClipData.newPlainText(null,content));
                Toast.makeText(this,"复制成功",Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_paste://粘贴
                etPasteContent.setText(cmb.getText().toString());
                break;
        }
    }
}
