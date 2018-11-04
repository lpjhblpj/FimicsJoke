package com.mic.xsample.activity.opensource;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;



import com.mic.xsample.R;
import com.mic.xsample.rxretrofit.BaseSubscriber;
import com.mic.xsample.rxretrofit.Result;
import com.mic.xsample.rxretrofit.RxRetrofitClient;
import com.mic.xsample.rxretrofit.UserInfo;

import rx.android.schedulers.AndroidSchedulers;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;


public class RxRetrofitActivity extends AppCompatActivity {

    private static final String TAG ="RxRetrofit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        //testGet();
        testGet2();

    }


    private void testGet(){
       Observable observable =RxRetrofitClient.getServiceApi().userLogin("android","root");
       observable
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Subscriber<Result<UserInfo>>() {
           @Override
           public void onCompleted() {
               Log.d(TAG,"onCompleted");
           }

           @Override
           public void onError(Throwable e) {
               Log.d(TAG,"onError  "+e.getMessage());
           }

           @Override
           public void onNext(Result<UserInfo> userInfoResult) {
               Log.d(TAG,"onNext  "+userInfoResult.toString());
           }


       });
    }

    private void testGet2(){
        Observable observable =RxRetrofitClient.getServiceApi().userLogin("android","root");
        //转换返回值泛型  <UserInfo>transforme
        observable.compose(RxRetrofitClient.<UserInfo>transformer()).subscribe(new BaseSubscriber<UserInfo>() {
            @Override
            protected void onError(String errorCode, String errorMessage) {
                Log.e(TAG,"errorCode "+errorCode+"   errorMessage "+errorMessage);
            }

            @Override
            public void onNext(UserInfo userInfo) {
              Log.e(TAG,"onNext "+userInfo.toString());
            }
        });
    }


}
