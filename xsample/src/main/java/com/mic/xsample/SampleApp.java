package com.mic.xsample;

import com.mic.libbusiness.utils.HookStartActivityUtil;
import com.mic.libcore.BaseApplication;
import com.mic.xsample.activity.ProxyActivity;

public class SampleApp extends BaseApplication{

    @Override
    public void onCreate() {
        super.onCreate();
        hookActivity();
    }


    private void hookActivity(){
        HookStartActivityUtil hookStartActivityUtil =
                new HookStartActivityUtil(this,ProxyActivity.class);
        try {
            hookStartActivityUtil.hookStartActivity();
            hookStartActivityUtil.hookLaunchActivity();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
