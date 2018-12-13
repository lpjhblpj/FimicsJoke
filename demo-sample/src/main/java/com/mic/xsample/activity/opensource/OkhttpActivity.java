package com.mic.xsample.activity.opensource;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mic.xsample.R;
import com.mic.xsample.okhttp.Call;
import com.mic.xsample.okhttp.Callback;
import com.mic.xsample.okhttp.OkHttpClient;
import com.mic.xsample.okhttp.Request;
import com.mic.xsample.okhttp.Response;

import java.io.IOException;



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
        OkHttpClient client = new OkHttpClient();
        Request xRequest = new Request.Builder()
                .url("http://192.168.31.204:8080/login")
                .build();
        Call xCall = client.newCall(xRequest);
        xCall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });

    }

    private void get(){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://192.168.31.204:8080/login")
                .build();

        Call call = client.newCall(request);

//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Request request1 =call.request();
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//               String body = response.body().string();
//               Log.d(TAG,body);
//            }
//        });
    }
}
