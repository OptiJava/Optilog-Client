package com.optilog.setting;

import com.google.gson.Gson;
import com.optilog.log.Optilog;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonSettings {
    public static void getJsonSettings(String path, boolean isClasspath, Optilog instance) {
        if (isClasspath && (!path.startsWith("/") && !path.startsWith("\\"))) {
            path = File.separator + path;
        }
        try {
            if (!isClasspath) {
                JsonSettingBean bean = new Gson().fromJson(Files.readString(Path.of(path), StandardCharsets.UTF_8), JsonSettingBean.class);
                parseSettings(instance, bean);
            } else {
                JsonSettingBean bean;
                try (InputStream inputStream = Optilog.class.getResourceAsStream(path)) {
                    if (inputStream == null) {
                        System.err.println("Optilog Note: Can't find file in classpath(" + path + ")");
                        instance.consoleFileMasterCaution = false;
                        return;
                    }
                    bean = new Gson().fromJson(SettingFiles.readAsString(inputStream), JsonSettingBean.class);
                }

                parseSettings(instance, bean);
            }
        } catch (IOException e) {
            e.printStackTrace();
            instance.consoleFileMasterCaution = false;
        }
    }

    private static void parseSettings(Optilog instance, JsonSettingBean bean) {
        final String INFO = "info";
        final String ERROR = "error";
        final String WARN = "warn";
        final String DEBUG = "debug";
        final String FATAL = "fatal";

        final String PACKING_FORMAT = "packingFormat";

        try {
            instance.allSetting.printInfo = Boolean.parseBoolean(bean.print.get(INFO));
            instance.allSetting.printError = Boolean.parseBoolean(bean.print.get(ERROR));
            instance.allSetting.printWarn = Boolean.parseBoolean(bean.print.get(WARN));
            instance.allSetting.printDebug = Boolean.parseBoolean(bean.print.get(DEBUG));
            instance.allSetting.printFatal = Boolean.parseBoolean(bean.print.get(FATAL));
            String a = bean.print.get(PACKING_FORMAT);
            if (a != null) {
                instance.allSetting.defaultConsolePath = a.trim();
            }
        } catch (NullPointerException ignored) {
        }

        // file
        try {
            instance.allSetting.consoleInfo = Boolean.parseBoolean(bean.file.get(INFO));
            instance.allSetting.consoleError = Boolean.parseBoolean(bean.file.get(ERROR));
            instance.allSetting.consoleWarn = Boolean.parseBoolean(bean.file.get(WARN));
            instance.allSetting.consoleDebug = Boolean.parseBoolean(bean.file.get(DEBUG));
            instance.allSetting.consoleFatal = Boolean.parseBoolean(bean.file.get(FATAL));
            String b = bean.file.get("defaultConsolePath");
            if (b != null) {
                instance.allSetting.defaultConsolePath = b.trim();
            }
            String c1 = bean.file.get("Path1");
            if (c1 != null) {
                instance.allSetting.Path1 = c1.trim();
            }
            String c2 = bean.file.get("Path2");
            if (c2 != null) {
                instance.allSetting.Path1 = c2.trim();
            }
            String c3 = bean.file.get("Path3");
            if (c3 != null) {
                instance.allSetting.Path1 = c3.trim();
            }
            String c4 = bean.file.get("Path4");
            if (c4 != null) {
                instance.allSetting.Path1 = c4.trim();
            }
            String c5 = bean.file.get("Path5");
            if (c5 != null) {
                instance.allSetting.Path1 = c5.trim();
            }
            String di = bean.file.get("infoPath");
            if (di != null) {
                instance.allSetting.infoPath = di.trim();
            }
            String de = bean.file.get("errorPath");
            if (de != null) {
                instance.allSetting.errorPath = de.trim();
            }
            String dw = bean.file.get("warnPath");
            if (dw != null) {
                instance.allSetting.warnPath = dw.trim();
            }
            String dd = bean.file.get("debugPath");
            if (dd != null) {
                instance.allSetting.debugPath = dd.trim();
            }
            String df = bean.file.get("fatalPath");
            if (df != null) {
                instance.allSetting.fatalPath = df.trim();
            }
            String e = bean.file.get("fileName");
            if (e != null) {
                instance.allSetting.fileName = e.trim();
            }
            String f = bean.file.get(PACKING_FORMAT);
            if (f != null) {
                instance.allSetting.consolePackingFormat = f;
            }
        } catch (NullPointerException ignored) {
        }

        // server
        try {
            instance.allSetting.serverInfo = Boolean.parseBoolean(bean.server.get(INFO));
            instance.allSetting.serverError = Boolean.parseBoolean(bean.server.get(ERROR));
            instance.allSetting.serverWarn = Boolean.parseBoolean(bean.server.get(WARN));
            instance.allSetting.serverDebug = Boolean.parseBoolean(bean.server.get(DEBUG));
            instance.allSetting.serverFatal = Boolean.parseBoolean(bean.server.get(FATAL));

            instance.allSetting.startClient = Boolean.parseBoolean(bean.server.get("startClient"));
            String a = bean.server.get("socketNumber");
            if (a != null) {
                instance.allSetting.socketNumber = Integer.parseInt(a.trim());
            }
            String b = bean.server.get("host");
            if (b != null) {
                instance.allSetting.host = b.trim();
            }
            String c = bean.server.get(PACKING_FORMAT);
            if (c != null) {
                instance.allSetting.serverPackingFormat = c;
            }
            String d = bean.server.get("forceDisableSocketWhenException");
            if (d != null) {
                instance.allSetting.forceDisableSocketWhenException = Boolean.parseBoolean(d);
            }
        } catch (NullPointerException ignored) {
        }
    }
}
