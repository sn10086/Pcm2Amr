package com.asia.pcm2amr;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        String rootPath = Environment.getExternalStorageDirectory().getPath();
        String amrPath = rootPath + "/test.amr";
        try {
            InputStream pcmStream = getAssets().open("test.pcm");
            AmrEncoder.pcm2Amr(pcmStream, amrPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        TextView hintView = (TextView) findViewById(R.id.hint);
        hintView.setText("转码成功!AMR在文件根目录下,名为:test.amr");
        ToastUtil.showShort(this, "转码成功!");
    }
}
