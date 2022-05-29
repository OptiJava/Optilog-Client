package com.optilog.setting;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.optilog.log.Optilog;
import com.optilog.util.OnlyInInit;
import com.optilog.util.Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class XmlSettings {
    @OnlyInInit
    static void xml(String path, boolean isClasspath, Optilog instance) {
        if (isClasspath) {
            try (InputStream input = Optilog.class.getResourceAsStream(path)) {
                if (input == null) {
                    instance.consoleFileMasterCaution = false;
                    Util.getOutput().println("Optilog Note: Can't find " + path + "in classpath.");
                    return;
                }
                Settings object = new XmlMapper(new JacksonXmlModule()).readValue(input, Settings.class);
                
                if (instance.allSetting == null) {
                    instance.allSetting = new SettingFiles();
                }
                
                if (object.defaultConsolePath != null) {
                    instance.allSetting.defaultConsolePath = object.defaultConsolePath.trim();
                }
                if (object.Path1 != null) {
                    instance.allSetting.Path1 = object.Path1.trim();
                }
                if (object.Path2 != null) {
                    instance.allSetting.Path2 = object.Path2.trim();
                }
                if (object.Path3 != null) {
                    instance.allSetting.Path3 = object.Path3.trim();
                }
                if (object.Path4 != null) {
                    instance.allSetting.Path4 = object.Path4.trim();
                }
                if (object.Path5 != null) {
                    instance.allSetting.Path5 = object.Path5.trim();
                }
                if (object.infoPath != null) {
                    instance.allSetting.infoPath = object.infoPath.trim();
                }
                if (object.errorPath != null) {
                    instance.allSetting.errorPath = object.errorPath.trim();
                }
                if (object.warnPath != null) {
                    instance.allSetting.warnPath = object.warnPath.trim();
                }
                if (object.debugPath != null) {
                    instance.allSetting.debugPath = object.debugPath.trim();
                }
                if (object.fatalPath != null) {
                    instance.allSetting.fatalPath = object.fatalPath.trim();
                }
                
                instance.allSetting.printDebug = object.printDebug;
                instance.allSetting.printInfo = object.printInfo;
                instance.allSetting.printError = object.printError;
                instance.allSetting.printWarn = object.printWarn;
                instance.allSetting.printFatal = object.printFatal;
                instance.allSetting.consoleError = object.consoleError;
                instance.allSetting.consoleDebug = object.consoleDebug;
                instance.allSetting.consoleInfo = object.consoleInfo;
                instance.allSetting.consoleWarn = object.consoleWarn;
                instance.allSetting.consoleFatal = object.consoleFatal;
                instance.allSetting.serverInfo = object.infoSendToServer;
                instance.allSetting.serverError = object.errorSendToServer;
                instance.allSetting.serverDebug = object.debugSendToServer;
                instance.allSetting.serverWarn = object.warnSendToServer;
                instance.allSetting.serverFatal = object.fatalSendToServer;
                instance.allSetting.startClient = object.startClient;
                
                if (object.host != null) {
                    instance.allSetting.host = object.host.trim();
                }
                if (object.fileName != null) {
                    instance.allSetting.fileName = object.fileName.trim();
                }
                if (object.socketNumber != 0) {
                    instance.allSetting.socketNumber = object.socketNumber;
                }
                if (object.packingFormat != null) {
                    instance.allSetting.packingFormat = object.packingFormat.trim();
                }
            } catch (IOException e) {
                Util.getOutput().println("Optilog Note: Failed to read xml setting file!");
                e.printStackTrace();
            }
        } else {
            try (InputStream input = new FileInputStream(path)) {
                Settings object = new XmlMapper(new JacksonXmlModule()).readValue(input, Settings.class);
                if (instance.allSetting == null) {
                    instance.allSetting = new SettingFiles();
                }
                
                if (object.defaultConsolePath != null) {
                    instance.allSetting.defaultConsolePath = object.defaultConsolePath.trim();
                }
                if (object.Path1 != null) {
                    instance.allSetting.Path1 = object.Path1.trim();
                }
                if (object.Path2 != null) {
                    instance.allSetting.Path2 = object.Path2.trim();
                }
                if (object.Path3 != null) {
                    instance.allSetting.Path3 = object.Path3.trim();
                }
                if (object.Path4 != null) {
                    instance.allSetting.Path4 = object.Path4.trim();
                }
                if (object.Path5 != null) {
                    instance.allSetting.Path5 = object.Path5.trim();
                }
                if (object.infoPath != null) {
                    instance.allSetting.infoPath = object.infoPath.trim();
                }
                if (object.errorPath != null) {
                    instance.allSetting.errorPath = object.errorPath.trim();
                }
                if (object.warnPath != null) {
                    instance.allSetting.warnPath = object.warnPath.trim();
                }
                if (object.debugPath != null) {
                    instance.allSetting.debugPath = object.debugPath.trim();
                }
                if (object.fatalPath != null) {
                    instance.allSetting.fatalPath = object.fatalPath.trim();
                }
                
                instance.allSetting.printDebug = object.printDebug;
                instance.allSetting.printInfo = object.printInfo;
                instance.allSetting.printError = object.printError;
                instance.allSetting.printWarn = object.printWarn;
                instance.allSetting.printFatal = object.printFatal;
                instance.allSetting.consoleError = object.consoleError;
                instance.allSetting.consoleDebug = object.consoleDebug;
                instance.allSetting.consoleInfo = object.consoleInfo;
                instance.allSetting.consoleWarn = object.consoleWarn;
                instance.allSetting.consoleFatal = object.consoleFatal;
                instance.allSetting.serverInfo = object.infoSendToServer;
                instance.allSetting.serverError = object.errorSendToServer;
                instance.allSetting.serverDebug = object.debugSendToServer;
                instance.allSetting.serverWarn = object.warnSendToServer;
                instance.allSetting.serverFatal = object.fatalSendToServer;
                instance.allSetting.startClient = object.startClient;
                
                if (object.host != null) {
                    instance.allSetting.host = object.host.trim();
                }
                if (object.fileName != null) {
                    instance.allSetting.fileName = object.fileName.trim();
                }
                if (object.socketNumber != 0) {
                    instance.allSetting.socketNumber = object.socketNumber;
                }
                if (object.packingFormat != null) {
                    instance.allSetting.packingFormat = object.packingFormat.trim();
                }
            } catch (IOException e) {
                Util.getOutput().println("Optilog Note: Failed to read xml setting file!");
                e.printStackTrace();
            }
        }
    }
}
