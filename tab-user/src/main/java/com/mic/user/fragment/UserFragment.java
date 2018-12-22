package com.mic.user.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mic.frame.model.Result;
import com.mic.frame.retrofit.HttpCallback;
import com.mic.frame.retrofit.RetrofitClient;
import com.mic.libcore.fragment.BaseFragment;
import com.mic.frame.model.user.User;
import com.mic.frame.Host;
import com.mic.user.R;
import com.mic.user.UURL;

import com.mic.user.api.UserApi;
import com.mic.user.model.UserResult;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;

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
            login("java","java");
        }
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
