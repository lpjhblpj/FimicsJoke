package com.mic.xsample.retrofitarch;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


import okhttp3.Call;
import okhttp3.OkHttpClient;

public class XRetrofit {
    private static final String TAG ="Retrofit";
    final String baseUrl;
    final Call.Factory factory;
    private Map<Method ,ServiceMethod> serviceMethodMapCache = new ConcurrentHashMap<>();

    public XRetrofit(Builder builder) {
        this.baseUrl=builder.baseUrl;
        this.factory=builder.factory;
    }

    public <T>T create(Class<T> service){

        //检查是否是接口 ，而且不继承接口

        if(!service.isInterface()){
            throw  new RuntimeException("service不是一个接口");
        }



        //重要
       return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class[]{service}, new InvocationHandler() {
           @Override
           public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               Log.d(TAG,"methodName: "+method.getName());

               //如果是object的方法就返回
               if(method.getDeclaringClass()==Object.class){
                  return method.invoke(this,args);
               }

               //1.解析参数注解
               ServiceMethod serviceMethod =loadServiceMethod(method);


               //2.封装okhttpCall
               return null;
           }
       });
    }


    private ServiceMethod loadServiceMethod(Method method){
      //享元设计模式，其实就是做个缓存
        ServiceMethod serviceMethod = serviceMethodMapCache.get(method);
        if(serviceMethod==null){
            serviceMethod = new ServiceMethod.Builder(this,method).build();
            serviceMethodMapCache.put(method,serviceMethod);
        }
        return serviceMethod;
    }

    public static class Builder{

        String baseUrl;
        Call.Factory factory;

        public Builder baseUrl(String baseUrl){
           this.baseUrl=baseUrl;
           return this;
        }

        public Builder client(Call.Factory factory){
            this.factory=factory;
            return this;
        }


        public XRetrofit build(){

            if(factory==null){
                factory=new OkHttpClient();
            }

            return  new XRetrofit(this);
        }

    }
}
