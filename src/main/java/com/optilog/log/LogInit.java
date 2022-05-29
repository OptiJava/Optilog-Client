package com.optilog.log;

import com.optilog.log.client.Client;
import com.optilog.log.console.Console;
import com.optilog.setting.JsonSettings;
import com.optilog.util.OnlyInInit;
import com.optilog.util.Util;
import com.optilog.util.exception.OptilogException;

import java.io.IOException;

public class LogInit {
    @OnlyInInit
    public static void initLog(String settingFilePath, Optilog instance) {
        if (settingFilePath.isBlank()) {
            instance.consoleFileMasterCaution = false;
            instance.allSetting = new JsonSettings();
        }
        
        try {
            JsonSettings.check(settingFilePath, instance);
            if (instance.consoleFileMasterCaution) {
                Console.initAppender(instance);
                Client.initAppender(instance);
            }
        } catch (RuntimeException | IOException e) {
            Util.getOutput().println("Optilog Note:An Exception was thrown when Optilog init logger");
            throw new OptilogException("An Exception was thrown when Optilog init logger", e);
        }
    }
}
