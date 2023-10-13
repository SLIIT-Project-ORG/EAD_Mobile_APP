package com.example.ead_mobile_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ead_mobile_app.Model.UserCreateRequest;
import com.example.ead_mobile_app.Model.UserCreateResponse;
import com.example.ead_mobile_app.Retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    EditText firstNameEditText, lastNameEditText, userNameEditText, emailEditText, mobileNoEditText, passwordEditText, nicEditText;
    Button registerBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        firstNameEditText = findViewById(R.id.firstName);
        lastNameEditText = findViewById(R.id.lastName);
        userNameEditText = findViewById(R.id.userName);
        emailEditText = findViewById(R.id.email);
        mobileNoEditText = findViewById(R.id.mobileNo);
        passwordEditText = findViewById(R.id.password);
        nicEditText = findViewById(R.id.NIC);
        registerBtn = findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        createUser();
    }

    private void createUser() {
        String firstName = firstNameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        String username = userNameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String mobileNo = mobileNoEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String nic = nicEditText.getText().toString();
        String gender = "M";
        int age = 0;
        String imageRef = "";
        String description = "";
        int roleId = 2;

        if (username.isEmpty()) {
            userNameEditText.requestFocus();
            userNameEditText.setError("username cannot be empty");
        }
        if (nic.isEmpty()) {
            nicEditText.requestFocus();
            nicEditText.setError("NIC cannot be empty");
        }
        if (firstName.isEmpty()) {
            firstNameEditText.requestFocus();
            firstNameEditText.setError("Firstname cannot be empty");
        }
        if (lastName.isEmpty()) {
            lastNameEditText.requestFocus();
            lastNameEditText.setError("Lastname cannot be empty");
        }
        if (mobileNo.isEmpty()) {
            mobileNoEditText.requestFocus();
            mobileNoEditText.setError("Mobile No cannot be empty");
        }
        if (email.isEmpty()) {
            emailEditText.requestFocus();
            emailEditText.setError("Email cannot be empty");
        }

        UserCreateRequest userCreateRequest = new UserCreateRequest(
                firstName, lastName, username, email, mobileNo, password, nic, gender, age, imageRef, description, roleId
        );

        Call<UserCreateResponse> call = RetrofitClient
                .getInstance()
                .getEndpoint()
                .createUser(userCreateRequest);

        call.enqueue(new Callback<UserCreateResponse>() {
            @Override
            public void onResponse(Call<UserCreateResponse> call, Response<UserCreateResponse> response) {
                UserCreateResponse userCreateResponse = response.body();
                if (response.isSuccessful()) {
                    Toast.makeText(RegistrationActivity.this,userCreateResponse.getMessage(),Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(RegistrationActivity.this,userCreateResponse.getMessage().toString(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserCreateResponse> call, Throwable t) {
                Toast.makeText(RegistrationActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
