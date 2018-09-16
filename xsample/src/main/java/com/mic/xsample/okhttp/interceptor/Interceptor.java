package com.mic.xsample.okhttp.interceptor;



import com.mic.xsample.okhttp.Request;
import com.mic.xsample.okhttp.Response;

import java.io.IOException;

/**
 * Created by hcDarren on 2017/11/19.
 */

public interface Interceptor {
    Response intercept(Chain chain) throws IOException;
    interface Chain {
        Request request();

        Response proceed(Request request) throws IOException;
    }
}
