package com.mic.xsample.xokhttp;

public class XHttpClient {

    final XDispatcher dispatcher;

    public XHttpClient(Builder builder) {
        this.dispatcher = builder.dispatcher;
    }

    public XHttpClient(){
        this(new Builder());
    }

    public XCall newCall(XRequest request) {
        return RealCall.newCall(request,this);
    }


    public static class Builder{
        XDispatcher dispatcher;

        // 链接超时
        // https 证书的一些参数
        // 拦截器
        // 等等
        public Builder(){
            dispatcher = new XDispatcher();
        }

        public XHttpClient build(){
            return new XHttpClient();
        }
    }


}
