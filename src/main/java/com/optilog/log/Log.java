package com.optilog.log;

public interface Log {
    static Optilog initLog(String pathOfSettingFile) {
        Optilog optilog = new Optilog();
        optilog.settingFilePath = pathOfSettingFile;
        optilog.alreadyInit = false;
        return optilog;
    }
    
    static Optilog reInitLog(String pathOfSettingFile) {
        Optilog optilog = new Optilog();
        optilog.settingFilePath = pathOfSettingFile;
        optilog.alreadyInit = false;
        return optilog;
    }
    
    void info();
    
    void info(Object msg, Object... occupy);
    
    void info(long x);
    
    void info(double x);
    
    void info(char[] x);
    
    void info(short x);
    
    void info(int x);
    
    void info(float x);
    
    void info(String x);
    
    void info(Object x);
    
    void error();
    
    void error(Object msg, Object... occupy);
    
    void error(long x);
    
    void error(double x);
    
    void error(char[] x);
    
    void error(short x);
    
    void error(int x);
    
    void error(float x);
    
    void error(String x);
    
    void error(Object x);
    
    void warn();
    
    void warn(Object msg, Object... occupy);
    
    void warn(long x);
    
    void warn(double x);
    
    void warn(char[] x);
    
    void warn(short x);
    
    void warn(int x);
    
    void warn(float x);
    
    void warn(String x);
    
    void warn(Object x);
    
    void debug();
    
    void debug(Object msg, Object... occupy);
    
    void debug(long x);
    
    void debug(double x);
    
    void debug(char[] x);
    
    void debug(short x);
    
    void debug(int x);
    
    void debug(float x);
    
    void debug(String x);
    
    void debug(Object x);
    
    void fatal();
    
    void fatal(Object msg, Object... occupy);
    
    void fatal(long x);
    
    void fatal(double x);
    
    void fatal(char[] x);
    
    void fatal(short x);
    
    void fatal(int x);
    
    void fatal(float x);
    
    void fatal(String x);
    
    void fatal(Object x);
    
    void command(String x);
}