package com.mic.xsample.retrofitarch.sample;


import com.mic.xsample.retrofitarch.Call;
import com.mic.xsample.retrofitarch.http.GET;
import com.mic.xsample.retrofitarch.http.Query;


/**
 * Created by hcDarren on 2017/12/16.
 * 请求后台访问数据的 接口类
 */
public interface ServiceApi {
    // 接口涉及到解耦，userLogin 方法是没有任何实现代码的
    // 如果有一天要换 GoogleHttp

    @GET("login")// 登录接口 GET(相对路径)
    Call<?> userLogin(
            // @Query(后台需要解析的字段)
            @Query("userName") String userName,
            @Query("password") String userPwd);

    // POST

    // 上传文件怎么用？
}