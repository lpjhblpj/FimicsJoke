package com.mic.user.api;

import com.mic.frame.model.Result;
import com.mic.frame.model.user.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserApi {

    @GET("login")
    Call<Result<User>> login(@Query("name") String name, @Query("password") String password);
}
