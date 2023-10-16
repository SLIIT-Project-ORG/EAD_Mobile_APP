package com.example.ead_mobile_app.Model;

public class Shedule {
    public String train_id;
    public String trainName;
    public String departureStation;
    public String arrivalStation;
    public String departureTime;
    public String arrivalTime;


    public Shedule(String trainId, String trainName,String departureStation, String arrivalStation,String departureTime,String arrivalTime) {
        this.train_id = trainId;
        this.trainName = trainName;
        this.departureStation=departureStation;
        this.arrivalTime=arrivalTime;
        this.arrivalStation=arrivalStation;
        this.departureTime=departureTime;

    }

    public String getTrain_id() {
        return train_id;
    }

    public void setTrain_id(String train_id) {

        this.train_id = train_id;
    }

    public String getTrainName() {

        return trainName;
    }

    public void setTrainName(String trainName) {

        this.trainName = trainName;
    }

    public String getDepartureStation(){
        return departureStation;
    }
    public void setDepartureStation(String departureStation){
        this.departureStation=departureStation;
    }
    public String getArrivalStation(){
        return arrivalStation;
    }
    public void setArrivalStation(String arrivalStation){
        this.arrivalStation=arrivalStation;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
