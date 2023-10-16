package com.example.ead_mobile_app.API;

import com.example.ead_mobile_app.Model.Train;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TrainEndpoints {

    @GET("/api/v1/train")
    Call<List<Train>> getAllTrains();

}
