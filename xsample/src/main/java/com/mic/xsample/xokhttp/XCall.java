package com.mic.xsample.xokhttp;

public interface XCall {

    public void enqueue(XCallBack callBack);

    public XResponse execute();
}
