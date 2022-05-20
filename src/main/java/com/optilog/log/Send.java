package com.optilog.log;

import com.optilog.log.client.Client;
import com.optilog.util.Util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Send {
    public final static Send INSTANCE = new Send();
    
    void loggerPrint(String level, String message, Optilog instance) {
        synchronized (this) {
            Util.getOutput().print(Packing.packMessage(message, level, instance));
        }
    }
    
    void loggerConsole(String level, String message, Optilog instance) {
        try {
            if (Level.INFO.getName().equals(level)) {
                instance.info.write(Packing.packMessage(message, level, instance).getBytes(StandardCharsets.UTF_8));
                instance.info.flush();
            }
            if (Level.ERROR.getName().equals(level)) {
                instance.error.write(Packing.packMessage(message, level, instance).getBytes(StandardCharsets.UTF_8));
                instance.error.flush();
            }
            if (Level.DEBUG.getName().equals(level)) {
                instance.debug.write(Packing.packMessage(message, level, instance).getBytes(StandardCharsets.UTF_8));
                instance.debug.flush();
            }
            if (Level.WARN.getName().equals(level)) {
                instance.warn.write(Packing.packMessage(message, level, instance).getBytes(StandardCharsets.UTF_8));
                instance.warn.flush();
            }
            if (Level.FATAL.getName().equals(level)) {
                instance.fatal.write(Packing.packMessage(message, level, instance).getBytes(StandardCharsets.UTF_8));
                instance.fatal.flush();
            }
        } catch (RuntimeException | IOException e) {
            Util.getOutput().println("Optilog Note:Java throws Exception when log is written");
            e.printStackTrace();
        }
    }
    
    void loggerToServer(String level, String message, Optilog instance) {
        message = Packing.packMessage(message, level, instance);
        Client.send(message + level, instance);
    }
}
