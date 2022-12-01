package com.optilog.log;

import com.optilog.util.LambdaExecute;

public interface Log extends IOptilog {
    static Log initLog(String pathOfSettingFile) {
        Optilog optilog = new Optilog(pathOfSettingFile);
        optilog.logPreparer(pathOfSettingFile, optilog);
        return optilog;
    }

    static Log initLog(Log optilog) {
        return optilog;
    }

    void logPreparer(String settingFilePath, Optilog instance);

    void info();

    void info(Object msg, Object... occupy);

    void info(Object msg, LambdaExecute... occupy);

    void info(Object msg, Throwable ex);

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

    void error(Object msg, LambdaExecute... occupy);

    void error(Object msg, Throwable ex);

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

    void warn(Object msg, LambdaExecute... occupy);

    void warn(Object msg, Throwable ex);

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

    void debug(Object msg, LambdaExecute... occupy);

    void debug(Object msg, Throwable ex);

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

    void fatal(Object msg, LambdaExecute... occupy);

    void fatal(Object msg, Throwable ex);

    void fatal(long x);

    void fatal(double x);

    void fatal(char[] x);

    void fatal(short x);

    void fatal(int x);

    void fatal(float x);

    void fatal(String x);

    void fatal(Object x);

    void command(String x);

    void setPrintInfo(boolean printInfo);

    void setPrintError(boolean printError);

    void setPrintWarn(boolean printWarn);

    void setPrintDebug(boolean printDebug);

    void setPrintFatal(boolean printFatal);

    void setConsoleInfo(boolean consoleInfo);

    void setConsoleError(boolean consoleError);

    void setConsoleWarn(boolean consoleWarn);

    void setConsoleDebug(boolean serverDebug);

    void setConsoleFatal(boolean serverFatal);

    void setServerInfo(boolean serverInfo);

    void setServerError(boolean serverError);

    void setServerWarn(boolean serverWarn);

    void setServerDebug(boolean serverDebug);

    void setServerFatal(boolean serverFatal);

    void setPrintPackingFormat(String printPackingFormat);

    void setFilePackingFormat(String filePackingFormat);

    void setServerPackingFormat(String serverPackingFormat);

    void startSendToJdbc(String url, String dataBaseName, String username, String password);

    void stopSendToJdbc(String url, String dataBaseName, String username, String password);

    void getAllField(Object instance);

    void log(Object obj, LevelBuild levelBuild);

    void log(Object x, LevelBuild levelBuild, Object... occupy);

    void log(Object x, LevelBuild levelBuild, LambdaExecute... occupy);

    void log(Object msg, LevelBuild levelBuild, Throwable ex);
}