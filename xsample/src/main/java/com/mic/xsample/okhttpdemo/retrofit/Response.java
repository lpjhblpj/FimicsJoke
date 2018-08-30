package com.mic.xsample.okhttpdemo.retrofit;

/**
 * description:
 * author: Darren on 2017/10/13 11:51
 * email: 240336124@qq.com
 * version: 1.0
 */
public class Response<T> {
    T body;

    /**
     * The deserialized response body of a {@linkplain #isSuccessful() successful} response.
     */
    public T body() {
        return body;
    }
}
