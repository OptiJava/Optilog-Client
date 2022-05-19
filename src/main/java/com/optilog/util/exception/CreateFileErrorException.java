package com.optilog.util.exception;


public final class CreateFileErrorException extends OptilogException {
    public CreateFileErrorException() {
    }
    
    public CreateFileErrorException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public CreateFileErrorException(String message) {
        super(message);
    }
    
    public CreateFileErrorException(Throwable cause) {
        super(cause);
    }
}

