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

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

public class BookingActivity extends AppCompatActivity  implements View.OnClickListener {

    EditText bookingDateTxt, noTicketsTxt;
    TextView availabilityLbl, costLbl, bookingNoTxt, fromStationTxt, toStationTxt, trainDateTxt, trainTimeTxt,trainClassTxt;
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
        bookingDateTxt = findViewById(R.id.bookingDate);
        noTicketsTxt = findViewById(R.id.noTickets);
        trainClassTxt = findViewById(R.id.trainClass);
        availabilityLbl = findViewById(R.id.availability);
        costLbl = findViewById(R.id.cost);

        btnCheck = findViewById(R.id.btnCheck);

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
        int trainClass= Integer.parseInt(trainClassTxt.getText().toString());
        String bookingDate = bookingDateTxt.getText().toString();
        int noTickets = Integer.parseInt(noTicketsTxt.getText().toString());
        String availability = availabilityLbl.getText().toString();
        int cost = Integer.parseInt(costLbl.getText().toString());
//
        int numberOfTickets = Integer.parseInt(noTicketsTxt.getText().toString());

        if(trainClass==1){
            int costTicket = numberOfTickets * 700 ;
        }else if(trainClass==2){
            int costTicket = numberOfTickets * 450;
        }else{
            int costTicket = numberOfTickets * 350;
        }


//

        CreateBookingRequest createBookingRequest = new CreateBookingRequest(
                bookingNo, fromStation, toStation, trainDate, trainTime, bookingDate, noTickets, availability,trainClass,cost);

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