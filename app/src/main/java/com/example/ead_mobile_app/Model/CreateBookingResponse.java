package com.example.ead_mobile_app.Model;

public class CreateBookingResponse {


        private String Message;
        private boolean Success;

        public CreateBookingResponse(String message, boolean success) {
            this.Message = message;
            this.Success = success;
        }

        public CreateBookingResponse() {
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


