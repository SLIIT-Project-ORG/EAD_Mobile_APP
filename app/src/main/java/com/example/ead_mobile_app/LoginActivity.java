package com.example.ead_mobile_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ead_mobile_app.Model.UserLoginRequest;
import com.example.ead_mobile_app.Model.UserLoginResponse;
import com.example.ead_mobile_app.Retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText userNameEditText, passwordEditText;
    Button loginBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        userNameEditText = findViewById(R.id.loginUsername);
        passwordEditText = findViewById(R.id.loginPassword);

//        loginBtn.setOnClickListener(this);
    }
//
//    @Override
//    public void onClick(View view) {
//        loginUser();
//    }
//
//    private void loginUser() {
//
//        String username = userNameEditText.getText().toString();
//        String password = passwordEditText.getText().toString();
//
//        if (username.isEmpty()) {
//            userNameEditText.requestFocus();
//            userNameEditText.setError("username cannot be empty");
//        }
//        if (password.isEmpty()) {
//            passwordEditText.requestFocus();
//            passwordEditText.setError("password cannot be empty");
//        }
//
//        UserLoginRequest userLoginRequest = new UserLoginRequest(
//                username, password
//        );
//
//        Call<UserLoginResponse> call = RetrofitClient
//                .getInstance()
//                .getEndpoint()
//                .loginUser(userLoginRequest);
//
//        call.enqueue(new Callback<UserLoginResponse>() {
//            @Override
//            public void onResponse(Call<UserLoginResponse> call, Response<UserLoginResponse> response) {
//                UserLoginResponse userLoginResponse = response.body();
//                if (response.isSuccessful()) {
//                    Toast.makeText(LoginActivity.this, userLoginResponse.getMessage(), Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(LoginActivity.this, userLoginResponse.getMessage().toString(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<UserLoginResponse> call, Throwable t) {
//                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
}
