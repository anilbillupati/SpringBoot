package com.SpringBoot.RESTAPI.RestAPIPractice.rest;

public class StudentErrorResponse {

    private int status;
    private String message;
    private long timesTamp;

    public StudentErrorResponse(){

    }
    public StudentErrorResponse(int status, String message, long timesTamp) {
        this.status = status;
        this.message = message;
        this.timesTamp = timesTamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimesTamp() {
        return timesTamp;
    }

    public void setTimesTamp(long timesTamp) {
        this.timesTamp = timesTamp;
    }
}
