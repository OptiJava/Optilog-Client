package com.optilog.log;

import com.optilog.util.OnlyInLog;

public class LogEvent {
    public String message;

    public final Level level;

    public LogMark marker = LogMark.NONE;

    @OnlyInLog
    public LogEvent(String msg, Level level) {
        this.level = level;
        this.message = msg;
    }
}
