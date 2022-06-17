package com.optilog.log;

import com.optilog.log.client.Client;
import com.optilog.log.console.ZipLog;
import com.optilog.util.OnlyInLog;
import com.optilog.util.exception.InvalidCommandException;

public class Logger {
    private Logger() {
    }

    @OnlyInLog
    static void logInfo(LogEvent le, Optilog instance) {
        if (instance.allSetting.printInfo) {
            Send.loggerPrint(le, instance);
        }

        if (instance.consoleFileMasterCaution & instance.allSetting.consoleInfo) {
            Send.loggerConsole(le, instance);
        }

        if (instance.consoleFileMasterCaution & instance.allSetting.serverInfo & instance.allSetting.startClient) {
            Send.loggerToServer(le, instance);
        }

        if (instance.connection.sendToJdbc) {
            Send.loggerToJdbc(le, instance);
        }
    }

    @OnlyInLog
    static void logError(LogEvent le, Optilog instance) {

        if (instance.allSetting.printError) {
            Send.loggerPrint(le, instance);
        }

        if (instance.consoleFileMasterCaution & instance.allSetting.consoleError) {
            Send.loggerConsole(le, instance);
        }

        if (instance.consoleFileMasterCaution & instance.allSetting.serverError & instance.allSetting.startClient) {
            Send.loggerToServer(le, instance);
        }

        if (instance.connection.sendToJdbc) {
            Send.loggerToJdbc(le, instance);
        }
    }

    @OnlyInLog
    static void logWarn(LogEvent le, Optilog instance) {

        if (instance.allSetting.printWarn) {
            Send.loggerPrint(le, instance);
        }

        if (instance.consoleFileMasterCaution & instance.allSetting.consoleWarn) {
            Send.loggerConsole(le, instance);
        }

        if (instance.consoleFileMasterCaution & instance.allSetting.serverWarn & instance.allSetting.startClient) {
            Send.loggerToServer(le, instance);
        }

        if (instance.connection.sendToJdbc) {
            Send.loggerToJdbc(le, instance);
        }
    }

    @OnlyInLog
    static void logDebug(LogEvent le, Optilog instance) {

        if (instance.allSetting.printDebug) {
            Send.loggerPrint(le, instance);
        }

        if (instance.consoleFileMasterCaution & instance.allSetting.consoleDebug) {
            Send.loggerConsole(le, instance);
        }

        if (instance.consoleFileMasterCaution & instance.allSetting.serverDebug & instance.allSetting.startClient) {
            Send.loggerToServer(le, instance);
        }

        if (instance.connection.sendToJdbc) {
            Send.loggerToJdbc(le, instance);
        }
    }

    @OnlyInLog
    static void logFatal(LogEvent le, Optilog instance) {

        if (instance.allSetting.printFatal) {
            Send.loggerPrint(le, instance);
        }

        if (instance.consoleFileMasterCaution & instance.allSetting.consoleFatal) {
            Send.loggerConsole(le, instance);
        }

        if (instance.consoleFileMasterCaution & instance.allSetting.serverFatal & instance.allSetting.startClient) {
            Send.loggerToServer(le, instance);
        }

        if (instance.connection.sendToJdbc) {
            Send.loggerToJdbc(le, instance);
        }
    }

    @OnlyInLog
    static void logCommand(String command, Optilog instance) {
        if (command.equals("%stop -client")) {
            Client.stop(instance);
        } else if (command.startsWith("%zip -d")) {
            ZipLog.zipAllLog(true, instance, command.substring(8));
        } else if (command.startsWith("%zip")) {
            ZipLog.zipAllLog(false, instance, command.substring(5));
        } else {
            try {
                throw new InvalidCommandException("Invalid Command '" + command + "' ", new IllegalArgumentException());
            } catch (RuntimeException e) {
                instance.error("Optilog Note:Invalid command ' " + command + " '", e);
            }
        }
    }
}
