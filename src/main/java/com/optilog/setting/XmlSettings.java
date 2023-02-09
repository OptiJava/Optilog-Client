package com.optilog.setting;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.optilog.log.Optilog;
import com.optilog.util.OnlyInInit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class XmlSettings {
    /**
     * Parse XML file to JavaBean use Jackson-fasterxml
     */
    @OnlyInInit
    static void xml(String path, boolean isClasspath, Optilog instance) {
        if (isClasspath && (!path.startsWith("/") && !path.startsWith("\\"))) {
            path = File.separator + path;
        }
        if (isClasspath) {
            // read in classpath
            try (InputStream input = Optilog.class.getResourceAsStream(path)) {
                parseSettings(instance, input);
            } catch (IOException e) {
                System.err.println("Optilog Note: Failed to read xml setting file!");
                instance.consoleFileMasterCaution = false;
                e.printStackTrace();
            }
        } else {
            try (InputStream input = new FileInputStream(path)) {
                parseSettings(instance, input);
            } catch (IOException e) {
                System.err.println("Optilog Note: Failed to read xml setting file!");
                instance.consoleFileMasterCaution = false;
                e.printStackTrace();
            }
        }
    }

    private static void parseSettings(Optilog instance, InputStream input) throws IOException {
        XmlSettingBean object = new XmlMapper(new JacksonXmlModule()).readValue(input, XmlSettingBean.class);
        try {
            // config print
            String a = object.print.get("packingFormat");
            if (a != null) {
                instance.allSetting.printPackingFormat = a.trim();
            }
            instance.allSetting.printInfo = Boolean.parseBoolean(object.print.get("printInfo").trim());
            instance.allSetting.printError = Boolean.parseBoolean(object.print.get("printError").trim());
            instance.allSetting.printWarn = Boolean.parseBoolean(object.print.get("printWarn").trim());
            instance.allSetting.printDebug = Boolean.parseBoolean(object.print.get("printDebug").trim());
            instance.allSetting.printFatal = Boolean.parseBoolean(object.print.get("printFatal").trim());
        } catch (NullPointerException ignored) {
        }

        try {
            // config file
            String b = object.file.get("packingFormat");
            if (b != null) {
                instance.allSetting.consolePackingFormat = b.trim();
            }
            String c = object.file.get("defaultConsolePath");
            if (c != null) {
                instance.allSetting.defaultConsolePath = c.trim();
            }
            String d = object.file.get("Path1");
            if (d != null) {
                instance.allSetting.Path1 = d.trim();
            }
            String e = object.file.get("Path2");
            if (e != null) {
                instance.allSetting.Path2 = e.trim();
            }
            String f = object.file.get("Path3");
            if (f != null) {
                instance.allSetting.Path3 = f.trim();
            }
            String g = object.file.get("Path4");
            if (g != null) {
                instance.allSetting.Path4 = g.trim();
            }
            String h = object.file.get("Path5");
            if (h != null) {
                instance.allSetting.Path5 = h.trim();
            }
            String i = object.file.get("infoPath");
            if (i != null) {
                instance.allSetting.infoPath = i.trim();
            }
            String j = object.file.get("errorPath");
            if (j != null) {
                instance.allSetting.errorPath = j.trim();
            }
            String k = object.file.get("warnPath");
            if (k != null) {
                instance.allSetting.warnPath = k.trim();
            }
            String l = object.file.get("debugPath");
            if (l != null) {
                instance.allSetting.debugPath = l.trim();
            }
            String m = object.file.get("fatalPath");
            if (m != null) {
                instance.allSetting.fatalPath = m.trim();
            }
            String n = (object.file.get("fileName"));
            if (n != null) {
                instance.allSetting.fileName = n.trim();
            }
            instance.allSetting.consoleInfo = Boolean.parseBoolean(object.file.get("consoleInfo").trim());
            instance.allSetting.consoleError = Boolean.parseBoolean(object.file.get("consoleError").trim());
            instance.allSetting.consoleWarn = Boolean.parseBoolean(object.file.get("consoleWarn").trim());
            instance.allSetting.consoleDebug = Boolean.parseBoolean(object.file.get("consoleDebug").trim());
            instance.allSetting.consoleFatal = Boolean.parseBoolean(object.file.get("consoleFatal").trim());
        } catch (NullPointerException ignored) {
        }

        try {
            // config server
            String o = object.server.get("packingFormat");
            if (o != null) {
                instance.allSetting.serverPackingFormat = o.trim();
            }
            instance.allSetting.serverInfo = Boolean.parseBoolean(object.server.get("serverInfo").trim());
            instance.allSetting.serverError = Boolean.parseBoolean(object.server.get("serverError").trim());
            instance.allSetting.serverWarn = Boolean.parseBoolean(object.server.get("serverWarn").trim());
            instance.allSetting.serverDebug = Boolean.parseBoolean(object.server.get("serverDebug").trim());
            instance.allSetting.serverFatal = Boolean.parseBoolean(object.server.get("serverFatal").trim());
            instance.allSetting.startClient = Boolean.parseBoolean(object.server.get("startClient").trim());
            String p = object.server.get("host");
            if (p != null) {
                instance.allSetting.host = p.trim();
            }
            String q = object.server.get("socketNumber");
            if (q != null) {
                try {
                    instance.allSetting.socketNumber = Integer.parseInt(q.trim());
                } catch (NumberFormatException e) {
                    System.err.println("Optilog Note: NumberFormatException");
                    e.printStackTrace();
                }
            }
            String r = object.server.get("forceDisableSocketWhenException");
            if (q != null) {
                try {
                    instance.allSetting.forceDisableSocketWhenException = Boolean.parseBoolean(r);
                } catch (NumberFormatException e) {
                    System.err.println("Optilog Note: NumberFormatException");
                    e.printStackTrace();
                }
            }
        } catch (NullPointerException ignored) {
        }
    }
}
