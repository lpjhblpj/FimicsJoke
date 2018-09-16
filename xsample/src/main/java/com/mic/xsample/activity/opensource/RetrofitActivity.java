package com.mic.xsample.activity.opensource;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mic.xsample.R;
import com.mic.xsample.retrofit.RetrofitClient;
import com.mic.xsample.retrofit.UserLoginResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    private static final String TAG ="RetrofitActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        testGet();
    }


    private void testGet(){
        Call<UserLoginResult> call =RetrofitClient.getApi().login("android","root");
        call.enqueue(new Callback<UserLoginResult>() {
            @Override
            public void onResponse(Call<UserLoginResult> call, Response<UserLoginResult> response) {
                UserLoginResult result =response.body();
                Log.d(TAG,result.toString());
            }

            @Override
            public void onFailure(Call<UserLoginResult> call, Throwable t) {
                  t.printStackTrace();
            }
        });
    }
}
