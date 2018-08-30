package com.mic.xsample.okhttpdemo;


import com.darren.okhttpdemo.retrofit.Call;
import com.darren.okhttpdemo.retrofit.http.annotation.FieldMap;
import com.darren.okhttpdemo.retrofit.http.annotation.POST;

import java.util.Map;

/**
 * description:
 * author: Darren on 2017/10/11 10:56
 * email: 240336124@qq.com
 * version: 1.0
 */
public interface DataServiceInterface {
    @POST("api/appv2/sceneModel")
    Call<Result> testMethod(@FieldMap Map<String, Object> bodyMap);
}
