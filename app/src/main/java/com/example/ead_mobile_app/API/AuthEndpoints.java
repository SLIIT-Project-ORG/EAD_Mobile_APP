package com.example.ead_mobile_app.API;

import com.example.ead_mobile_app.Model.ApplicationUser;
import com.example.ead_mobile_app.Model.UserCreateRequest;
import com.example.ead_mobile_app.Model.UserCreateResponse;
import com.example.ead_mobile_app.Model.UserLoginRequest;
import com.example.ead_mobile_app.Model.UserLoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AuthEndpoints {

    @POST("/authenticate/register")
    Call<UserCreateResponse> createUser(@Body UserCreateRequest userCreateRequest);

    @POST("/authenticate/login")
    Call<UserLoginResponse> loginUser(@Body UserLoginRequest userLoginRequest);

    @GET("/users/{id}")
    Call<ApplicationUser> getUserById(@Path("id") String userId);

}
