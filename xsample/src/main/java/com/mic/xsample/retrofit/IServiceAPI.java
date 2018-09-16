package com.mic.xsample.retrofit;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IServiceAPI {

    @GET("login") // 登录接口 get(相对路径)提交  query（后台需要解析的字段）
    Call<UserLoginResult> login(@Query("userName") String username, @Query("password") String password);
}
