package com.optilog.log;

import com.optilog.log.client.Client;
import com.optilog.util.Util;
import com.optilog.util.exception.InvalidCommandException;

public class Logger {
    static final Logger INSTANCE = new Logger();
    
    void logInfo(LogEvent le, Optilog instance) {
        if (!instance.alreadyInit) {
            LogInit.initLog(instance.settingFilePath, instance);
            instance.alreadyInit = true;
        }
        if (instance.allSetting.printInfo) {
            Send.INSTANCE.loggerPrint(le.level.getName(), le.message, instance);
        }
        
        if (instance.consoleFileMasterCaution && instance.allSetting.consoleInfo) {
            Send.INSTANCE.loggerConsole(le.level.getName(), le.message, instance);
        }
        
        if (instance.allSetting.serverInfo && instance.allSetting.startClient) {
            Send.INSTANCE.loggerToServer(le.level.getName(), le.message, instance);
        }
        
    }
    
    void logError(LogEvent le, Optilog instance) {
        if (!instance.alreadyInit) {
            LogInit.initLog(instance.settingFilePath, instance);
            instance.alreadyInit = true;
        }
        if (instance.allSetting.printError) {
            Send.INSTANCE.loggerPrint(le.level.getName(), le.message, instance);
        }
        
        if (instance.consoleFileMasterCaution && instance.allSetting.consoleError) {
            Send.INSTANCE.loggerConsole(le.level.getName(), le.message, instance);
        }
        
        if (instance.allSetting.serverError && instance.allSetting.startClient) {
            Send.INSTANCE.loggerToServer(le.level.getName(), le.message, instance);
        }
        
    }
    
    void logWarn(LogEvent le, Optilog instance) {
        if (!instance.alreadyInit) {
            LogInit.initLog(instance.settingFilePath, instance);
            instance.alreadyInit = true;
        }
        if (instance.allSetting.printWarn) {
            Send.INSTANCE.loggerPrint(le.level.getName(), le.message, instance);
        }
        
        if (instance.consoleFileMasterCaution && instance.allSetting.consoleWarn) {
            Send.INSTANCE.loggerConsole(le.level.getName(), le.message, instance);
        }
        
        if (instance.allSetting.serverWarn && instance.allSetting.startClient) {
            Send.INSTANCE.loggerToServer(le.level.getName(), le.message, instance);
        }
        
    }
    
    void logDebug(LogEvent le, Optilog instance) {
        if (!instance.alreadyInit) {
            LogInit.initLog(instance.settingFilePath, instance);
            instance.alreadyInit = true;
        }
        if (instance.allSetting.printDebug) {
            Send.INSTANCE.loggerPrint(le.level.getName(), le.message, instance);
        }
        
        if (instance.consoleFileMasterCaution && instance.allSetting.consoleDebug) {
            Send.INSTANCE.loggerConsole(le.level.getName(), le.message, instance);
        }
        
        if (instance.allSetting.serverDebug && instance.allSetting.startClient) {
            Send.INSTANCE.loggerToServer(le.level.getName(), le.message, instance);
        }
    }
    
    void logFatal(LogEvent le, Optilog instance) {
        if (!instance.alreadyInit) {
            LogInit.initLog(instance.settingFilePath, instance);
            instance.alreadyInit = true;
        }
        if (instance.allSetting.printFatal) {
            Send.INSTANCE.loggerPrint(le.level.getName(), le.message, instance);
        }
        
        if (instance.consoleFileMasterCaution && instance.allSetting.consoleFatal) {
            Send.INSTANCE.loggerConsole(le.level.getName(), le.message, instance);
        }
        
        if (instance.allSetting.serverFatal && instance.allSetting.startClient) {
            Send.INSTANCE.loggerToServer(le.level.getName(), le.message, instance);
        }
    }
    
    static void logCommand(String command, Optilog instance) {
        if (command.equals("%stop -client")) {
            Client.stop(instance);
        } else {
            try {
                throw new InvalidCommandException("Invalid Command '" + command + "' ", new IllegalArgumentException());
            } catch (RuntimeException e) {
                e.printStackTrace();
                Util.getOutput().println("Optilog Note:Invalid command ' " + command + " '");
            }
        }
    }
}
