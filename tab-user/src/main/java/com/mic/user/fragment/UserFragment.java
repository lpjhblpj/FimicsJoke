package com.mic.user.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mic.frame.Host;
import com.mic.frame.model.Result;
import com.mic.frame.model.user.User;
import com.mic.frame.rxretrofit.HttpCallback;
import com.mic.frame.rxretrofit.RetrofitClient;
import com.mic.frame.rxretrofit.RxObserver;
import com.mic.frame.rxretrofit.RxResult;
import com.mic.frame.rxretrofit.RxRetrofitClient;
import com.mic.frame.rxretrofit.RxSchedulers;
import com.mic.libcore.fragment.BaseFragment;
import com.mic.user.R;
import com.mic.user.UURL;
import com.mic.user.api.RxUserApi;
import com.mic.user.api.UserApi;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;


@SuppressWarnings("all")
public class UserFragment extends BaseFragment implements View.OnClickListener {

    private Button btnLogin;


    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        EventBus.getDefault().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        btnLogin =rootView.findViewById(R.id.login);
        btnLogin.setOnClickListener(this);
        return rootView;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user;
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void eventTest(User user){
        Toast.makeText(getContext(),"user",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.login) {
            //login();
            //login("java","java");
            //rxLogin("java","java");
            rxLoginWrapper("java","java");
        }
    }

    private void rxLoginWrapper(String name,String password){

        RxRetrofitClient.getInstance().getRetrofit().create(RxUserApi.class)
                .login("java","java").compose(RxSchedulers.io_main())
                .compose(RxResult.result())
                .subscribe(new RxObserver<User>() {
                    @Override
                    protected void onError(String errorCode, String errorMessage) {
                        int a =0;
                    }

                    @Override
                    public void onNext(User user) {
                       int b =5;
                    }
                });





    }


    private void rxLogin(String name,String password){
        Retrofit retrofit =RxRetrofitClient.getInstance().getRetrofit();
        RxUserApi rxUserApi =retrofit.create(RxUserApi.class);
        Observable<Result<User>> observable =rxUserApi.login(name,password);

        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Result<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        int a=2;
                    }

                    @Override
                    public void onNext(Result<User> userResult) {

                        User user = (User) userResult.data;
                        int a =3;

                    }

                    @Override
                    public void onError(Throwable e) {
                          int a =3;
                    }

                    @Override
                    public void onComplete() {
                          int c =3;
                    }
                });


    }

    private void login(String name,String password){
        Retrofit retrofit =RetrofitClient.getInstance().getRetrofit();
        UserApi userApi =retrofit.create(UserApi.class);
        retrofit2.Call<Result<User>> call = userApi.login("java","java");
        call.enqueue(new HttpCallback<User>() {
            @Override
            public void onSucceed(User result) {
                User u = result;
                int a =5;
            }

            @Override
            public void onError(String code, String msg) {
              String xcode =code;
            }
        });

    }


    private void login(){

        final Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(Host.baseurl+UURL.login)
                .get()
                .build();

        Call call =client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String msg = e.getMessage();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res =response.body().string();

            }
        });

    }
}
