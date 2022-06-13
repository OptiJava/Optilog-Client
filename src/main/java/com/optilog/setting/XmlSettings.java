package com.optilog.setting;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.optilog.log.Optilog;
import com.optilog.util.OnlyInInit;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class XmlSettings {
    /**
     * Parse XML file to JavaBean use Jackson-fasterxml
     */
    @OnlyInInit
    static void xml(String path, boolean isClasspath, Optilog instance) {
        if (isClasspath) {
            // read in classpath
            try (InputStream input = Optilog.class.getResourceAsStream(path)) {
                // if file is not exists(input is null),make consoleFileMasterCaution false
                if (input == null) {
                    instance.consoleFileMasterCaution = false;
                    System.err.println("Optilog Note: Can't find " + path + "in classpath.");
                    return;
                }
                // load parser
                Settings object = new XmlMapper(new JacksonXmlModule()).readValue(input, Settings.class);

                // config print
                if (object.print.get("packingFormat") != null) {
                    instance.allSetting.printPackingFormat = object.print.get("packingFormat").trim();
                }
                instance.allSetting.printInfo = Boolean.parseBoolean(object.print.get("printInfo").trim());
                instance.allSetting.printError = Boolean.parseBoolean(object.print.get("printError").trim());
                instance.allSetting.printWarn = Boolean.parseBoolean(object.print.get("printWarn").trim());
                instance.allSetting.printDebug = Boolean.parseBoolean(object.print.get("printDebug").trim());
                instance.allSetting.printFatal = Boolean.parseBoolean(object.print.get("printFatal").trim());

                // config file
                if (object.file.get("packingFormat") != null) {
                    instance.allSetting.consolePackingFormat = object.file.get("packingFormat").trim();
                }

                if (object.file.get("defaultConsolePath") != null) {
                    instance.allSetting.defaultConsolePath = object.file.get("defaultConsolePath").trim();
                }
                if (object.file.get("Path1") != null) {
                    instance.allSetting.Path1 = object.file.get("Path1");
                }
                if (object.file.get("Path2") != null) {
                    instance.allSetting.Path2 = object.file.get("Path2");
                }
                if (object.file.get("Path3") != null) {
                    instance.allSetting.Path3 = object.file.get("Path3");
                }
                if (object.file.get("Path4") != null) {
                    instance.allSetting.Path4 = object.file.get("Path4");
                }
                if (object.file.get("Path5") != null) {
                    instance.allSetting.Path5 = object.file.get("Path5");
                }
                if (object.file.get("infoPath") != null) {
                    instance.allSetting.infoPath = object.file.get("infoPath");
                }
                if (object.file.get("errorPath") != null) {
                    instance.allSetting.errorPath = object.file.get("errorPath");
                }
                if (object.file.get("warnPath") != null) {
                    instance.allSetting.warnPath = object.file.get("warnPath");
                }
                if (object.file.get("debugPath") != null) {
                    instance.allSetting.debugPath = object.file.get("debugPath");
                }
                if (object.file.get("fatalPath") != null) {
                    instance.allSetting.infoPath = object.file.get("fatalPath");
                }
                if (object.file.get("fileName") != null) {
                    instance.allSetting.fileName = object.file.get("fileName");
                }
                instance.allSetting.consoleInfo = Boolean.parseBoolean(object.file.get("consoleInfo").trim());
                instance.allSetting.consoleError = Boolean.parseBoolean(object.file.get("consoleError").trim());
                instance.allSetting.consoleWarn = Boolean.parseBoolean(object.file.get("consoleWarn").trim());
                instance.allSetting.consoleDebug = Boolean.parseBoolean(object.file.get("consoleDebug").trim());
                instance.allSetting.consoleFatal = Boolean.parseBoolean(object.file.get("consoleFatal").trim());

                // config server
                if (object.server.get("packingFormat") != null) {
                    instance.allSetting.serverPackingFormat = object.server.get("packingFormat").trim();
                }
                instance.allSetting.serverInfo = Boolean.parseBoolean(object.server.get("serverInfo").trim());
                instance.allSetting.serverError = Boolean.parseBoolean(object.server.get("serverError").trim());
                instance.allSetting.serverWarn = Boolean.parseBoolean(object.server.get("serverWarn").trim());
                instance.allSetting.serverDebug = Boolean.parseBoolean(object.server.get("serverDebug").trim());
                instance.allSetting.serverFatal = Boolean.parseBoolean(object.server.get("serverFatal").trim());
                instance.allSetting.startClient = Boolean.parseBoolean(object.server.get("startClient").trim());
                if (object.server.get("host") != null) {
                    instance.allSetting.host = object.server.get("host");
                }
                if (object.server.get("socketNumber") != null) {
                    instance.allSetting.socketNumber = Integer.parseInt(object.server.get("socketNumber"));
                }

            } catch (IOException e) {
                System.err.println("Optilog Note: Failed to read xml setting file!");
                instance.consoleFileMasterCaution = false;
                e.printStackTrace();
            }
        } else {
            try (InputStream input = new FileInputStream(path)) {
                Settings object = new XmlMapper(new JacksonXmlModule()).readValue(input, Settings.class);
                // config print
                if (object.print.get("packingFormat") != null) {
                    instance.allSetting.printPackingFormat = object.print.get("packingFormat").trim();
                }
                instance.allSetting.printInfo = Boolean.parseBoolean(object.print.get("printInfo").trim());
                instance.allSetting.printError = Boolean.parseBoolean(object.print.get("printError").trim());
                instance.allSetting.printWarn = Boolean.parseBoolean(object.print.get("printWarn").trim());
                instance.allSetting.printDebug = Boolean.parseBoolean(object.print.get("printDebug").trim());
                instance.allSetting.printFatal = Boolean.parseBoolean(object.print.get("printFatal").trim());

                // config file
                if (object.file.get("packingFormat") != null) {
                    instance.allSetting.consolePackingFormat = object.file.get("packingFormat").trim();
                }
                if (object.file.get("defaultConsolePath") != null) {
                    instance.allSetting.defaultConsolePath = object.file.get("defaultConsolePath").trim();
                }
                if (object.file.get("Path1") != null) {
                    instance.allSetting.Path1 = object.file.get("Path1");
                }
                if (object.file.get("Path2") != null) {
                    instance.allSetting.Path2 = object.file.get("Path2");
                }
                if (object.file.get("Path3") != null) {
                    instance.allSetting.Path3 = object.file.get("Path3");
                }
                if (object.file.get("Path4") != null) {
                    instance.allSetting.Path4 = object.file.get("Path4");
                }
                if (object.file.get("Path5") != null) {
                    instance.allSetting.Path5 = object.file.get("Path5");
                }
                if (object.file.get("infoPath") != null) {
                    instance.allSetting.infoPath = object.file.get("infoPath");
                }
                if (object.file.get("errorPath") != null) {
                    instance.allSetting.errorPath = object.file.get("errorPath");
                }
                if (object.file.get("warnPath") != null) {
                    instance.allSetting.warnPath = object.file.get("warnPath");
                }
                if (object.file.get("debugPath") != null) {
                    instance.allSetting.debugPath = object.file.get("debugPath");
                }
                if (object.file.get("fatalPath") != null) {
                    instance.allSetting.infoPath = object.file.get("fatalPath");
                }
                if (object.file.get("fileName") != null) {
                    instance.allSetting.fileName = object.file.get("fileName");
                }
                instance.allSetting.consoleInfo = Boolean.parseBoolean(object.file.get("consoleInfo").trim());
                instance.allSetting.consoleError = Boolean.parseBoolean(object.file.get("consoleError").trim());
                instance.allSetting.consoleWarn = Boolean.parseBoolean(object.file.get("consoleWarn").trim());
                instance.allSetting.consoleDebug = Boolean.parseBoolean(object.file.get("consoleDebug").trim());
                instance.allSetting.consoleFatal = Boolean.parseBoolean(object.file.get("consoleFatal").trim());

                // config server
                if (object.server.get("packingFormat") != null) {
                    instance.allSetting.serverPackingFormat = object.server.get("packingFormat").trim();
                }
                instance.allSetting.serverInfo = Boolean.parseBoolean(object.server.get("serverInfo").trim());
                instance.allSetting.serverError = Boolean.parseBoolean(object.server.get("serverError").trim());
                instance.allSetting.serverWarn = Boolean.parseBoolean(object.server.get("serverWarn").trim());
                instance.allSetting.serverDebug = Boolean.parseBoolean(object.server.get("serverDebug").trim());
                instance.allSetting.serverFatal = Boolean.parseBoolean(object.server.get("serverFatal").trim());
                instance.allSetting.startClient = Boolean.parseBoolean(object.server.get("startClient").trim());
                if (object.server.get("host") != null) {
                    instance.allSetting.host = object.server.get("host");
                }
                if (object.server.get("socketNumber") != null) {
                    instance.allSetting.socketNumber = Integer.parseInt(object.server.get("socketNumber"));
                }

            } catch (IOException e) {
                System.err.println("Optilog Note: Failed to read xml setting file!");
                e.printStackTrace();
            }
        }
    }
}
