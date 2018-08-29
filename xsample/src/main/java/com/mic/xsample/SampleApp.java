package com.mic.xsample;

import android.app.Activity;
import android.os.Bundle;

import com.mic.libbusiness.utils.HookStartActivityUtil;
import com.mic.libcore.BaseApplication;
import com.mic.xsample.activity.ProxyActivity;

public class SampleApp extends BaseApplication{

    @Override
    public void onCreate() {
        super.onCreate();
        //hookActivity();
        //任何一个Activity 都会进来
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            }
            @Override
            public void onActivityStarted(Activity activity) {
            }

            @Override
            public void onActivityResumed(Activity activity) {
            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityStopped(Activity activity) {
            }
            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            }
            @Override
            public void onActivityDestroyed(Activity activity) {
            }
        });
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
