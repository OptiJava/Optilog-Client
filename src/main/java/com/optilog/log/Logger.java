package com.optilog.log;

import com.optilog.log.client.Client;
import com.optilog.log.console.ZipLog;
import com.optilog.util.OnlyInLog;
import com.optilog.util.exception.InvalidCommandException;

public class Logger {
    private Logger() {
    }

    static final Logger INSTANCE = new Logger();

    @OnlyInLog
    void logInfo(LogEvent le, Optilog instance) {
        instance.logState.allLogCount++;
        instance.logState.infoLogCount++;

        synchronized (this) {
            le.message = instance.baaLog.getInfoBefore() + le.message + instance.baaLog.getInfoAfter();
        }

        if (instance.allSetting.printInfo) {
            Send.INSTANCE.loggerPrint(le, instance);
        }

        if (instance.consoleFileMasterCaution & instance.allSetting.consoleInfo) {
            Send.INSTANCE.loggerConsole(le, instance);
        }

        if (instance.consoleFileMasterCaution & instance.allSetting.serverInfo & instance.allSetting.startClient) {
            Send.INSTANCE.loggerToServer(le, instance);
        }

        if (instance.connection.sendToJdbc) {
            Send.INSTANCE.loggerToJdbc(le, instance);
        }
    }

    @OnlyInLog
    void logError(LogEvent le, Optilog instance) {
        instance.logState.allLogCount++;
        instance.logState.errorLogCount++;

        synchronized (this) {
            le.message = instance.baaLog.getErrorBefore() + le.message + instance.baaLog.getErrorAfter();
        }

        if (instance.allSetting.printError) {
            Send.INSTANCE.loggerPrint(le, instance);
        }

        if (instance.consoleFileMasterCaution & instance.allSetting.consoleError) {
            Send.INSTANCE.loggerConsole(le, instance);
        }

        if (instance.consoleFileMasterCaution & instance.allSetting.serverError & instance.allSetting.startClient) {
            Send.INSTANCE.loggerToServer(le, instance);
        }

        if (instance.connection.sendToJdbc) {
            Send.INSTANCE.loggerToJdbc(le, instance);
        }
    }

    @OnlyInLog
    void logWarn(LogEvent le, Optilog instance) {
        instance.logState.allLogCount++;
        instance.logState.warnLogCount++;

        synchronized (this) {
            le.message = instance.baaLog.getWarnBefore() + le.message + instance.baaLog.getWarnAfter();
        }

        if (instance.allSetting.printWarn) {
            Send.INSTANCE.loggerPrint(le, instance);
        }

        if (instance.consoleFileMasterCaution & instance.allSetting.consoleWarn) {
            Send.INSTANCE.loggerConsole(le, instance);
        }

        if (instance.consoleFileMasterCaution & instance.allSetting.serverWarn & instance.allSetting.startClient) {
            Send.INSTANCE.loggerToServer(le, instance);
        }

        if (instance.connection.sendToJdbc) {
            Send.INSTANCE.loggerToJdbc(le, instance);
        }
    }

    @OnlyInLog
    void logDebug(LogEvent le, Optilog instance) {
        instance.logState.allLogCount++;
        instance.logState.debugLogCount++;

        synchronized (this) {
            le.message = instance.baaLog.getDebugBefore() + le.message + instance.baaLog.getDebugAfter();
        }

        if (instance.allSetting.printDebug) {
            Send.INSTANCE.loggerPrint(le, instance);
        }

        if (instance.consoleFileMasterCaution & instance.allSetting.consoleDebug) {
            Send.INSTANCE.loggerConsole(le, instance);
        }

        if (instance.consoleFileMasterCaution & instance.allSetting.serverDebug & instance.allSetting.startClient) {
            Send.INSTANCE.loggerToServer(le, instance);
        }

        if (instance.connection.sendToJdbc) {
            Send.INSTANCE.loggerToJdbc(le, instance);
        }
    }

    @OnlyInLog
    void logFatal(LogEvent le, Optilog instance) {
        instance.logState.allLogCount++;
        instance.logState.fatalLogCount++;

        synchronized (this) {
            le.message = instance.baaLog.getFatalBefore() + le.message + instance.baaLog.getFatalAfter();
        }

        if (instance.allSetting.printFatal) {
            Send.INSTANCE.loggerPrint(le, instance);
        }

        if (instance.consoleFileMasterCaution & instance.allSetting.consoleFatal) {
            Send.INSTANCE.loggerConsole(le, instance);
        }

        if (instance.consoleFileMasterCaution & instance.allSetting.serverFatal & instance.allSetting.startClient) {
            Send.INSTANCE.loggerToServer(le, instance);
        }

        if (instance.connection.sendToJdbc) {
            Send.INSTANCE.loggerToJdbc(le, instance);
        }
    }

    @OnlyInLog
    static void logCommand(String command, Optilog instance) {
        instance.logState.commandCount++;
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
