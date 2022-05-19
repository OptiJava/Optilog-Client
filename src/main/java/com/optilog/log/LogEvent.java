package com.optilog.log;

public class LogEvent {
    public String message;
    
    public Level level;
    
    public String getMessage() {
        return this.message;
    }
    
    public Level getLevel() {
        return this.level;
    }
    
    public LogEvent(String msg, Level level) {
        this.level = level;
        this.message = msg;
    }
}
