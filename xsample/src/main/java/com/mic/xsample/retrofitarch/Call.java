package com.mic.xsample.retrofitarch;



public interface Call<T> {
    void enqueue(Callback<T> callback);
}