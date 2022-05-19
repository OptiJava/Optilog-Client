package com.optilog.log;

import com.optilog.log.client.Client;
import com.optilog.log.console.Console;
import com.optilog.setting.SettingFiles;
import com.optilog.util.Util;
import com.optilog.util.exception.GsonNotFoundException;

import java.io.IOException;

public class LogInit {
    protected static void initLog(String settingFilePath, Optilog instance) {
        try {
            Class.forName("com.google.gson.Gson");
        } catch (ClassNotFoundException e) {
            if (!settingFilePath.isBlank()) {
                Util.getOutput().println("Can't find Gson in classpath");
                throw new GsonNotFoundException("Can't found Gson in classpath", new ClassNotFoundException("Class:com.google.gson.Gson not found"));
            }
        }
        
        try {
            SettingFiles.check(settingFilePath, instance);
            Console.file(instance);
            Client.startClient(instance);
        } catch (RuntimeException | IOException e) {
            e.printStackTrace();
            Util.getOutput().println("Optilog Note:An Exception was thrown when Optilog init logger");
        }
    }
}
