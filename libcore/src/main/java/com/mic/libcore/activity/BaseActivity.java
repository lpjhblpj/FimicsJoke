package com.mic.libcore.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mic.libcore.R;


@SuppressWarnings("unused")
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * 启动Activity
     * @param activity  目标activity
     */
    public void startActivity(Class<? extends Activity> activity){
        Intent intent = new Intent(this,activity);
        this.startActivity(activity);
    }




}
