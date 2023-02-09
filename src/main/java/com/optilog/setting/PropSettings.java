package com.optilog.setting;

import com.optilog.log.Optilog;
import com.optilog.util.OnlyInInit;
import com.optilog.util.Util;
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

            instance.allSetting.printInfo = Boolean.parseBoolean(p.getProperty("print.printInfo", Util.TRUE));
            instance.allSetting.printError = Boolean.parseBoolean(p.getProperty("print.printError", Util.TRUE));
            instance.allSetting.printWarn = Boolean.parseBoolean(p.getProperty("print.printWarn", Util.TRUE));
            instance.allSetting.printDebug = Boolean.parseBoolean(p.getProperty("print.printDebug", Util.TRUE));
            instance.allSetting.printFatal = Boolean.parseBoolean(p.getProperty("print.printFatal", Util.TRUE));

            instance.allSetting.consoleInfo = Boolean.parseBoolean(p.getProperty("file.consoleInfo", Util.FALSE));
            instance.allSetting.consoleError = Boolean.parseBoolean(p.getProperty("file.consoleError", Util.FALSE));
            instance.allSetting.consoleWarn = Boolean.parseBoolean(p.getProperty("file.consoleWarn", Util.FALSE));
            instance.allSetting.consoleDebug = Boolean.parseBoolean(p.getProperty("file.consoleDebug", Util.FALSE));
            instance.allSetting.consoleFatal = Boolean.parseBoolean(p.getProperty("file.consoleFatal", Util.FALSE));

            instance.allSetting.serverInfo = Boolean.parseBoolean(p.getProperty("server.infoSendToServer", Util.FALSE));
            instance.allSetting.serverError = Boolean.parseBoolean(p.getProperty("server.errorSendToServer", Util.FALSE));
            instance.allSetting.serverWarn = Boolean.parseBoolean(p.getProperty("server.warnSendToServer", Util.FALSE));
            instance.allSetting.serverDebug = Boolean.parseBoolean(p.getProperty("server.debugSendToServer", Util.FALSE));
            instance.allSetting.serverFatal = Boolean.parseBoolean(p.getProperty("server.fatalSendToServer", Util.FALSE));

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

            instance.allSetting.startClient = Boolean.parseBoolean(p.getProperty("server.startClient", Util.FALSE));

            instance.allSetting.printPackingFormat = p.getProperty("print.packingFormat", "[%yyyy-%MM-%dd|%HH:%mm:%ss(%SS)][%class %method(%file:%line)/%thread] %level:%msg");
            instance.allSetting.consolePackingFormat = p.getProperty("file.packingFormat", "[%yyyy-%MM-%dd|%HH:%mm:%ss(%SS)][%class %method(%file:%line)/%thread] %level:%msg");
            instance.allSetting.serverPackingFormat = p.getProperty("server.packingFormat", "[%yyyy-%MM-%dd|%HH:%mm:%ss(%SS)][%class %method(%file:%line)/%thread] %level:%msg");

            instance.allSetting.fileName = p.getProperty("file.fileName", "%time Log(Client).log");

            instance.allSetting.forceDisableSocketWhenException = Boolean.parseBoolean(p.getProperty("server.forceDisableSocketWhenException", Util.TRUE));

        } catch (IOException e) {
            System.err.println("Optilog Note: Read file failed.");
            throw new ConfigureException("Can't find file.", e);
        }
    }
}
