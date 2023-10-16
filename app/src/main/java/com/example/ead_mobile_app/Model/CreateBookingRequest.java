package com.example.ead_mobile_app.Model;

public class CreateBookingRequest {
    private  int trainClass;
    private  String bookingNo;
    private  String fromStation;
    private  String toStation;
    private  String trainDate;
    private  String trainTime;
    private  String bookingDate;
    private  int noTickets;
    private  String availability;
    private  int cost;




    public CreateBookingRequest(String bookingNo, String fromStation, String toStation, String trainDate,
                                String trainTime, String bookingDate, int noTickets, String availability, int trainClass,int cost) {
        this.bookingNo = bookingNo;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.trainDate = trainDate;
        this.trainTime = trainTime;
        this.trainClass=trainClass;
        this.bookingDate = bookingDate;
        this.noTickets = noTickets;
        this.availability = availability;
        this.cost = cost;
    }



    public CreateBookingRequest() {
    }



    public String getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(String bookingDate) {
        this.bookingNo = bookingNo;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String username) {
        this.toStation = toStation;
    }

    public String getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(String username) {
        this.trainDate = trainDate;
    }

    public String getTrainTime() {
        return trainTime;
    }

    public void setTrainTime(String username) {
        this.trainTime = trainTime;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getNoTickets() {return noTickets;}

    public void setNoTickets(int noTickets) {
        this.noTickets = noTickets;
    }

    public String getAvailability() {return availability;}

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getCost() {return cost;}

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getTrainClass() {return trainClass;}

    public void setTrainClass(int trainClass) {
        this.trainClass = trainClass;
    }


}
