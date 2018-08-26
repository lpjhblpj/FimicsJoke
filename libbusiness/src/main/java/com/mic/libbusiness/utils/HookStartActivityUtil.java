package com.mic.libbusiness.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description: Hook activity 启动流程
 */

@SuppressWarnings("unused")
public class HookStartActivityUtil {


    private String TAG = "HookStartActivityUtil";
    private Context mContext;
    private Class<?> mProxyClass;
    private final String EXTRA_ORIGIN_INTENT = "EXTRA_ORIGIN_INTENT";

    public HookStartActivityUtil(Context context,Class<?> proxyClass){
        this.mContext = context.getApplicationContext();
        this.mProxyClass = proxyClass;
    }

    public void hookLaunchActivity() throws Exception{
        // 3.4.1 获取ActivityThread实例
        Class<?> atClass = Class.forName("android.app.ActivityThread");
        Field scatField = atClass.getDeclaredField("sCurrentActivityThread");
        scatField.setAccessible(true);
        Object sCurrentActivityThread = scatField.get(null);
        // 3.4.2 获取ActivityThread中的mH
        Field mhField = atClass.getDeclaredField("mH");
        mhField.setAccessible(true);
        Object mHandler = mhField.get(sCurrentActivityThread);
        // 3.4.3 hook  handleLaunchActivity
        // 给Handler设置CallBack回掉,也只能通过发射
        Class<?> handlerClass = Class.forName("android.os.Handler");
        Field mCallbackField = handlerClass.getDeclaredField("mCallback");
        mCallbackField.setAccessible(true);
        mCallbackField.set(mHandler,new HandlerCallBack());
    }

    private class HandlerCallBack implements Handler.Callback{

        @Override
        public boolean handleMessage(Message msg) {
            Log.e(TAG,"handleMessage");
            // 每发一个消息都会走一次这个CallBack发放
            if(msg.what == 100){
                handleLaunchActivity(msg);
            }
            return false;
        }

        /**
         * 开始启动创建Activity拦截
         * @param msg
         */
        private void handleLaunchActivity(Message msg) {
            try {
                Object record = msg.obj;
                // 1.从record 获取过安检的Intent
                Field intentField = record.getClass().getDeclaredField("intent");
                intentField.setAccessible(true);
                Intent safeIntent = (Intent) intentField.get(record);
                // 2.从safeIntent中获取原来的originIntent
                Intent originIntent = safeIntent.getParcelableExtra(EXTRA_ORIGIN_INTENT);
                // 3.重新设置回去
                if(originIntent != null){
                    intentField.set(record,originIntent);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void hookStartActivity() throws Exception{

        // 3.1 获取ActivityManagerNative里面的gDefault
        Class<?> amnClass = Class.forName("android.app.ActivityManagerNative");
        // 获取属性
        Field gDefaultField = amnClass.getDeclaredField("gDefault");
        // 设置权限
        gDefaultField.setAccessible(true);
        Object gDefault = gDefaultField.get(null);

        // 3.2 获取gDefault中的mInstance属性
        Class<?> singletonClass = Class.forName("android.util.Singleton");
        Field mInstanceField = singletonClass.getDeclaredField("mInstance");
        mInstanceField.setAccessible(true);
        Object iamInstance = mInstanceField.get(gDefault);

        Class<?> iamClass = Class.forName("android.app.IActivityManager");
        iamInstance = Proxy.newProxyInstance(HookStartActivityUtil.class.getClassLoader(),
                new Class[]{iamClass},
                // InvocationHandler 必须执行者，谁去执行
                new StartActivityInvocationHandler(iamInstance));

        // 3.重新指定
        mInstanceField.set(gDefault,iamInstance);
    }


    private class StartActivityInvocationHandler implements InvocationHandler {
        // 方法执行者
        private Object mObject;
        public StartActivityInvocationHandler(Object object){
            this.mObject = object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Log.e(TAG,method.getName());
            // 替换Intent,过AndroidManifest.xml检测
            if(method.getName().equals("startActivity")){
                // 1.首先获取原来的Intent
                Intent originIntent = (Intent) args[2];

                // 2.创建一个安全的
                Intent safeIntent = new Intent(mContext,mProxyClass);
                args[2] = safeIntent;

                // 3.绑定原来的Intent
                safeIntent.putExtra(EXTRA_ORIGIN_INTENT,originIntent);
            }
            return method.invoke(mObject,args);
        }
    }
}
