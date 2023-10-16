package com.example.ead_mobile_app;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ead_mobile_app.Model.CreateBookingRequest;
import com.example.ead_mobile_app.Model.CreateBookingResponse;
import com.example.ead_mobile_app.Retrofit.RetrofitClient;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingActivity extends AppCompatActivity implements View.OnClickListener {
    EditText noTicketsTxt;
    TextView bookingDateLbl, availabilityLbl, costLbl, bookingNoTxt, fromStationTxt, toStationTxt, trainDateTxt, trainTimeTxt, trainClassTxt;
    Button btnCheck, btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        bookingNoTxt = findViewById(R.id.bookingNo);
        fromStationTxt = findViewById(R.id.fromStation);
        toStationTxt = findViewById(R.id.toStation);
        trainDateTxt = findViewById(R.id.trainDate);
        trainTimeTxt = findViewById(R.id.trainTime);
        bookingDateLbl = findViewById(R.id.bookingDate);
        noTicketsTxt = findViewById(R.id.noTickets);
        trainClassTxt = findViewById(R.id.trainClass);
        availabilityLbl = findViewById(R.id.availability);
        btnCheck = findViewById(R.id.btnCheck);
        btnSubmit = findViewById(R.id.btnSubmit);

        //Calculate Total Cost
        btnCheck.setOnClickListener(view -> {
            costLbl = findViewById(R.id.cost);
            int trainClass = Integer.parseInt(trainClassTxt.getText().toString());
            int noTickets = Integer.parseInt(noTicketsTxt.getText().toString());
            int costTicket = 0;
            if (trainClass == 1) {
                costTicket = noTickets * 700;
            } else if (trainClass == 2) {
                costTicket = noTickets * 450;
            } else if ((trainClass == 3)) {
                costTicket = noTickets * 350;
            }

            costLbl.setText(String.valueOf(costTicket));

            //Check Availability
            availabilityLbl.setText("Available");

        });


        //Current Time-Booking Date
        TextView textView = findViewById(R.id.bookingDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm ");
        String currentDateandTime = sdf.format(new Date());
        bookingDateLbl.setText(currentDateandTime);//

        UUID randomUUID = UUID.randomUUID();
        long mostSignificantBits = randomUUID.getMostSignificantBits();

        // Mask to get only the last 16 bits (4 hexadecimal digits)
        long maskedBits = mostSignificantBits & 0xFFFF;

        // Format the masked bits as a 4-digit hexadecimal string
        String uuidString = String.format("%04X", maskedBits);

        bookingNoTxt.setText(String.valueOf(uuidString));
//        String uniqueId = UUID.randomUUID().toString();
//        bookingNoTxt.setText(String.valueOf(uniqueId));
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        createBooking();
    }

    private void createBooking() {

        String bookingNo = bookingNoTxt.getText().toString();
        String fromStation = fromStationTxt.getText().toString();
        String toStation = toStationTxt.getText().toString();
        String trainDate = trainDateTxt.getText().toString();
        String trainTime = trainTimeTxt.getText().toString();
        int trainClass = Integer.parseInt(trainClassTxt.getText().toString());
        String bookingDate = bookingDateLbl.getText().toString();
        int noTickets = Integer.parseInt(noTicketsTxt.getText().toString());
        String availability = availabilityLbl.getText().toString();
        int cost = Integer.parseInt(costLbl.getText().toString());
//
//
//
        CreateBookingRequest createBookingRequest = new CreateBookingRequest(
                bookingNo, fromStation, toStation, trainDate, trainTime, bookingDate, noTickets, availability, trainClass, cost);

        Call<CreateBookingResponse> call = RetrofitClient
                .getInstance()
                .gettingEndpoints()
                .createBooking(createBookingRequest);

        call.enqueue(new Callback<CreateBookingResponse>() {

            @Override

            public void onResponse(Call<CreateBookingResponse> call, Response<CreateBookingResponse> response) {
                CreateBookingResponse createBookingResponse = response.body();
                if (response.isSuccessful()) {
                    Toast.makeText(BookingActivity.this, createBookingResponse.getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(BookingActivity.this, createBookingResponse.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CreateBookingResponse> call, Throwable t) {
                Toast.makeText(BookingActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}