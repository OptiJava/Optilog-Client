package com.optilog.util.exception;


public final class GsonNotFoundException extends OptilogException {
    public GsonNotFoundException() {
    }
    
    public GsonNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public GsonNotFoundException(String message) {
        super(message);
    }
    
    public GsonNotFoundException(Throwable cause) {
        super(cause);
    }
}

