package com.mic.joke;


import android.app.Application;

public class JokeApp extends Application {

    //public static PatchManager mPatchManager;

    @Override
    public void onCreate() {
        super.onCreate();

        // 设置全局异常捕捉类
        // ExceptionCrashHandler.getInstance().init(this);


    }
}
