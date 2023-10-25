package com.example.ead_mobile_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button bookingBtn, trainDetailsBtn, userProfileBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        bookingBtn = findViewById(R.id.ticketBookingBtn);
        trainDetailsBtn = findViewById(R.id.trainDetailsBtn);
        userProfileBtn = findViewById(R.id.userProfileBtn);

        bookingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bookingIntent = new Intent(HomeActivity.this,BookingActivity.class);
                startActivity(bookingIntent);
            }
        });

        trainDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent trainBookingIntent = new Intent(HomeActivity.this,TrainActivity.class);
                startActivity(trainBookingIntent);
            }
        });

        userProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userProfileIntent = new Intent(HomeActivity.this, UserAccountActivity.class);
                startActivity(userProfileIntent);
            }
        });
    }
}
