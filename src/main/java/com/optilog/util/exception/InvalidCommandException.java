package com.optilog.util.exception;

public final class InvalidCommandException extends OptilogException {
    public InvalidCommandException() {
    }
    
    public InvalidCommandException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public InvalidCommandException(String message) {
        super(message);
    }
    
    public InvalidCommandException(Throwable cause) {
        super(cause);
    }
}
