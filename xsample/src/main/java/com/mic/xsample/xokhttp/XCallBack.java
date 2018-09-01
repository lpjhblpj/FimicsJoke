package com.mic.xsample.xokhttp;

public interface XCallBack {

    void onFailure(XCall call,Exception e);
    void onResponse(XCall call,XResponse response);
}
