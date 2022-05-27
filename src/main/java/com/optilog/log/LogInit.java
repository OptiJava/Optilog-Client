package com.optilog.log;

import com.optilog.log.client.Client;
import com.optilog.log.console.Console;
import com.optilog.setting.SettingFiles;
import com.optilog.util.OnlyInInit;
import com.optilog.util.Util;
import com.optilog.util.exception.GsonNotFoundException;
import com.optilog.util.exception.OptilogException;

import java.io.IOException;
import java.util.concurrent.Executors;

public class LogInit {
    @OnlyInInit
    public static void initLog(String settingFilePath, Optilog instance) {
        instance.logThread = Executors.newCachedThreadPool();
        if (settingFilePath.isBlank()) {
            instance.consoleFileMasterCaution = false;
            instance.allSetting = new SettingFiles();
        }
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
            if (instance.consoleFileMasterCaution) {
                Console.file(instance);
                Client.startClient(instance);
            }
        } catch (RuntimeException | IOException e) {
            Util.getOutput().println("Optilog Note:An Exception was thrown when Optilog init logger");
            e.printStackTrace();
            throw new OptilogException("An Exception was thrown when Optilog init logger", e);
        }
    }
}
