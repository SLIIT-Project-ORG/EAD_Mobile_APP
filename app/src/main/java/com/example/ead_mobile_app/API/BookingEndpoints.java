package com.example.ead_mobile_app.API;

import com.example.ead_mobile_app.Model.CreateBookingRequest;
import com.example.ead_mobile_app.Model.CreateBookingResponse;
import com.example.ead_mobile_app.Model.UserCreateResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface BookingEndpoints {
    @POST("api/booking")
    Call<CreateBookingResponse> createBooking(@Body CreateBookingRequest createBookingRequest);



}



