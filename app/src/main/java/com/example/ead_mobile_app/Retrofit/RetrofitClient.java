package com.example.ead_mobile_app.Retrofit;

import com.example.ead_mobile_app.API.AuthEndpoints;
import com.example.ead_mobile_app.API.BookingEndpoints;
import com.example.ead_mobile_app.API.SheduleEndpoints;
import com.example.ead_mobile_app.API.TrainEndpoints;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

    public static synchronized RetrofitClient getInstance() {
        if (retrofitClient == null) {
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }

    public AuthEndpoints getEndpoint() {
        return retrofit.create(AuthEndpoints.class);
    }

    public TrainEndpoints getEndpoints() {
        return retrofit.create(TrainEndpoints.class);
    }

    public BookingEndpoints gettingEndpoints() {
        return retrofit.create(BookingEndpoints.class);
    }

}