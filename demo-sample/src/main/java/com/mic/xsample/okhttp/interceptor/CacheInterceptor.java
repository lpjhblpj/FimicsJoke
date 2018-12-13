package com.mic.xsample.okhttp.interceptor;



import com.mic.xsample.okhttp.Request;
import com.mic.xsample.okhttp.Response;

import java.io.IOException;

/**
 * Created by hcDarren on 2017/11/19.
 */

public class CacheInterceptor implements Interceptor{
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        // 本地有没有缓存，如果有没过期
        /*if(true){
            return new Response(new );
        }*/

        return chain.proceed(request);
    }
}
