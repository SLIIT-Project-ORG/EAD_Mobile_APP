package com.example.ead_mobile_app.Model;

public class UserCreateResponse {
    private String Message;
    private boolean Success;

    public UserCreateResponse(String message, boolean success) {
        this.Message = message;
        this.Success = success;
    }

    public UserCreateResponse() {
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        this.Message = message;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        this.Success = success;
    }
}
