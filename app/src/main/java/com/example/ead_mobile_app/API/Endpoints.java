package com.example.ead_mobile_app.API;

import com.example.ead_mobile_app.Model.UserCreateRequest;
import com.example.ead_mobile_app.Model.UserCreateResponse;
import com.example.ead_mobile_app.Model.UserLoginRequest;
import com.example.ead_mobile_app.Model.UserLoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Endpoints {

    @POST("/authenticate/register")
    Call<UserCreateResponse> createUser(@Body UserCreateRequest userCreateRequest);

    @POST("/authenticate/login")
    Call<UserLoginResponse> loginUser(@Body UserLoginRequest userLoginRequest);

}
