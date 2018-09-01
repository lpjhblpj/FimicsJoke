package com.mic.xsample.xokhttp;


import java.util.Map;

public class XRequest {

    final  String url;
    final  Method method;
    final  XRequestBody body;
    final  Map<String,String> headers;

    public XRequest(Builder builder){
        this.url = builder.url;
        this.method = builder.method;
        this.body = builder.body;
        this.headers=builder.headers;
    }

    public static class Builder {
        // url body headers

         String url;
         Method method;
         XRequestBody body;
         Map<String,String> headers;

         public Builder(){
             method= Method.GET;
         }

         public Builder url(String url){
             this.url= url;
             return this;
         }


         public Builder get(){
             method = Method.GET;
             return this;
         }

         public Builder post(XRequestBody body){
             method= Method.POST;
             this.body=body;
             return this;
         }

         public void setHeaders(Map<String,String> headers){
             this.headers = headers;
         }

         public XRequest build(){
             return new XRequest(this);
         }



    }
}
