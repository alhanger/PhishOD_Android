package com.phishin;

/**
 * Created by robert on 7/5/14.
 */
public class RequestException extends Exception {
    private static final long serialVersionUID = 458349507892345L;

    private String errorCode = "Unknown_Exception";

    public RequestException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

}
