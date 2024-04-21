package org.example;

public class ApiCallFailureException extends Exception {

    public ApiCallFailureException() {
        super("API call failed.");
    }

    public ApiCallFailureException(String message) {
        super(message);
    }

    public ApiCallFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
