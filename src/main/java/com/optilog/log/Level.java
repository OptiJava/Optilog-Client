package com.optilog.log;

public enum Level {
    /* */
    INFO("info"), ERROR("Error"), WARN("Warning"), DEBUG("debug"), FATAL("FATAL");
    
    Level(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    private final String name;
}
