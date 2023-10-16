package com.example.ead_mobile_app.Retrofit;

import com.example.ead_mobile_app.API.AuthEndpoints;
import com.example.ead_mobile_app.API.BookingEndpoints;
import com.example.ead_mobile_app.API.SheduleEndpoints;
import com.example.ead_mobile_app.API.TrainEndpoints;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient1 {

    private static String BASE_URL = "https://eadbackend.onrender.com";
    private static RetrofitClient1 retrofitClient;
    private static Retrofit retrofit;

    private RetrofitClient1() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient1 getInstance() {
        if (retrofitClient == null) {
            retrofitClient = new RetrofitClient1();
        }
        return retrofitClient;
    }


    public SheduleEndpoints getAPIEndpoint() {
        return retrofit.create(SheduleEndpoints.class);
    }

}