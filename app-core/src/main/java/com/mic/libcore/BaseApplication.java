package com.mic.libcore;

import android.app.Application;

import com.mic.libcore.common.ExceptionCrashHandler;

public class BaseApplication  extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ExceptionCrashHandler.getInstance().init(this);

    }
}
