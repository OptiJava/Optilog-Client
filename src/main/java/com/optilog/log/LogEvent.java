package com.optilog.log;

public class LogEvent {
    
    volatile String message;
    
    volatile Level level;
    
    @Override
    public String toString() {
        return this.level + " " + this.message;
    }
    
    public LogEvent(String msg, Level level) {
        this.level = level;
        this.message = msg;
    }
}
