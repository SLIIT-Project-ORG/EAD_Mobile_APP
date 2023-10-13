package com.example.ead_mobile_app.Model;

public class UserLoginResponse {
    private Boolean Success;
    private String AccessToken;
    private String Email;
    private String UserId;
    private String Message;

    public UserLoginResponse(Boolean success, String accessToken, String email, String userId, String message) {
        Success = success;
        AccessToken = accessToken;
        Email = email;
        UserId = userId;
        Message = message;
    }

    public Boolean getSuccess() {
        return Success;
    }

    public void setSuccess(Boolean success) {
        Success = success;
    }

    public String getAccessToken() {
        return AccessToken;
    }

    public void setAccessToken(String accessToken) {
        AccessToken = accessToken;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
