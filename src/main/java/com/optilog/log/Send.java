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
    }

    final static Send INSTANCE = new Send();

    @OnlyInLog
    void loggerPrint(LogEvent le, Optilog instance) {
        synchronized (Send.INSTANCE) {
            if (le.level.equals(Level.ERROR) || le.level.equals(Level.FATAL)) {
                System.err.print(Packing.packMessage(le.message, le.level.getName(), instance));
            }
            Util.getOutput().print(Packing.packMessage(le.message, le.level.getName(), instance));
        }
    }

    @OnlyInLog
    void loggerConsole(LogEvent le, Optilog instance) {
        String s = Packing.packMessage(le.message, le.level.getName(), instance);
        try {
            Thread thread = new Thread(() -> {
                if (instance.consoleFileMasterCaution & Level.INFO.getName().equals(le.level.getName()) & !instance.info.isBlank()) {
                    try {
                        synchronized (Send.INSTANCE) {
                            Files.writeString(Path.of(instance.info), Files.readString(Path.of(instance.info), StandardCharsets.UTF_8) + s, StandardCharsets.UTF_8);
                        }
                    } catch (IOException e) {
                        instance.consoleFileMasterCaution = false;
                        instance.error("Optilog Note:Java throws Exception when log is output", e);
                    }
                    return;
                }
                if (instance.consoleFileMasterCaution & Level.ERROR.getName().equals(le.level.getName()) & !instance.error.isBlank()) {
                    outputFile(instance, s);
                    return;
                }
                if (instance.consoleFileMasterCaution & Level.DEBUG.getName().equals(le.level.getName()) & !instance.debug.isBlank()) {
                    //String s = Packing.packMessage(message, level, instance);
                    try {
                        synchronized (Send.INSTANCE) {
                            Files.writeString(Path.of(instance.debug), Files.readString(Path.of(instance.debug), StandardCharsets.UTF_8) + s, StandardCharsets.UTF_8);
                        }
                    } catch (IOException e) {
                        instance.consoleFileMasterCaution = false;
                        instance.error("Optilog Note:Java throws Exception when log is output", e);
                    }
                    return;
                }
                if (instance.consoleFileMasterCaution & Level.WARN.getName().equals(le.level.getName()) & !instance.warn.isBlank()) {
                    //String s = Packing.packMessage(message, level, instance);
                    try {
                        synchronized (Send.INSTANCE) {
                            Files.writeString(Path.of(instance.warn), Files.readString(Path.of(instance.warn), StandardCharsets.UTF_8) + s, StandardCharsets.UTF_8);
                        }
                    } catch (IOException e) {
                        instance.consoleFileMasterCaution = false;
                        instance.error("Optilog Note:Java throws Exception when log is output", e);
                    }
                    return;
                }
                if (instance.consoleFileMasterCaution & Level.FATAL.getName().equals(le.level.getName()) & !instance.fatal.isBlank()) {
                    try {
                        synchronized (Send.INSTANCE) {
                            Files.writeString(Path.of(instance.fatal), Files.readString(Path.of(instance.fatal), StandardCharsets.UTF_8) + s, StandardCharsets.UTF_8);
                        }
                    } catch (IOException e) {
                        instance.consoleFileMasterCaution = false;
                        instance.error("Optilog Note:Java throws Exception when log is output", e);
                    }
                    return;
                }
                if (instance.consoleFileMasterCaution) {
                    if (le.marker == LogMark.TEMPLATEInfo) {
                        try {
                            synchronized (Send.INSTANCE) {
                                Files.writeString(Path.of(instance.info), Files.readString(Path.of(instance.info), StandardCharsets.UTF_8) + s, StandardCharsets.UTF_8);
                            }
                        } catch (IOException e) {
                            instance.consoleFileMasterCaution = false;
                            instance.error("Optilog Note:Java throws Exception when log is output", e);
                        }
                        return;
                    }

                    if (le.marker == LogMark.TEMPLATEError) {
                        outputFile(instance, s);
                    }

                    if (le.marker == LogMark.TEMPLATEWarn) {
                        try {
                            synchronized (Send.INSTANCE) {
                                Files.writeString(Path.of(instance.warn), Files.readString(Path.of(instance.warn), StandardCharsets.UTF_8) + s, StandardCharsets.UTF_8);
                            }
                        } catch (IOException e) {
                            instance.consoleFileMasterCaution = false;
                            instance.error("Optilog Note:Java throws Exception when log is output", e);
                        }
                        return;
                    }

                    if (le.marker == LogMark.TEMPLATEDebug) {
                        try {
                            synchronized (Send.INSTANCE) {
                                Files.writeString(Path.of(instance.debug), Files.readString(Path.of(instance.debug), StandardCharsets.UTF_8) + s, StandardCharsets.UTF_8);
                            }
                        } catch (IOException e) {
                            instance.consoleFileMasterCaution = false;
                            instance.error("Optilog Note:Java throws Exception when log is output", e);
                        }
                        return;
                    }

                    if (le.marker == LogMark.TEMPLATEFatal) {
                        try {
                            synchronized (Send.INSTANCE) {
                                Files.writeString(Path.of(instance.fatal), Files.readString(Path.of(instance.fatal), StandardCharsets.UTF_8) + s, StandardCharsets.UTF_8);
                            }
                        } catch (IOException e) {
                            instance.consoleFileMasterCaution = false;
                            instance.error("Optilog Note:Java throws Exception when log is output", e);
                        }
                    }
                }
            });
            thread.setName("Optilog Logging Thread");
            thread.start();
        } catch (Exception e) {
            instance.consoleFileMasterCaution = false;
            instance.error("Optilog Note:Java throws Exception when log is output", e);
        }
    }

    @OnlyInLog
    private static void outputFile(Optilog instance, String s) {
        try {
            synchronized (Send.INSTANCE) {
                Files.writeString(Path.of(instance.error), Files.readString(Path.of(instance.error), StandardCharsets.UTF_8) + s, StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            instance.consoleFileMasterCaution = false;
            instance.error("Optilog Note:Java throws Exception when log is output", e);
        }
    }

    @OnlyInLog
    void loggerToServer(LogEvent le, final Optilog instance) {
        synchronized (Send.INSTANCE) {
            le.message = Packing.packMessage(le.message, le.level.getName(), instance);
            String finalMessage = le.message;
            if (le.marker != LogMark.NONE) {
                Client.logAppender(finalMessage + le.marker.getName(), instance);
            } else {
                Client.logAppender(finalMessage + le.level.getName(), instance);
            }
        }
    }

    @OnlyInLog
    void loggerToJdbc(LogEvent le, final Optilog instance) {
        MySQL.logAppender(le, Thread.currentThread().getStackTrace()[4].getClassName(), Packing.packMessage(le.message, le.level.getName(), instance), instance);
    }
}
