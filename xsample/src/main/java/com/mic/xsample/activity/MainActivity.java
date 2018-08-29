package com.mic.xsample.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mic.libcore.activity.BaseActivity;
import com.mic.libcore.hotfix.FixDexManager;
import com.mic.xsample.R;
import com.mic.xsample.UserAidl;
import com.mic.xsample.service.MessageService;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@SuppressWarnings("unused")
public class MainActivity extends BaseActivity {


    UserAidl mUserAidl;
    @BindView(R.id.btn_bindService)
    Button btnBindService;
    @BindView(R.id.btn_showname)
    Button btnShowname;
    @BindView(R.id.btn_hook_activty)
    Button btnHookActivty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //startService(new Intent(this, MessageService.class));

        //测试全局异常捕获
        //int a = 20 / 1;

        //fixDexBug();
        //getResources();



    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void setContentView() {

    }

    @OnClick({R.id.btn_bindService, R.id.btn_showname})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_bindService:
                testAidl();
                break;
            case R.id.btn_showname:
                try {
                    Toast.makeText(this, mUserAidl.getUserName(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @OnClick(R.id.btn_hook_activty)
    public void onViewClicked() {
        Intent intent = new Intent(this,CustomViewActivity.class);
        startActivity(intent);
    }


    private class Conn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mUserAidl = UserAidl.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

        @Override
        public void onBindingDied(ComponentName name) {

        }
    }

    private void testAidl() {
//
        Intent intent = new Intent(this, MessageService.class);
        Conn conn = new Conn();
        bindService(intent, conn, Context.BIND_AUTO_CREATE);


    }


    private void testDb() {

    }


    private void fixDexBug() {
        File fixFile = new File(Environment.getExternalStorageDirectory(), "fix.dex");

        if (fixFile.exists()) {
            FixDexManager fixDexManager = new FixDexManager(this);

            try {
                fixDexManager.loadFixDex();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
