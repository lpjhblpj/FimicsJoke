package com.mic.xsample.activity;

import android.os.Bundle;
import android.os.Environment;

import com.mic.libcore.activity.BaseActivity;
import com.mic.libcore.hotfix.FixDexManager;
import com.mic.xsample.R;

import java.io.File;

@SuppressWarnings("unused")
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //测试全局异常捕获
        //int a = 20 / 1;

        //fixDexBug();


    }


    private void testDb(){

    }


    private void fixDexBug(){
        File fixFile = new File(Environment.getExternalStorageDirectory(),"fix.dex");

        if(fixFile.exists()){
            FixDexManager fixDexManager = new FixDexManager(this);

            try{
               fixDexManager.loadFixDex();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
