package com.optilog.util.exception;

public final class ConfigureException extends OptilogException {
    public ConfigureException() {
        super();
    }
    
    public ConfigureException(String msg) {
        super(msg);
    }
    
    public ConfigureException(Throwable th) {
        super(th);
    }
    
    public ConfigureException(String msg, Throwable th) {
        super(msg, th);
    }
}
