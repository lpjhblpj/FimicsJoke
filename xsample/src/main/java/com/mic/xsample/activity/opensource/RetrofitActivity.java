package com.mic.xsample.activity.opensource;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.mic.xsample.R;
import com.mic.xsample.retrofit.HttpCallback;
import com.mic.xsample.retrofit.Result;
import com.mic.xsample.retrofit.RetrofitClient;
import com.mic.xsample.retrofit.UserInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RetrofitActivity extends AppCompatActivity {

    private static final String TAG ="RetrofitActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        //testGet();
        getHttpCallBack();
    }


    private void testGet(){
        Call<Result<UserInfo>> resultCall  =RetrofitClient.getServiceApi().userLogin("android","root");

        resultCall.enqueue(new Callback<Result<UserInfo>>() {
            @Override
            public void onResponse(Call<Result<UserInfo>> call, Response<Result<UserInfo>> response) {
                String body = response.body().data.toString();
                Log.d(TAG,body);
            }

            @Override
            public void onFailure(Call<Result<UserInfo>> call, Throwable t) {
                String msg =t.getMessage();
                Log.d(TAG,msg);
            }
        });

    }

    private void getHttpCallBack(){
        // OkHttp +RxJava + Retrofit
        RetrofitClient.getServiceApi().userLogin("android","940223")
                .enqueue(new HttpCallback<UserInfo>(){
                    @Override
                    public void onSucceed(UserInfo result) {
                        // 成功
                        Toast.makeText(RetrofitActivity.this,"成功"+result.toString(),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(String code, String msg) {
                        // 失败
                        Toast.makeText(RetrofitActivity.this,msg,Toast.LENGTH_LONG).show();
                    }
                });
    }

}
