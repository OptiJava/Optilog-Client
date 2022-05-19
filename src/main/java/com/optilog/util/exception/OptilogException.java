package com.optilog.util.exception;

public class OptilogException extends RuntimeException {
    public OptilogException() {
    }
    
    public OptilogException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public OptilogException(String message) {
        super(message);
    }
    
    public OptilogException(Throwable cause) {
        super(cause);
    }
}

