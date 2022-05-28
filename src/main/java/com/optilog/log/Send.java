package com.optilog.log;

import com.optilog.log.client.Client;
import com.optilog.util.OnlyInLog;
import com.optilog.util.Util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Send {
    final static Send INSTANCE = new Send();
    
    @OnlyInLog
    void loggerPrint(String level, String message, Optilog instance) {
        synchronized (Send.INSTANCE) {
            Util.getOutput().print(Packing.packMessage(message, level, instance));
        }
    }
    
    @OnlyInLog
    void loggerConsole(String level, String message, Optilog instance, LogMarker marker) {
        String s = Packing.packMessage(message, level, instance);
        try {
            new Thread(() -> {
                if (instance.consoleFileMasterCaution & Level.INFO.getName().equals(level) & !instance.info.isBlank()) {
                    //String s = Packing.packMessage(message, level, instance);
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
                if (instance.consoleFileMasterCaution & Level.ERROR.getName().equals(level) & !instance.error.isBlank()) {
                    //String s = Packing.packMessage(message, level, instance);
                    try {
                        synchronized (Send.INSTANCE) {
                            Files.writeString(Path.of(instance.error), Files.readString(Path.of(instance.error), StandardCharsets.UTF_8) + s, StandardCharsets.UTF_8);
                        }
                    } catch (IOException e) {
                        instance.consoleFileMasterCaution = false;
                        instance.error("Optilog Note:Java throws Exception when log is output", e);
                    }
                    return;
                }
                if (instance.consoleFileMasterCaution & Level.DEBUG.getName().equals(level) & !instance.debug.isBlank()) {
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
                if (instance.consoleFileMasterCaution & Level.WARN.getName().equals(level) & !instance.warn.isBlank()) {
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
                if (instance.consoleFileMasterCaution & Level.FATAL.getName().equals(level) & !instance.fatal.isBlank()) {
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
                    if (marker == LogMarker.TEMPLATEInfo) {
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
                    
                    if (marker == LogMarker.TEMPLATEError) {
                        try {
                            synchronized (Send.INSTANCE) {
                                Files.writeString(Path.of(instance.error), Files.readString(Path.of(instance.error), StandardCharsets.UTF_8) + s, StandardCharsets.UTF_8);
                            }
                        } catch (IOException e) {
                            instance.consoleFileMasterCaution = false;
                            instance.error("Optilog Note:Java throws Exception when log is output", e);
                        }
                        return;
                    }
                    
                    if (marker == LogMarker.TEMPLATEWarn) {
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
                    
                    if (marker == LogMarker.TEMPLATEDebug) {
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
                    
                    if (marker == LogMarker.TEMPLATEFatal) {
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
            }).start();
        } catch (Exception e) {
            instance.consoleFileMasterCaution = false;
            instance.error("Optilog Note:Java throws Exception when log is output", e);
        }
    }
    
    @OnlyInLog
    void loggerToServer(final String level, String message, final Optilog instance) {
        synchronized (Send.INSTANCE) {
            message = Packing.packMessage(message, level, instance);
            String finalMessage = message;
            new Thread(() -> Client.logAppender(finalMessage + level, instance)).start();
        }
    }
}
