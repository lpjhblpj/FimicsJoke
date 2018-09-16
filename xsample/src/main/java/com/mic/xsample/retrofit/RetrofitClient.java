package com.mic.xsample.retrofit;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private final static IServiceAPI serverApi;

    static {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                //访问后台接口的主地址
                .baseUrl("http://192.168.31.204:8080")
                //添加解析工厂，gosn xml ...
                .addConverterFactory(GsonConverterFactory.create())
                //添加okhttpClient ,不添加默认就是okhttp
                .client(client)
                .build();

        //创建一个接口对象
        serverApi = retrofit.create(IServiceAPI.class);
    }


    public static  IServiceAPI getApi(){
        return  serverApi;
    }
}
