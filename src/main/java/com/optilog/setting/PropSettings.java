package com.optilog.setting;

import com.optilog.log.Optilog;
import com.optilog.util.OnlyInInit;
import com.optilog.util.exception.ConfigureException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropSettings {
    @OnlyInInit
    static void properties(InputStream content, Optilog instance) {
        final Properties p = new Properties();
        try {
            p.load(content);

            instance.allSetting.printInfo = Boolean.parseBoolean(p.getProperty("print.printInfo", Boolean.TRUE.toString()));
            instance.allSetting.printError = Boolean.parseBoolean(p.getProperty("print.printError", Boolean.TRUE.toString()));
            instance.allSetting.printWarn = Boolean.parseBoolean(p.getProperty("print.printWarn", Boolean.TRUE.toString()));
            instance.allSetting.printDebug = Boolean.parseBoolean(p.getProperty("print.printDebug", Boolean.TRUE.toString()));
            instance.allSetting.printFatal = Boolean.parseBoolean(p.getProperty("print.printFatal", Boolean.TRUE.toString()));

            instance.allSetting.consoleInfo = Boolean.parseBoolean(p.getProperty("file.consoleInfo", Boolean.FALSE.toString()));
            instance.allSetting.consoleError = Boolean.parseBoolean(p.getProperty("file.consoleError", Boolean.FALSE.toString()));
            instance.allSetting.consoleWarn = Boolean.parseBoolean(p.getProperty("file.consoleWarn", Boolean.FALSE.toString()));
            instance.allSetting.consoleDebug = Boolean.parseBoolean(p.getProperty("file.consoleDebug", Boolean.FALSE.toString()));
            instance.allSetting.consoleFatal = Boolean.parseBoolean(p.getProperty("file.consoleFatal", Boolean.FALSE.toString()));

            instance.allSetting.serverInfo = Boolean.parseBoolean(p.getProperty("server.infoSendToServer", Boolean.FALSE.toString()));
            instance.allSetting.serverError = Boolean.parseBoolean(p.getProperty("server.errorSendToServer", Boolean.FALSE.toString()));
            instance.allSetting.serverWarn = Boolean.parseBoolean(p.getProperty("server.warnSendToServer", Boolean.FALSE.toString()));
            instance.allSetting.serverDebug = Boolean.parseBoolean(p.getProperty("server.debugSendToServer", Boolean.FALSE.toString()));
            instance.allSetting.serverFatal = Boolean.parseBoolean(p.getProperty("server.fatalSendToServer", Boolean.FALSE.toString()));

            instance.allSetting.defaultConsolePath = p.getProperty("file.defaultConsolePath", "");
            instance.allSetting.Path1 = p.getProperty("file.Path1", "");
            instance.allSetting.Path2 = p.getProperty("file.Path2", "");
            instance.allSetting.Path3 = p.getProperty("file.Path3", "");
            instance.allSetting.Path4 = p.getProperty("file.Path4", "");
            instance.allSetting.Path5 = p.getProperty("file.Path5", "");

            instance.allSetting.infoPath = p.getProperty("file.infoPath", "");
            instance.allSetting.errorPath = p.getProperty("file.errorPath", "");
            instance.allSetting.warnPath = p.getProperty("file.warnPath", "");
            instance.allSetting.debugPath = p.getProperty("file.debugPath", "");
            instance.allSetting.fatalPath = p.getProperty("file.fatalPath", "");

            instance.allSetting.host = p.getProperty("server.host", "localhost");

            instance.allSetting.startClient = Boolean.parseBoolean(p.getProperty("server.startClient", Boolean.FALSE.toString()));

            String var1 = "[%yyyy-%MM-%dd|%HH:%mm:%ss(%SS)][%class %method(%file:%line)/%thread] %level:%msg";

            instance.allSetting.printPackingFormat = p.getProperty("print.packingFormat", var1);
            instance.allSetting.consolePackingFormat = p.getProperty("file.packingFormat", var1);
            instance.allSetting.serverPackingFormat = p.getProperty("server.packingFormat", var1);

            instance.allSetting.fileName = p.getProperty("file.fileName", "%time Log(Client).log");

            instance.allSetting.forceDisableSocketWhenException = Boolean.parseBoolean(p.getProperty("server.forceDisableSocketWhenException", Boolean.TRUE.toString()));

        } catch (IOException e) {
            System.err.println("Optilog Note: Read file failed.");
            throw new ConfigureException("Can't find file.", e);
        }
    }
}
