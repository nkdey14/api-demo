package com.apidemo.payload;

import java.util.Date;

public class ErrorDetails {

    private String message;
    private Date date;
    private String details;

    public ErrorDetails(String message, Date date, String details) {
        this.message = message;
        this.date = date;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
