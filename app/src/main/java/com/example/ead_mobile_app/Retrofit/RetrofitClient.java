package com.example.ead_mobile_app.Retrofit;

import com.example.ead_mobile_app.API.Endpoints;
import com.example.ead_mobile_app.Model.UserCreateRequest;
import com.example.ead_mobile_app.Model.UserCreateResponse;
import com.example.ead_mobile_app.Model.UserLoginRequest;
import com.example.ead_mobile_app.Model.UserLoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class RetrofitClient {

    private static String BASE_URL = "https://ead-rest-api.onrender.com";
    private static RetrofitClient retrofitClient;
    private static Retrofit retrofit;

    private RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance(){
        if (retrofitClient==null){
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }

    public Endpoints getEndpoint() {
        return retrofit.create(Endpoints.class);
    }

}