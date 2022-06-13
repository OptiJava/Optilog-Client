package com.optilog.log;

import com.optilog.util.OnlyInLog;

public class LogEvent {
    public volatile String message;

    public volatile Level level;

    public volatile LogMark marker = LogMark.NONE;

    @Deprecated
    @Override
    public String toString() {
        return this.level + " " + this.message;
    }

    @OnlyInLog
    public LogEvent(String msg, Level level) {
        this.level = level;
        this.message = msg;
    }
}
