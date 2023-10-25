package com.example.ead_mobile_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ead_mobile_app.Model.ApplicationUser;
import com.example.ead_mobile_app.Model.ResponseDto;
import com.example.ead_mobile_app.Retrofit.RetrofitClient;

import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserAccountActivity extends AppCompatActivity {

    TextView fullNameTextView, userNameTextView, emailTextView, ageTextView;
    Button deactivateBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_useraccount);

        fullNameTextView = findViewById(R.id.fullNameTextVew);
        userNameTextView = findViewById(R.id.userNameTextView);
        emailTextView = findViewById(R.id.emailTextView);
        ageTextView = findViewById(R.id.ageTextView);
        deactivateBtn = findViewById(R.id.deactivateBtn);

        SharedPreferences sharedPreferences = getSharedPreferences("user_details", Context.MODE_PRIVATE);
        String userId = sharedPreferences.getString("userId", "");

        Call<ApplicationUser> call = RetrofitClient
                .getInstance()
                .getEndpoint()
                .getUserById(userId);

        call.enqueue(new Callback<ApplicationUser>() {
            @Override
            public void onResponse(Call<ApplicationUser> call, Response<ApplicationUser> response) {
                if (response.isSuccessful()) {
                    Logger logger = Logger.getLogger("User Profile");
                    logger.info("Data retrieved");
                    ApplicationUser applicationUser = response.body();
                    fullNameTextView.setText(applicationUser.getFirstName() + " " + applicationUser.getLastName());
                    userNameTextView.setText(applicationUser.getUsername());
                    emailTextView.setText(applicationUser.getEmail());
                    ageTextView.setText(String.valueOf(applicationUser.getAge()));
                }else {
                    Toast.makeText(UserAccountActivity.this,"ERROR",Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<ApplicationUser> call, Throwable t) {
                Toast.makeText(UserAccountActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        deactivateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<ResponseDto> call = RetrofitClient.getInstance().getEndpoint().deactivateUser(userId);

                call.enqueue(new Callback<ResponseDto>() {
                    @Override
                    public void onResponse(Call<ResponseDto> call, Response<ResponseDto> response) {
                        if (response.isSuccessful()){
                            Logger logger = Logger.getLogger("User Account");
                            logger.info("Request success");
                            Toast.makeText(UserAccountActivity.this,"User Deactivated",Toast.LENGTH_SHORT);
                        }else {
                            Toast.makeText(UserAccountActivity.this,"User Deactivated",Toast.LENGTH_SHORT);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseDto> call, Throwable t) {
                        Toast.makeText(UserAccountActivity.this,"User Deactivated",Toast.LENGTH_SHORT);
                    }
                });
            }
        });
    }

}
