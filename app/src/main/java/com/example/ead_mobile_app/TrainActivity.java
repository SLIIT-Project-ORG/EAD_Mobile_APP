package com.example.ead_mobile_app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ead_mobile_app.Model.Train;
import com.example.ead_mobile_app.Retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrainActivity extends AppCompatActivity {

    TextView trainNameTextView, trainCapacityTextView, trainTypeTextView;
    ListView trainListView;
    TrainListAdapter trainListAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_train);

        trainNameTextView = findViewById(R.id.trainNameTextView);
        trainCapacityTextView = findViewById(R.id.trainCapacityTextView);
        trainTypeTextView = findViewById(R.id.trainTypeTextView);

        trainListView = findViewById(R.id.trainListView);
        trainListAdapter = new TrainListAdapter(this, new ArrayList<Train>());

        trainListView.setAdapter(trainListAdapter);

        Call<List<Train>> call = RetrofitClient
                .getInstance()
                .getEndpoints()
                .getAllTrains();

        call.enqueue(new Callback<List<Train>>() {
            @Override
            public void onResponse(Call<List<Train>> call, Response<List<Train>> response) {
                if (response.isSuccessful()) {
                    List<Train> trains = response.body();
                    if (trains != null && !trains.isEmpty()) {
                        trainListAdapter.addAll(trains);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Train>> call, Throwable t) {
                Toast.makeText(TrainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
