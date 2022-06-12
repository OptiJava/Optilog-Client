package com.optilog.log;

public enum LogMark {
    NONE("NONE"), TEMPLATEInfo("info"), TEMPLATEError("Error"), TEMPLATEWarn("Warning"), TEMPLATEDebug("debug"), TEMPLATEFatal("FATAL");

    public final String name;

    LogMark(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
