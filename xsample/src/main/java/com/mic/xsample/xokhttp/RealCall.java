package com.mic.xsample.xokhttp;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class RealCall implements XCall {

    private static final String TAG ="RealCall";

    private final XRequest orignalRequest;
    private XHttpClient client;

    public RealCall(XRequest request,XHttpClient client){
          orignalRequest= request;
          this.client=client;
    }

    public static XCall newCall(XRequest request,XHttpClient client){
           return  new RealCall(request,client);
    }



    @Override
    public void enqueue(XCallBack callBack) {
       //异步
        AsynCall asynCall =new AsynCall(callBack);
        client.dispatcher.enqueue(asynCall);
    }

    @Override
    public XResponse execute() {
        //同步
       return null;
    }


    final class AsynCall extends NamedRunable{

        XCallBack callback;
        public AsynCall(XCallBack callback){
        this.callback=callback;
        }

        @Override
        protected void exexute() {
            // 来这里，开始访问网络 Request -> Response
            Log.e("TAG","execute");
            // Volley xUtils Afinal AsyHttpClient
            // 基于 HttpUrlConnection , OkHttp = Socket + okio(IO)
            final XRequest request = orignalRequest;
            try {
                URL url = new URL(request.url);

                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                if(urlConnection instanceof HttpsURLConnection){
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) urlConnection;
                    // https 的一些操作
                    // httpsURLConnection.setHostnameVerifier();
                    // httpsURLConnection.setSSLSocketFactory();
                }
                // urlConnection.setReadTimeout();

                // 写东西
                urlConnection.setRequestMethod(request.method.name);
                urlConnection.setDoOutput(request.method.doOutput());

                XRequestBody requestBody = request.body;
                if(requestBody != null){
                    // 头信息
                    urlConnection.setRequestProperty("Content-Type",requestBody.getContentType());
                    urlConnection.setRequestProperty("Content-Length",Long.toString(requestBody.getContentLength()));
                }

                urlConnection.connect();

                // 写内容
                if(requestBody != null){
                    requestBody.onWriteBody(urlConnection.getOutputStream());
                }

                int statusCode = urlConnection.getResponseCode();
                if(statusCode == 200) {
                    InputStream inputStream = urlConnection.getInputStream();
                    XResponse response = new XResponse(inputStream);
                    callback.onResponse(RealCall.this,response);
                }
                // 进行一些列操作，状态码 200
            } catch (IOException e) {
                callback.onFailure(RealCall.this,e);
            }
        }
        }

}
