package com.mic.joke;



import org.litepal.LitePalApplication;


public class JokeApp extends LitePalApplication {

    //public static PatchManager mPatchManager;

    @Override
    public void onCreate() {
        super.onCreate();

        // 设置全局异常捕捉类
        // ExceptionCrashHandler.getInstance().init(this);


    }
}
