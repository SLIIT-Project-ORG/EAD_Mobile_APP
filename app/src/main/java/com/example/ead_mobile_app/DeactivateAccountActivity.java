package com.example.ead_mobile_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DeactivateAccountActivity extends AppCompatActivity {

    Button deactivateBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_diactivateusers);

        deactivateBtn = findViewById(R.id.accountDeactivateDeactivateBtn);

        deactivateBtn.setOnClickListener(view -> {

        });
    }

}
