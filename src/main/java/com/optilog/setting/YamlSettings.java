package com.optilog.setting;

import com.optilog.log.Optilog;
import com.optilog.util.exception.ConfigureException;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class YamlSettings {
    public static void yaml(String path, boolean isClasspath, Optilog instance) {
        if (isClasspath && (!path.startsWith("/") && !path.startsWith("\\"))) {
            path = File.separator + path;
        }

        final String PRINT = "print";
        final String CONSOLE = "console";
        final String FILE = "file";
        final String SERVER = "server";
        final String PACKING_FORMAT = "packingFormat";

        Map<String, LinkedHashMap<String, String>> map;
        if (!isClasspath) {
            try (InputStream input = new FileInputStream(path)) {
                Yaml yaml = new Yaml();
                map = yaml.load(input);
            } catch (IOException e) {
                instance.consoleFileMasterCaution = false;
                throw new ConfigureException("Can't find'" + path + "'.", e);
            }

        } else {
            try (InputStream input = Optilog.class.getResourceAsStream(path)) {
                Yaml yaml = new Yaml();
                map = yaml.load(input);
            } catch (IOException e) {
                instance.consoleFileMasterCaution = false;
                throw new ConfigureException("Can't find'" + path + "'.", e);
            }
        }

        LinkedHashMap<String, String> lInfo = map.get("info");
        LinkedHashMap<String, String> lError = map.get("error");
        LinkedHashMap<String, String> lDebug = map.get("debug");
        LinkedHashMap<String, String> lFatal = map.get("fatal");
        LinkedHashMap<String, String> lWarn = map.get("warn");
        try {
            instance.allSetting.printInfo = Boolean.parseBoolean(lInfo.get(PRINT));
            instance.allSetting.printError = Boolean.parseBoolean(lError.get(PRINT));
            instance.allSetting.printWarn = Boolean.parseBoolean(lWarn.get(PRINT));
            instance.allSetting.printDebug = Boolean.parseBoolean(lDebug.get(PRINT));
            instance.allSetting.printFatal = Boolean.parseBoolean(lFatal.get(PRINT));
            String print$packingFormat = map.get(PRINT).get(PACKING_FORMAT);
            if (print$packingFormat != null) {
                instance.allSetting.printPackingFormat = print$packingFormat;
            }
        } catch (NullPointerException ignored) {
        }

        try {
            instance.allSetting.consoleInfo = Boolean.parseBoolean(lInfo.get(CONSOLE));
            instance.allSetting.consoleError = Boolean.parseBoolean(lError.get(CONSOLE));
            instance.allSetting.consoleDebug = Boolean.parseBoolean(lDebug.get(CONSOLE));
            instance.allSetting.consoleWarn = Boolean.parseBoolean(lWarn.get(CONSOLE));
            instance.allSetting.consoleFatal = Boolean.parseBoolean(lFatal.get(CONSOLE));
            String file$defaultConsolePath = map.get(FILE).get("defaultConsolePath");
            if (file$defaultConsolePath != null) {
                instance.allSetting.defaultConsolePath = file$defaultConsolePath;
            }
            String file$Path1 = map.get(FILE).get("Path1");
            if (file$Path1 != null) {
                instance.allSetting.Path1 = file$Path1;
            }
            String file$Path2 = map.get(FILE).get("Path2");
            if (file$Path2 != null) {
                instance.allSetting.Path2 = file$Path2;
            }
            String file$Path3 = map.get(FILE).get("Path3");
            if (file$Path3 != null) {
                instance.allSetting.Path3 = file$Path3;
            }
            String file$Path4 = map.get(FILE).get("Path4");
            if (file$Path4 != null) {
                instance.allSetting.Path4 = file$Path4;
            }
            String file$Path5 = map.get(FILE).get("Path5");
            if (file$Path5 != null) {
                instance.allSetting.Path5 = file$Path5;
            }
            String file$packingFormat = map.get(FILE).get(PACKING_FORMAT);
            if (file$packingFormat != null) {
                instance.allSetting.consolePackingFormat = file$packingFormat;
            }
            String file$infoPath = map.get(FILE).get("infoPath");
            if (file$infoPath != null) {
                instance.allSetting.infoPath = file$infoPath;
            }
            String file$errorPath = map.get(FILE).get("errorPath");
            if (file$errorPath != null) {
                instance.allSetting.errorPath = file$errorPath;
            }
            String file$warnPath = map.get(FILE).get("warnPath");
            if (file$warnPath != null) {
                instance.allSetting.warnPath = file$warnPath;
            }
            String file$debugPath = map.get(FILE).get("debugPath");
            if (file$debugPath != null) {
                instance.allSetting.debugPath = file$debugPath;
            }
            String file$fatalPath = map.get(FILE).get("fatalPath");
            if (file$fatalPath != null) {
                instance.allSetting.fatalPath = file$fatalPath;
            }
            String file$fileName = map.get(FILE).get("fileName");
            if (file$fileName != null) {
                instance.allSetting.fileName = file$fileName;
            }
        } catch (NullPointerException ignored) {
        }

        try {
            instance.allSetting.serverInfo = Boolean.parseBoolean(lInfo.get(SERVER));
            instance.allSetting.serverError = Boolean.parseBoolean(lError.get(SERVER));
            instance.allSetting.serverWarn = Boolean.parseBoolean(lWarn.get(SERVER));
            instance.allSetting.serverDebug = Boolean.parseBoolean(lDebug.get(SERVER));
            instance.allSetting.serverFatal = Boolean.parseBoolean(lFatal.get(SERVER));
            String server$packingFormat = map.get(SERVER).get(PACKING_FORMAT);
            if (server$packingFormat != null) {
                instance.allSetting.serverPackingFormat = server$packingFormat;
            }
            instance.allSetting.startClient = Boolean.parseBoolean(map.get(SERVER).get("startClient"));

            String server$host = map.get(SERVER).get("host");
            if (server$host != null) {
                instance.allSetting.host = server$host;
            }

            try {
                int server$socketNumber = Integer.parseInt(map.get(SERVER).get("socketNumber"));
                if (server$socketNumber != 0) {
                    instance.allSetting.socketNumber = server$socketNumber;
                }
            } catch (NullPointerException ignored) {
            }
            instance.allSetting.forceDisableSocketWhenException = Boolean.parseBoolean(map.get(SERVER).get("forceDisableSocketWhenException"));
        } catch (NullPointerException ignored) {
        }
    }
}
