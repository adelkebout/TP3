package org.example;

public class IncompatibleDataFormatException extends Exception {

    public IncompatibleDataFormatException() {
        super("Incompatible data format.");
    }

    public IncompatibleDataFormatException(String message) {
        super(message);
    }
}
