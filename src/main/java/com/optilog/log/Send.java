package com.optilog.log;

import com.optilog.log.client.Client;
import com.optilog.log.jdbc.MySQL;
import com.optilog.util.OnlyInLog;
import com.optilog.util.Util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Send {
    private Send() {
        super();
    }

    @OnlyInLog
    static void loggerPrint(LogEvent le, Optilog instance) {
        System.out.print(Packing.packMessage(le.message, le.level.getName(), instance, Appender.PRINT));
    }

    @OnlyInLog
    static void loggerConsole(LogEvent le, Optilog instance) {
        try {
            if (Level.INFO.getName().equals(le.level.getName()) & !instance.info.isBlank() & instance.consoleFileMasterCaution) {
                try {
                    synchronized (Util.getOutput()) {
                        Files.writeString(Path.of(instance.info), Files.readString(Path.of(instance.info), StandardCharsets.UTF_8) + Packing.packMessage(le.message, le.level.getName(), instance, Appender.FILE), StandardCharsets.UTF_8);
                    }
                } catch (IOException e) {
                    instance.consoleFileMasterCaution = false;
                    instance.error("Optilog Note:Java throws Exception when log is output", e);
                }
                return;
            }
            if (Level.ERROR.getName().equals(le.level.getName()) & !instance.error.isBlank() & instance.consoleFileMasterCaution) {
                try {
                    synchronized (Util.getOutput()) {
                        Files.writeString(Path.of(instance.error), Files.readString(Path.of(instance.error), StandardCharsets.UTF_8) + Packing.packMessage(le.message, le.level.getName(), instance, Appender.FILE), StandardCharsets.UTF_8);
                    }
                } catch (IOException e) {
                    instance.consoleFileMasterCaution = false;
                    instance.error("Optilog Note:Java throws Exception when log is output", e);
                }
                return;
            }
            if (Level.DEBUG.getName().equals(le.level.getName()) & !instance.debug.isBlank() & instance.consoleFileMasterCaution) {
                //String s = Packing.packMessage(message, level, instance);
                try {
                    synchronized (Util.getOutput()) {
                        Files.writeString(Path.of(instance.debug), Files.readString(Path.of(instance.debug), StandardCharsets.UTF_8) + Packing.packMessage(le.message, le.level.getName(), instance, Appender.FILE), StandardCharsets.UTF_8);
                    }
                } catch (IOException e) {
                    instance.consoleFileMasterCaution = false;
                    instance.error("Optilog Note:Java throws Exception when log is output", e);
                }
                return;
            }
            if (Level.WARN.getName().equals(le.level.getName()) & !instance.warn.isBlank() & instance.consoleFileMasterCaution) {
                //String s = Packing.packMessage(message, level, instance);
                try {
                    synchronized (Util.getOutput()) {
                        Files.writeString(Path.of(instance.warn), Files.readString(Path.of(instance.warn), StandardCharsets.UTF_8) + Packing.packMessage(le.message, le.level.getName(), instance, Appender.FILE), StandardCharsets.UTF_8);
                    }
                } catch (IOException e) {
                    instance.consoleFileMasterCaution = false;
                    instance.error("Optilog Note:Java throws Exception when log is output", e);
                }
                return;
            }
            if (Level.FATAL.getName().equals(le.level.getName()) & !instance.fatal.isBlank() & instance.consoleFileMasterCaution) {
                try {
                    synchronized (Util.getOutput()) {
                        Files.writeString(Path.of(instance.fatal), Files.readString(Path.of(instance.fatal), StandardCharsets.UTF_8) + Packing.packMessage(le.message, le.level.getName(), instance, Appender.FILE), StandardCharsets.UTF_8);
                    }
                } catch (IOException e) {
                    instance.consoleFileMasterCaution = false;
                    instance.error("Optilog Note:Java throws Exception when log is output", e);
                }
                return;
            }
            // Marker runner
            if (le.marker == LogMark.TEMPLATEInfo & instance.consoleFileMasterCaution & (!instance.info.isBlank())) {
                try {
                    synchronized (Util.getOutput()) {
                        Files.writeString(Path.of(instance.info), Files.readString(Path.of(instance.info), StandardCharsets.UTF_8) + Packing.packMessage(le.message, le.level.getName(), instance, Appender.FILE), StandardCharsets.UTF_8);
                    }
                } catch (IOException e) {
                    instance.consoleFileMasterCaution = false;
                    instance.error("Optilog Note:Java throws Exception when log is output", e);
                }
                return;
            }

            if (le.marker == LogMark.TEMPLATEError & instance.consoleFileMasterCaution & (!instance.error.isBlank())) {
                try {
                    synchronized (Util.getOutput()) {
                        Files.writeString(Path.of(instance.error), Files.readString(Path.of(instance.error), StandardCharsets.UTF_8) + Packing.packMessage(le.message, le.level.getName(), instance, Appender.FILE), StandardCharsets.UTF_8);
                    }
                } catch (IOException e) {
                    instance.consoleFileMasterCaution = false;
                    instance.error("Optilog Note:Java throws Exception when log is output", e);
                }
            }

            if (le.marker == LogMark.TEMPLATEWarn & instance.consoleFileMasterCaution & (!instance.warn.isBlank())) {
                try {
                    synchronized (Util.getOutput()) {
                        Files.writeString(Path.of(instance.warn), Files.readString(Path.of(instance.warn), StandardCharsets.UTF_8) + Packing.packMessage(le.message, le.level.getName(), instance, Appender.FILE), StandardCharsets.UTF_8);
                    }
                } catch (IOException e) {
                    instance.consoleFileMasterCaution = false;
                    instance.error("Optilog Note:Java throws Exception when log is output", e);
                }
                return;
            }

            if (le.marker == LogMark.TEMPLATEDebug & instance.consoleFileMasterCaution & (!instance.debug.isBlank())) {
                try {
                    synchronized (Util.getOutput()) {
                        Files.writeString(Path.of(instance.debug), Files.readString(Path.of(instance.debug), StandardCharsets.UTF_8) + Packing.packMessage(le.message, le.level.getName(), instance, Appender.FILE), StandardCharsets.UTF_8);
                    }
                } catch (IOException e) {
                    instance.consoleFileMasterCaution = false;
                    instance.error("Optilog Note:Java throws Exception when log is output", e);
                }
                return;
            }

            if (le.marker == LogMark.TEMPLATEFatal & instance.consoleFileMasterCaution & (!instance.fatal.isBlank())) {
                try {
                    synchronized (Util.getOutput()) {
                        Files.writeString(Path.of(instance.fatal), Files.readString(Path.of(instance.fatal), StandardCharsets.UTF_8) + Packing.packMessage(le.message, le.level.getName(), instance, Appender.FILE), StandardCharsets.UTF_8);
                    }
                } catch (IOException e) {
                    instance.consoleFileMasterCaution = false;
                    instance.error("Optilog Note:Java throws Exception when log is output", e);
                }
            }

        } catch (Exception e) {
            instance.consoleFileMasterCaution = false;
            instance.error("Optilog Note:Java throws Exception when log is output", e);
        }
    }

    @OnlyInLog
    static void loggerToServer(LogEvent le, final Optilog instance) {
        if (le.marker != LogMark.NONE) {
            Client.logAppender(Packing.packMessage(le.message, le.level.getName(), instance, Appender.SERVER) + le.marker.getName(), instance);
        } else {
            Client.logAppender(Packing.packMessage(le.message, le.level.getName(), instance, Appender.SERVER) + le.level.getName(), instance);
        }
    }

    @OnlyInLog
    static void loggerToJdbc(LogEvent le, final Optilog instance) {
        MySQL.logAppender(le, Thread.currentThread().getStackTrace()[4].getClassName(), Packing.packMessage(le.message, le.level.getName(), instance, Appender.JDBC), instance);
    }
}
