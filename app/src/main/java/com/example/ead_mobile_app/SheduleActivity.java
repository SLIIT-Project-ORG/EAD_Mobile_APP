package com.example.ead_mobile_app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ead_mobile_app.Model.Shedule;
import com.example.ead_mobile_app.Model.Train;
import com.example.ead_mobile_app.Retrofit.RetrofitClient;
import com.example.ead_mobile_app.Retrofit.RetrofitClient1;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SheduleActivity extends AppCompatActivity {

    TextView trainNameTextView, trainTimeTextView, trainDateTextView;
    ListView sheduleListView;

    SheduleListAdapter sheduleListAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_train);

//        trainNameTextView = findViewById(R.id.sheduleDetailsTrainName);
//        trainTimeTextView = findViewById(R.id.sheduleDetailsTrainTime);
//        trainDateTextView = findViewById(R.id.sheduleDetailsDate);

        sheduleListView = findViewById(R.id.trainListView);
        sheduleListAdapter = new SheduleListAdapter(this, new ArrayList<Shedule>());

        sheduleListView.setAdapter(sheduleListAdapter);

        Call<List<Shedule>> call = RetrofitClient1
                .getInstance()
                .getAPIEndpoint()
                .getAllShedules();

        call.enqueue(new Callback<List<Shedule>>() {
            @Override
            public void onResponse(Call<List<Shedule>> call, Response<List<Shedule>> response) {
                if (response.isSuccessful()) {
                    List<Shedule> schedules = response.body();
                    if (schedules != null && !schedules.isEmpty()) {
                        sheduleListAdapter.addAll(schedules);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Shedule>> call, Throwable t) {
                Toast.makeText(SheduleActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}