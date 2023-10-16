package com.example.ead_mobile_app.API;

import com.example.ead_mobile_app.Model.Shedule;
import com.example.ead_mobile_app.Model.Train;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SheduleEndpoints {

    @GET("/api/TrainSchedule")
    Call<List<Shedule>> getAllShedules();

}
