package com.example.ead_mobile_app.Model;

public class Train {
    public String trainId;
    public String trainName;
    public int capacity;
    public String description;
    public boolean isActive;
    public int trainTypeId;

    public Train(String trainId, String trainName, int capacity, String description, boolean isActive, int trainTypeId) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.capacity = capacity;
        this.description = description;
        this.isActive = isActive;
        this.trainTypeId = trainTypeId;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getTrainTypeId() {
        return trainTypeId;
    }

    public void setTrainTypeId(int trainTypeId) {
        this.trainTypeId = trainTypeId;
    }
}
