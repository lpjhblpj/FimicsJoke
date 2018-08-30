package com.mic.xsample.okhttpdemo;


import com.darren.okhttpdemo.retrofit.Retrofit;

/**
 * description:
 * author: Darren on 2017/10/12 11:14
 * email: 240336124@qq.com
 * version: 1.0
 */
public class RetrofitClient {
    private static DataServiceInterface serviceInterface;

    static {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.saiwuquan.com/")
                .build();

        serviceInterface = retrofit.create(DataServiceInterface.class);
    }

    public static DataServiceInterface getService() {
        return serviceInterface;
    }
}
