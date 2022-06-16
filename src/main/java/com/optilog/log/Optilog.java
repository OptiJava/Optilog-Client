package com.optilog.log;

import com.optilog.log.client.Client;
import com.optilog.log.console.Console;
import com.optilog.log.jdbc.MySQL;
import com.optilog.setting.SettingFiles;
import com.optilog.util.LambdaExecute;
import com.optilog.util.OnlyInInit;
import com.optilog.util.exception.OptilogException;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.DatagramSocket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Optilog implements Log {
    public volatile DatagramSocket socket;
    public volatile boolean consoleFileMasterCaution = true;

    public volatile MySQL connection = new MySQL();

    public volatile SettingFiles allSetting = new SettingFiles();

    public volatile String settingFilePath;

    public volatile String info = "";
    public volatile String error = "";
    public volatile String warn = "";
    public volatile String debug = "";
    public volatile String fatal = "";

    @OnlyInInit
    Optilog(String s) {
        this.settingFilePath = s;
    }

    @Override
    @OnlyInInit
    public void logPreparer(String settingFilePath, Optilog instance) {
        if (settingFilePath.isBlank()) {
            instance.consoleFileMasterCaution = false;
            return;
        }

        try {
            SettingFiles.check(settingFilePath, instance);
            if (instance.consoleFileMasterCaution) {
                Console.initAppender(instance);
                Client.initAppender(instance);
            }
        } catch (RuntimeException | IOException e) {
            System.err.println("Optilog Note:An Exception was thrown when Optilog init logger");
            throw new OptilogException("An Exception was thrown when Optilog init logger", e);
        }
    }

    @Override
    public void info() {
        LogEvent infoEvent = new LogEvent(" ", Level.INFO);
        infoEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logInfo(infoEvent, this);
    }

    @Override
    public void info(Object x, Object... occupy) {
        if (x == null) {
            x = "null";
        }
        String previousMsg = x.toString();
        int i0 = 0;
        while (i0 < occupy.length) {
            Matcher matcher = Pattern.compile("#\\w{1,10000}").matcher(previousMsg);
            if (matcher.find()) {
                String st = previousMsg.substring(matcher.start() + 1, matcher.end());
                int i = Integer.parseInt(st);
                if (occupy[i - 1] == null) {
                    occupy[i - 1] = "null";
                }
                if (!occupy[i - 1].toString().contains("#")) {
                    previousMsg = previousMsg.replace("#" + st, occupy[i - 1].toString());
                } else {
                    throw new IllegalArgumentException("Can't contain '#' in occupy log!");
                }
            }
            i0++;
        }
        LogEvent infoEvent = new LogEvent(previousMsg, Level.INFO);
        infoEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logInfo(infoEvent, this);
    }

    @Override
    public void info(Object x, LambdaExecute... occupy) {
        if (x == null) {
            x = "null";
        }
        String previousMsg = x.toString();
        int i0 = 0;
        while (i0 < occupy.length) {
            Matcher matcher = Pattern.compile("#\\w{1,10000}").matcher(previousMsg);
            if (matcher.find()) {
                String st = previousMsg.substring(matcher.start() + 1, matcher.end());
                int i = Integer.parseInt(st);
                if (occupy[i - 1] == null) {
                    occupy[i - 1] = () -> "null";
                }
                if (!occupy[i - 1].toString().contains("#")) {
                    previousMsg = previousMsg.replace("#" + st, occupy[i - 1].execute().toString());
                } else {
                    throw new IllegalArgumentException("Can't contain '#' in occupy log!");
                }
            }
            i0++;
        }
        LogEvent infoEvent = new LogEvent(previousMsg, Level.INFO);
        infoEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logInfo(infoEvent, this);
    }

    @Override
    public void info(Object msg, Throwable ex) {
        StringBuilder returnString = new StringBuilder();
        returnString.append(msg.toString()).append("\n");
        returnString.append(ex);
        returnString.append("\n");
        for (StackTraceElement s : ex.getStackTrace()) {
            returnString.append("    at ").append(s.getClassName()).append(" ").append(s.getMethodName()).append("(").append(s.getFileName()).append(":").append(s.getLineNumber()).append(")\n");
        }

        Throwable throwable = ex;

        while (throwable.getCause() != null) {
            returnString.append("Caused By: ").append(throwable.getCause()).append("\n");
            for (StackTraceElement st : throwable.getCause().getStackTrace()) {
                returnString.append("    at ").append(st.getClassName()).append(" ").append(st.getMethodName()).append("(").append(st.getFileName()).append(":").append(st.getLineNumber()).append(")\n");
            }
            throwable = throwable.getCause();
        }
        LogEvent infoEvent = new LogEvent(returnString.toString(), Level.INFO);
        infoEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logInfo(infoEvent, this);
    }

    @Override
    public void info(long x) {
        LogEvent infoEvent = new LogEvent(String.valueOf(x), Level.INFO);
        infoEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logInfo(infoEvent, this);
    }

    @Override
    public void info(double x) {
        LogEvent infoEvent = new LogEvent(String.valueOf(x), Level.INFO);
        infoEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logInfo(infoEvent, this);
    }

    @Override
    public void info(char[] x) {
        if (x == null) {
            x = new char[]{'n', 'u', 'l', 'l'};
        }
        LogEvent infoEvent = new LogEvent(String.valueOf(x), Level.INFO);
        infoEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logInfo(infoEvent, this);
    }

    @Override
    public void info(short x) {
        LogEvent infoEvent = new LogEvent(String.valueOf(x), Level.INFO);
        infoEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logInfo(infoEvent, this);
    }

    @Override
    public void info(int x) {
        LogEvent infoEvent = new LogEvent(String.valueOf(x), Level.INFO);
        infoEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logInfo(infoEvent, this);
    }

    @Override
    public void info(float x) {
        LogEvent infoEvent = new LogEvent(String.valueOf(x), Level.INFO);
        infoEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logInfo(infoEvent, this);
    }

    @Override
    public void info(String x) {
        if (x == null) {
            x = "null";
        }
        LogEvent infoEvent = new LogEvent(x, Level.INFO);
        infoEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logInfo(infoEvent, this);
    }

    @Override
    public void info(Object x) {
        if (x == null) {
            x = "null";
        }
        LogEvent infoEvent = new LogEvent(x.toString(), Level.INFO);
        infoEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logInfo(infoEvent, this);
    }

    @Override
    public void error() {
        LogEvent errorEvent = new LogEvent(" ", Level.ERROR);
        errorEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logError(errorEvent, this);
    }

    @Override
    public void error(Object x, Object... occupy) {
        if (x == null) {
            x = "null";
        }
        String previousMsg = x.toString();
        int i0 = 0;
        while (i0 < occupy.length) {
            Matcher matcher = Pattern.compile("#\\w{1,10000}").matcher(previousMsg);
            if (matcher.find()) {
                String st = previousMsg.substring(matcher.start() + 1, matcher.end());
                int i = Integer.parseInt(st);
                if (occupy[i - 1] == null) {
                    occupy[i - 1] = "null";
                }
                if (!occupy[i - 1].toString().contains("#")) {
                    previousMsg = previousMsg.replace("#" + st, occupy[i - 1].toString());
                } else {
                    throw new IllegalArgumentException("Can't contain '#' in occupy log!");
                }
            }
            i0++;
        }
        LogEvent errorEvent = new LogEvent(previousMsg, Level.ERROR);
        errorEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logError(errorEvent, this);
    }

    @Override
    public void error(Object x, LambdaExecute... occupy) {
        if (x == null) {
            x = "null";
        }
        String previousMsg = x.toString();
        int i0 = 0;
        while (i0 < occupy.length) {
            Matcher matcher = Pattern.compile("#\\w{1,10000}").matcher(previousMsg);
            if (matcher.find()) {
                String st = previousMsg.substring(matcher.start() + 1, matcher.end());
                int i = Integer.parseInt(st);
                if (occupy[i - 1] == null) {
                    occupy[i - 1] = () -> "null";
                }
                if (!occupy[i - 1].toString().contains("#")) {
                    previousMsg = previousMsg.replace("#" + st, occupy[i - 1].execute().toString());
                } else {
                    throw new IllegalArgumentException("Can't contain '#' in occupy log!");
                }
            }
            i0++;
        }
        LogEvent errorEvent = new LogEvent(previousMsg, Level.ERROR);
        errorEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logError(errorEvent, this);
    }

    @Override
    public void error(Object msg, Throwable ex) {
        StringBuilder returnString = new StringBuilder();
        returnString.append(msg.toString()).append("\n");
        returnString.append(ex);
        returnString.append("\n");
        for (StackTraceElement s : ex.getStackTrace()) {
            returnString.append("    at ").append(s.getClassName()).append(" ").append(s.getMethodName()).append("(").append(s.getFileName()).append(":").append(s.getLineNumber()).append(")\n");
        }

        Throwable throwable = ex;

        while (throwable.getCause() != null) {
            returnString.append("Caused By: ").append(throwable.getCause()).append("\n");
            for (StackTraceElement st : throwable.getCause().getStackTrace()) {
                returnString.append("    at ").append(st.getClassName()).append(" ").append(st.getMethodName()).append("(").append(st.getFileName()).append(":").append(st.getLineNumber()).append(")\n");
            }
            throwable = throwable.getCause();
        }
        LogEvent errorEvent = new LogEvent(returnString.toString(), Level.ERROR);
        errorEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logError(errorEvent, this);
    }

    @Override
    public void error(long x) {
        LogEvent errorEvent = new LogEvent(String.valueOf(x), Level.ERROR);
        errorEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logError(errorEvent, this);
    }

    @Override
    public void error(double x) {
        LogEvent errorEvent = new LogEvent(String.valueOf(x), Level.ERROR);
        errorEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logError(errorEvent, this);
    }

    @Override
    public void error(char[] x) {
        if (x == null) {
            x = new char[]{'n', 'u', 'l', 'l'};
        }
        LogEvent errorEvent = new LogEvent(String.valueOf(x), Level.ERROR);
        errorEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logError(errorEvent, this);
    }

    @Override
    public void error(short x) {
        LogEvent errorEvent = new LogEvent(String.valueOf(x), Level.ERROR);
        errorEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logError(errorEvent, this);
    }

    @Override
    public void error(int x) {
        LogEvent errorEvent = new LogEvent(String.valueOf(x), Level.ERROR);
        errorEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logError(errorEvent, this);
    }

    @Override
    public void error(float x) {
        LogEvent errorEvent = new LogEvent(String.valueOf(x), Level.ERROR);
        errorEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logError(errorEvent, this);
    }

    @Override
    public void error(String x) {
        if (x == null) {
            x = "null";
        }
        LogEvent errorEvent = new LogEvent(x, Level.ERROR);
        errorEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logError(errorEvent, this);
    }

    @Override
    public void error(Object x) {
        if (x == null) {
            x = "null";
        }
        LogEvent errorEvent = new LogEvent(x.toString(), Level.ERROR);
        errorEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logError(errorEvent, this);
    }

    @Override
    public void warn() {
        LogEvent warnEvent = new LogEvent(" ", Level.WARN);
        warnEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logWarn(warnEvent, this);
    }

    @Override
    public void warn(Object x, Object... occupy) {
        if (x == null) {
            x = "null";
        }
        String previousMsg = x.toString();
        int i0 = 0;
        while (i0 < occupy.length) {
            Matcher matcher = Pattern.compile("#\\w{1,10000}").matcher(previousMsg);
            if (matcher.find()) {
                String st = previousMsg.substring(matcher.start() + 1, matcher.end());
                int i = Integer.parseInt(st);
                if (occupy[i - 1] == null) {
                    occupy[i - 1] = "null";
                }
                if (!occupy[i - 1].toString().contains("#")) {
                    previousMsg = previousMsg.replace("#" + st, occupy[i - 1].toString());
                } else {
                    throw new IllegalArgumentException("Can't contain '#' in occupy log!");
                }
            }
            i0++;
        }
        LogEvent warnEvent = new LogEvent(previousMsg, Level.WARN);
        warnEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logWarn(warnEvent, this);
    }

    @Override
    public void warn(Object x, LambdaExecute... occupy) {
        if (x == null) {
            x = "null";
        }
        String previousMsg = x.toString();
        int i0 = 0;
        while (i0 < occupy.length) {
            Matcher matcher = Pattern.compile("#\\w{1,10000}").matcher(previousMsg);
            if (matcher.find()) {
                String st = previousMsg.substring(matcher.start() + 1, matcher.end());
                int i = Integer.parseInt(st);
                if (occupy[i - 1] == null) {
                    occupy[i - 1] = () -> "null";
                }
                if (!occupy[i - 1].toString().contains("#")) {
                    previousMsg = previousMsg.replace("#" + st, occupy[i - 1].execute().toString());
                } else {
                    throw new IllegalArgumentException("Can't contain '#' in occupy log!");
                }
            }
            i0++;
        }
        LogEvent warnEvent = new LogEvent(previousMsg, Level.WARN);
        warnEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logWarn(warnEvent, this);
    }

    @Override
    public void warn(Object msg, Throwable ex) {
        StringBuilder returnString = new StringBuilder();
        returnString.append(msg.toString()).append("\n");
        returnString.append(ex);
        returnString.append("\n");
        for (StackTraceElement s : ex.getStackTrace()) {
            returnString.append("    at ").append(s.getClassName()).append(" ").append(s.getMethodName()).append("(").append(s.getFileName()).append(":").append(s.getLineNumber()).append(")\n");
        }

        Throwable throwable = ex;

        while (throwable.getCause() != null) {
            returnString.append("Caused By: ").append(throwable.getCause()).append("\n");
            for (StackTraceElement st : throwable.getCause().getStackTrace()) {
                returnString.append("    at ").append(st.getClassName()).append(" ").append(st.getMethodName()).append("(").append(st.getFileName()).append(":").append(st.getLineNumber()).append(")\n");
            }
            throwable = throwable.getCause();
        }
        LogEvent warnEvent = new LogEvent(returnString.toString(), Level.WARN);
        warnEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logWarn(warnEvent, this);
    }

    @Override
    public void warn(long x) {
        LogEvent warnEvent = new LogEvent(String.valueOf(x), Level.WARN);
        warnEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logWarn(warnEvent, this);
    }

    @Override
    public void warn(double x) {
        LogEvent warnEvent = new LogEvent(String.valueOf(x), Level.WARN);
        warnEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logWarn(warnEvent, this);
    }

    @Override
    public void warn(char[] x) {
        if (x == null) {
            x = new char[]{'n', 'u', 'l', 'l'};
        }
        LogEvent warnEvent = new LogEvent(String.valueOf(x), Level.WARN);
        warnEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logWarn(warnEvent, this);
    }

    @Override
    public void warn(short x) {
        LogEvent warnEvent = new LogEvent(String.valueOf(x), Level.WARN);
        warnEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logWarn(warnEvent, this);
    }

    @Override
    public void warn(int x) {
        LogEvent warnEvent = new LogEvent(String.valueOf(x), Level.WARN);
        warnEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logWarn(warnEvent, this);
    }

    @Override
    public void warn(float x) {
        LogEvent warnEvent = new LogEvent(String.valueOf(x), Level.WARN);
        warnEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logWarn(warnEvent, this);
    }

    @Override
    public void warn(String x) {
        if (x == null) {
            x = "null";
        }
        LogEvent warnEvent = new LogEvent(x, Level.WARN);
        warnEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logWarn(warnEvent, this);
    }

    @Override
    public void warn(Object x) {
        if (x == null) {
            x = "null";
        }
        LogEvent warnEvent = new LogEvent(x.toString(), Level.WARN);
        warnEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logWarn(warnEvent, this);
    }

    @Override
    public void debug() {
        LogEvent debugEvent = new LogEvent(" ", Level.DEBUG);
        debugEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logDebug(debugEvent, this);
    }

    @Override
    public void debug(Object x, Object... occupy) {
        if (x == null) {
            x = "null";
        }
        String previousMsg = x.toString();
        int i0 = 0;
        while (i0 < occupy.length) {
            Matcher matcher = Pattern.compile("#\\w{1,10000}").matcher(previousMsg);
            if (matcher.find()) {
                String st = previousMsg.substring(matcher.start() + 1, matcher.end());
                int i = Integer.parseInt(st);
                if (occupy[i - 1] == null) {
                    occupy[i - 1] = "null";
                }
                if (!occupy[i - 1].toString().contains("#")) {
                    previousMsg = previousMsg.replace("#" + st, occupy[i - 1].toString());
                } else {
                    throw new IllegalArgumentException("Can't contain '#' in occupy log!");
                }
            }
            i0++;
        }
        LogEvent debugEvent = new LogEvent(previousMsg, Level.DEBUG);
        debugEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logDebug(debugEvent, this);
    }

    @Override
    public void debug(Object x, LambdaExecute... occupy) {
        if (x == null) {
            x = "null";
        }
        String previousMsg = x.toString();
        int i0 = 0;
        while (i0 < occupy.length) {
            Matcher matcher = Pattern.compile("#\\w{1,10000}").matcher(previousMsg);
            if (matcher.find()) {
                String st = previousMsg.substring(matcher.start() + 1, matcher.end());
                int i = Integer.parseInt(st);
                if (occupy[i - 1] == null) {
                    occupy[i - 1] = () -> "null";
                }
                if (!occupy[i - 1].toString().contains("#")) {
                    previousMsg = previousMsg.replace("#" + st, occupy[i - 1].execute().toString());
                } else {
                    throw new IllegalArgumentException("Can't contain '#' in occupy log!");
                }
            }
            i0++;
        }
        LogEvent debugEvent = new LogEvent(previousMsg, Level.DEBUG);
        debugEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logDebug(debugEvent, this);
    }

    @Override
    public void debug(Object msg, Throwable ex) {
        StringBuilder returnString = new StringBuilder();
        returnString.append(msg.toString()).append("\n");
        returnString.append(ex);
        returnString.append("\n");
        for (StackTraceElement s : ex.getStackTrace()) {
            returnString.append("    at ").append(s.getClassName()).append(" ").append(s.getMethodName()).append("(").append(s.getFileName()).append(":").append(s.getLineNumber()).append(")\n");
        }

        Throwable throwable = ex;

        while (throwable.getCause() != null) {
            returnString.append("Caused By: ").append(throwable.getCause()).append("\n");
            for (StackTraceElement st : throwable.getCause().getStackTrace()) {
                returnString.append("    at ").append(st.getClassName()).append(" ").append(st.getMethodName()).append("(").append(st.getFileName()).append(":").append(st.getLineNumber()).append(")\n");
            }
            throwable = throwable.getCause();
        }
        LogEvent debugEvent = new LogEvent(returnString.toString(), Level.DEBUG);
        debugEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logDebug(debugEvent, this);
    }

    @Override
    public void debug(long x) {
        LogEvent debugEvent = new LogEvent(String.valueOf(x), Level.DEBUG);
        debugEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logDebug(debugEvent, this);
    }

    @Override
    public void debug(double x) {
        LogEvent debugEvent = new LogEvent(String.valueOf(x), Level.DEBUG);
        debugEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logDebug(debugEvent, this);
    }

    @Override
    public void debug(char[] x) {
        if (x == null) {
            x = new char[]{'n', 'u', 'l', 'l'};
        }
        LogEvent debugEvent = new LogEvent(String.valueOf(x), Level.DEBUG);
        debugEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logDebug(debugEvent, this);
    }

    @Override
    public void debug(short x) {
        LogEvent debugEvent = new LogEvent(String.valueOf(x), Level.DEBUG);
        debugEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logDebug(debugEvent, this);
    }

    @Override
    public void debug(int x) {
        LogEvent debugEvent = new LogEvent(String.valueOf(x), Level.DEBUG);
        debugEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logDebug(debugEvent, this);
    }

    @Override
    public void debug(float x) {
        LogEvent debugEvent = new LogEvent(String.valueOf(x), Level.DEBUG);
        debugEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logDebug(debugEvent, this);
    }

    @Override
    public void debug(String x) {
        if (x == null) {
            x = "null";
        }
        LogEvent debugEvent = new LogEvent(x, Level.DEBUG);
        debugEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logDebug(debugEvent, this);
    }

    @Override
    public void debug(Object x) {
        if (x == null) {
            x = "null";
        }
        LogEvent debugEvent = new LogEvent(x.toString(), Level.DEBUG);
        debugEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logDebug(debugEvent, this);
    }

    @Override
    public void fatal() {
        LogEvent fatalEvent = new LogEvent(" ", Level.FATAL);
        fatalEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logFatal(fatalEvent, this);
    }

    @Override
    public void fatal(Object x, Object... occupy) {
        if (x == null) {
            x = "null";
        }
        String previousMsg = x.toString();
        int i0 = 0;
        while (i0 < occupy.length) {
            Matcher matcher = Pattern.compile("#\\w{1,10000}").matcher(previousMsg);
            if (matcher.find()) {
                String st = previousMsg.substring(matcher.start() + 1, matcher.end());
                int i = Integer.parseInt(st);
                if (occupy[i - 1] == null) {
                    occupy[i - 1] = "null";
                }
                if (!occupy[i - 1].toString().contains("#")) {
                    previousMsg = previousMsg.replace("#" + st, occupy[i - 1].toString());
                } else {
                    throw new IllegalArgumentException("Can't contain '#' in occupy log!");
                }
            }
            i0++;
        }
        LogEvent fatalEvent = new LogEvent(previousMsg, Level.FATAL);
        fatalEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logFatal(fatalEvent, this);
    }

    @Override
    public void fatal(Object x, LambdaExecute... occupy) {
        if (x == null) {
            x = "null";
        }
        String previousMsg = x.toString();
        int i0 = 0;
        while (i0 < occupy.length) {
            Matcher matcher = Pattern.compile("#\\w{1,10000}").matcher(previousMsg);
            if (matcher.find()) {
                String st = previousMsg.substring(matcher.start() + 1, matcher.end());
                int i = Integer.parseInt(st);
                if (occupy[i - 1] == null) {
                    occupy[i - 1] = () -> "null";
                }
                if (!occupy[i - 1].toString().contains("#")) {
                    previousMsg = previousMsg.replace("#" + st, occupy[i - 1].execute().toString());
                } else {
                    throw new IllegalArgumentException("Can't contain '#' in occupy log!");
                }
            }
            i0++;
        }
        LogEvent fatalEvent = new LogEvent(previousMsg, Level.FATAL);
        fatalEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logFatal(fatalEvent, this);
    }

    @Override
    public void fatal(Object msg, Throwable ex) {
        StringBuilder returnString = new StringBuilder();
        returnString.append(msg.toString()).append("\n");
        returnString.append(ex);
        returnString.append("\n");
        for (StackTraceElement s : ex.getStackTrace()) {
            returnString.append("    at ").append(s.getClassName()).append(" ").append(s.getMethodName()).append("(").append(s.getFileName()).append(":").append(s.getLineNumber()).append(")\n");
        }

        Throwable throwable = ex;

        while (throwable.getCause() != null) {
            returnString.append("Caused By: ").append(throwable.getCause()).append("\n");
            for (StackTraceElement st : throwable.getCause().getStackTrace()) {
                returnString.append("    at ").append(st.getClassName()).append(" ").append(st.getMethodName()).append("(").append(st.getFileName()).append(":").append(st.getLineNumber()).append(")\n");
            }
            throwable = throwable.getCause();
        }
        LogEvent fatalEvent = new LogEvent(returnString.toString(), Level.FATAL);
        fatalEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logFatal(fatalEvent, this);
    }

    @Override
    public void fatal(long x) {
        LogEvent fatalEvent = new LogEvent(String.valueOf(x), Level.FATAL);
        fatalEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logFatal(fatalEvent, this);
    }

    @Override
    public void fatal(double x) {
        LogEvent fatalEvent = new LogEvent(String.valueOf(x), Level.FATAL);
        fatalEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logFatal(fatalEvent, this);
    }

    @Override
    public void fatal(char[] x) {
        if (x == null) {
            x = new char[]{'n', 'u', 'l', 'l'};
        }
        LogEvent fatalEvent = new LogEvent(String.valueOf(x), Level.FATAL);
        fatalEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logFatal(fatalEvent, this);
    }

    @Override
    public void fatal(short x) {
        LogEvent fatalEvent = new LogEvent(String.valueOf(x), Level.FATAL);
        fatalEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logFatal(fatalEvent, this);
    }

    @Override
    public void fatal(int x) {
        LogEvent fatalEvent = new LogEvent(String.valueOf(x), Level.FATAL);
        fatalEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logFatal(fatalEvent, this);
    }

    @Override
    public void fatal(float x) {
        LogEvent fatalEvent = new LogEvent(String.valueOf(x), Level.FATAL);
        fatalEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logFatal(fatalEvent, this);
    }

    @Override
    public void fatal(String x) {
        if (x == null) {
            x = "null";
        }
        LogEvent fatalEvent = new LogEvent(x, Level.FATAL);
        fatalEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logFatal(fatalEvent, this);
    }

    @Override
    public void fatal(Object x) {
        if (x == null) {
            x = "null";
        }
        LogEvent fatalEvent = new LogEvent(x.toString(), Level.FATAL);
        fatalEvent.marker = LogMark.NONE;
        Logger.INSTANCE.logFatal(fatalEvent, this);
    }

    @Override
    public void command(String cmd) {
        if (cmd == null) {
            cmd = "null";
        }
        Logger.logCommand(cmd, this);
    }

    @Override
    public void setPrintInfo(boolean printInfo) {
        this.allSetting.printInfo = printInfo;
    }

    @Override
    public void setPrintError(boolean printError) {
        this.allSetting.printError = printError;
    }

    @Override
    public void setPrintWarn(boolean printWarn) {
        this.allSetting.printWarn = printWarn;
    }

    @Override
    public void setPrintDebug(boolean printDebug) {
        this.allSetting.printDebug = printDebug;
    }

    @Override
    public void setPrintFatal(boolean printFatal) {
        this.allSetting.printFatal = printFatal;
    }

    @Override
    public void setConsoleInfo(boolean consoleInfo) {
        this.allSetting.consoleInfo = consoleInfo;
    }

    @Override
    public void setConsoleError(boolean consoleError) {
        this.allSetting.consoleError = consoleError;
    }

    @Override
    public void setConsoleWarn(boolean consoleWarn) {
        this.allSetting.consoleWarn = consoleWarn;
    }

    @Override
    public void setConsoleDebug(boolean consoleDebug) {
        this.allSetting.consoleDebug = consoleDebug;
    }

    @Override
    public void setConsoleFatal(boolean consoleFatal) {
        this.allSetting.consoleFatal = consoleFatal;
    }

    @Override
    public void setServerInfo(boolean serverInfo) {
        this.allSetting.serverInfo = serverInfo;
    }

    @Override
    public void setServerError(boolean serverError) {
        this.allSetting.serverError = serverError;
    }

    @Override
    public void setServerWarn(boolean serverWarn) {
        this.allSetting.serverWarn = serverWarn;
    }

    @Override
    public void setServerDebug(boolean serverDebug) {
        this.allSetting.serverDebug = serverDebug;
    }

    @Override
    public void setServerFatal(boolean serverFatal) {
        this.allSetting.serverFatal = serverFatal;
    }

    @Override
    public void startSendToJdbc(String url, String dataBaseName, String username, String password) {
        this.connection.sendToJdbc = true;
        MySQL.initAppender(url, username, password, dataBaseName, this);
    }

    @Override
    public void stopSendToJdbc(String url, String dataBaseName, String username, String password) {
        this.connection.sendToJdbc = false;
        this.connection = null;
    }

    @Override
    public void getAllField(Object instance) {
        final StringBuilder str = new StringBuilder();
        str.append("\n").append(instance.getClass()).append(" -> ").append(instance).append(":\n");
        for (Field f : instance.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                str.append("    ").append(f.getName()).append("(").append(f.getType()).append(")").append(" = ").append(f.get(instance)).append("\n");
            } catch (IllegalAccessException ignored) {

            }
        }
        this.info(str.append("end").toString());
    }

    @Override
    public void log(Object obj, LevelBuild levelBuild) {
        if (levelBuild.levelTemplate.equals(Level.INFO)) {
            LogEvent logEvent = new LogEvent(obj.toString(), new Level(levelBuild.levelName));
            logEvent.marker = LogMark.TEMPLATEInfo;
            Logger.INSTANCE.logInfo(logEvent, this);
            return;
        }
        if (levelBuild.levelTemplate.equals(Level.ERROR)) {
            LogEvent logEvent = new LogEvent(obj.toString(), new Level(levelBuild.levelName));
            logEvent.marker = LogMark.TEMPLATEError;
            Logger.INSTANCE.logError(logEvent, this);
            return;
        }
        if (levelBuild.levelTemplate.equals(Level.WARN)) {
            LogEvent logEvent = new LogEvent(obj.toString(), new Level(levelBuild.levelName));
            logEvent.marker = LogMark.TEMPLATEWarn;
            Logger.INSTANCE.logWarn(logEvent, this);
            return;
        }
        if (levelBuild.levelTemplate.equals(Level.DEBUG)) {
            LogEvent logEvent = new LogEvent(obj.toString(), new Level(levelBuild.levelName));
            logEvent.marker = LogMark.TEMPLATEDebug;
            Logger.INSTANCE.logDebug(logEvent, this);
            return;
        }
        if (levelBuild.levelTemplate.equals(Level.FATAL)) {
            LogEvent logEvent = new LogEvent(obj.toString(), new Level(levelBuild.levelName));
            logEvent.marker = LogMark.TEMPLATEFatal;
            Logger.INSTANCE.logFatal(logEvent, this);
        }
    }

    @Override
    public void log(Object x, LevelBuild levelBuild, Object... occupy) {
        if (x == null) {
            x = "null";
        }
        String previousMsg = x.toString();
        int i0 = 0;
        while (i0 < occupy.length) {
            Matcher matcher = Pattern.compile("#\\w{1,10000}").matcher(previousMsg);
            if (matcher.find()) {
                String st = previousMsg.substring(matcher.start() + 1, matcher.end());
                int i = Integer.parseInt(st);
                if (occupy[i - 1] == null) {
                    occupy[i - 1] = "null";
                }
                if (!occupy[i - 1].toString().contains("#")) {
                    previousMsg = previousMsg.replace("#" + st, occupy[i - 1].toString());
                } else {
                    throw new IllegalArgumentException("Can't contain '#' in occupy log!");
                }
            }
            i0++;
        }

        if (levelBuild.levelTemplate.equals(Level.INFO)) {
            LogEvent logEvent = new LogEvent(previousMsg, new Level(levelBuild.levelName));
            logEvent.marker = LogMark.TEMPLATEInfo;
            Logger.INSTANCE.logInfo(logEvent, this);
            return;
        }
        if (levelBuild.levelTemplate.equals(Level.ERROR)) {
            LogEvent logEvent = new LogEvent(previousMsg, new Level(levelBuild.levelName));
            logEvent.marker = LogMark.TEMPLATEError;
            Logger.INSTANCE.logError(logEvent, this);
            return;
        }
        if (levelBuild.levelTemplate.equals(Level.WARN)) {
            LogEvent logEvent = new LogEvent(previousMsg, new Level(levelBuild.levelName));
            logEvent.marker = LogMark.TEMPLATEWarn;
            Logger.INSTANCE.logWarn(logEvent, this);
            return;
        }
        if (levelBuild.levelTemplate.equals(Level.DEBUG)) {
            LogEvent logEvent = new LogEvent(previousMsg, new Level(levelBuild.levelName));
            logEvent.marker = LogMark.TEMPLATEDebug;
            Logger.INSTANCE.logDebug(logEvent, this);
            return;
        }
        if (levelBuild.levelTemplate.equals(Level.FATAL)) {
            LogEvent logEvent = new LogEvent(previousMsg, new Level(levelBuild.levelName));
            logEvent.marker = LogMark.TEMPLATEFatal;
            Logger.INSTANCE.logFatal(logEvent, this);
        }
    }

    @Override
    public void log(Object x, LevelBuild levelBuild, LambdaExecute... occupy) {
        if (x == null) {
            x = "null";
        }
        String previousMsg = x.toString();
        int i0 = 0;
        while (i0 < occupy.length) {
            Matcher matcher = Pattern.compile("#\\w{1,10000}").matcher(previousMsg);
            if (matcher.find()) {
                String st = previousMsg.substring(matcher.start() + 1, matcher.end());
                int i = Integer.parseInt(st);
                if (occupy[i - 1] == null) {
                    occupy[i - 1] = () -> "null";
                }
                if (!occupy[i - 1].toString().contains("#")) {
                    previousMsg = previousMsg.replace("#" + st, occupy[i - 1].execute().toString());
                } else {
                    throw new IllegalArgumentException("Can't contain '#' in occupy log!");
                }
            }
            i0++;
        }

        if (levelBuild.levelTemplate.equals(Level.INFO)) {
            LogEvent logEvent = new LogEvent(previousMsg, new Level(levelBuild.levelName));
            logEvent.marker = LogMark.TEMPLATEInfo;
            Logger.INSTANCE.logInfo(logEvent, this);
            return;
        }
        if (levelBuild.levelTemplate.equals(Level.ERROR)) {
            LogEvent logEvent = new LogEvent(previousMsg, new Level(levelBuild.levelName));
            logEvent.marker = LogMark.TEMPLATEError;
            Logger.INSTANCE.logError(logEvent, this);
            return;
        }
        if (levelBuild.levelTemplate.equals(Level.WARN)) {
            LogEvent logEvent = new LogEvent(previousMsg, new Level(levelBuild.levelName));
            logEvent.marker = LogMark.TEMPLATEWarn;
            Logger.INSTANCE.logWarn(logEvent, this);
            return;
        }
        if (levelBuild.levelTemplate.equals(Level.DEBUG)) {
            LogEvent logEvent = new LogEvent(previousMsg, new Level(levelBuild.levelName));
            logEvent.marker = LogMark.TEMPLATEDebug;
            Logger.INSTANCE.logDebug(logEvent, this);
            return;
        }
        if (levelBuild.levelTemplate.equals(Level.FATAL)) {
            LogEvent logEvent = new LogEvent(previousMsg, new Level(levelBuild.levelName));
            logEvent.marker = LogMark.TEMPLATEFatal;
            Logger.INSTANCE.logFatal(logEvent, this);
        }
    }

    @Override
    public void log(Object msg, LevelBuild levelBuild, Throwable ex) {
        StringBuilder returnString = new StringBuilder();
        returnString.append(msg.toString()).append("\n");
        returnString.append(ex);
        returnString.append("\n");
        for (StackTraceElement s : ex.getStackTrace()) {
            returnString.append("    at ").append(s.getClassName()).append(" ").append(s.getMethodName()).append("(").append(s.getFileName()).append(":").append(s.getLineNumber()).append(")\n");
        }

        Throwable throwable = ex;

        while (throwable.getCause() != null) {
            returnString.append("Caused By: ").append(throwable.getCause()).append("\n");
            for (StackTraceElement st : throwable.getCause().getStackTrace()) {
                returnString.append("    at ").append(st.getClassName()).append(" ").append(st.getMethodName()).append("(").append(st.getFileName()).append(":").append(st.getLineNumber()).append(")\n");
            }
            throwable = throwable.getCause();
        }

        if (levelBuild.levelTemplate.equals(Level.INFO)) {
            LogEvent logEvent = new LogEvent(returnString.toString(), new Level(levelBuild.levelName));
            logEvent.marker = LogMark.TEMPLATEInfo;
            Logger.INSTANCE.logInfo(logEvent, this);
            return;
        }
        if (levelBuild.levelTemplate.equals(Level.ERROR)) {
            LogEvent logEvent = new LogEvent(returnString.toString(), new Level(levelBuild.levelName));
            logEvent.marker = LogMark.TEMPLATEError;
            Logger.INSTANCE.logError(logEvent, this);
            return;
        }
        if (levelBuild.levelTemplate.equals(Level.WARN)) {
            LogEvent logEvent = new LogEvent(returnString.toString(), new Level(levelBuild.levelName));
            logEvent.marker = LogMark.TEMPLATEWarn;
            Logger.INSTANCE.logWarn(logEvent, this);
            return;
        }
        if (levelBuild.levelTemplate.equals(Level.DEBUG)) {
            LogEvent logEvent = new LogEvent(returnString.toString(), new Level(levelBuild.levelName));
            logEvent.marker = LogMark.TEMPLATEDebug;
            Logger.INSTANCE.logDebug(logEvent, this);
            return;
        }
        if (levelBuild.levelTemplate.equals(Level.FATAL)) {
            LogEvent logEvent = new LogEvent(returnString.toString(), new Level(levelBuild.levelName));
            logEvent.marker = LogMark.TEMPLATEFatal;
            Logger.INSTANCE.logFatal(logEvent, this);
        }
    }
}

