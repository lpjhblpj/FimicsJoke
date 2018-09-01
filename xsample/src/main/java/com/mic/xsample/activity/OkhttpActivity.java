package com.mic.xsample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mic.xsample.R;
import com.mic.xsample.xokhttp.XCall;
import com.mic.xsample.xokhttp.XCallBack;
import com.mic.xsample.xokhttp.XHttpClient;
import com.mic.xsample.xokhttp.XRequest;
import com.mic.xsample.xokhttp.XResponse;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkhttpActivity extends AppCompatActivity {

    private static final String TAG = "okhttp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //get();
        xGet();
    }


    private void xGet(){
        XHttpClient client = new XHttpClient();
        XRequest xRequest = new XRequest.Builder()
                .url("http://192.168.31.204:8080/login")
                .build();
        XCall xCall = client.newCall(xRequest);
        xCall.enqueue(new XCallBack() {
           @Override
           public void onFailure(XCall call, Exception e) {

           }

           @Override
           public void onResponse(XCall call, XResponse response) {

           }
       });

    }

    private void get(){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://192.168.31.204:8080/login")
                .build();

        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Request request1 =call.request();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               String body = response.body().string();
               Log.d(TAG,body);
            }
        });
    }
}
