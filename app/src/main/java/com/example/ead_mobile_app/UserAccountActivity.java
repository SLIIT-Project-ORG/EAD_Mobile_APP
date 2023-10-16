package com.example.ead_mobile_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ead_mobile_app.Model.ApplicationUser;
import com.example.ead_mobile_app.Retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserAccountActivity extends AppCompatActivity {

    TextView fullNameTextView, userNameTextView, emailTextView, ageTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_useraccount);

        fullNameTextView = findViewById(R.id.userProfileFullName);
        userNameTextView = findViewById(R.id.userProfileUsername);
        emailTextView = findViewById(R.id.userProfileEmail);
        ageTextView = findViewById(R.id.userProfileAge);

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
                    ApplicationUser applicationUser = response.body();
                    fullNameTextView.setText(applicationUser.getFirstName() + applicationUser.getLastName());
                    userNameTextView.setText(applicationUser.getUsername());
                    emailTextView.setText(applicationUser.getEmail());
                    ageTextView.setText(applicationUser.getAge());
                }else {
                    Toast.makeText(UserAccountActivity.this,"ERROR",Toast.LENGTH_SHORT);
                }
            }

            @Override
            public void onFailure(Call<ApplicationUser> call, Throwable t) {
                Toast.makeText(UserAccountActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
