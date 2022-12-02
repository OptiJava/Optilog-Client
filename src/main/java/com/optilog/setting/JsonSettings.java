package com.optilog.setting;

import com.google.gson.Gson;
import com.optilog.log.Optilog;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonSettings {
    public static void getJsonSettings(String path, boolean isClasspath, Optilog instance) {
        try {
            if (!isClasspath) {
                JsonSettingBean bean = new Gson().fromJson(Files.readString(Path.of(path), StandardCharsets.UTF_8), JsonSettingBean.class);
                // print
                try {
                    instance.allSetting.printInfo = Boolean.parseBoolean(bean.print.get("info"));
                    instance.allSetting.printError = Boolean.parseBoolean(bean.print.get("error"));
                    instance.allSetting.printWarn = Boolean.parseBoolean(bean.print.get("warn"));
                    instance.allSetting.printDebug = Boolean.parseBoolean(bean.print.get("debug"));
                    instance.allSetting.printFatal = Boolean.parseBoolean(bean.print.get("fatal"));
                    String a = bean.print.get("packingFormat");
                    if (a != null) {
                        instance.allSetting.defaultConsolePath = a.trim();
                    }
                } catch (NullPointerException ignored) {
                }

                // file
                try {
                    instance.allSetting.consoleInfo = Boolean.parseBoolean(bean.file.get("info"));
                    instance.allSetting.consoleError = Boolean.parseBoolean(bean.file.get("error"));
                    instance.allSetting.consoleWarn = Boolean.parseBoolean(bean.file.get("warn"));
                    instance.allSetting.consoleDebug = Boolean.parseBoolean(bean.file.get("debug"));
                    instance.allSetting.consoleFatal = Boolean.parseBoolean(bean.file.get("fatal"));
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
                    String f = bean.file.get("packingFormat");
                    if (f != null) {
                        instance.allSetting.consolePackingFormat = f;
                    }
                } catch (NullPointerException ignored) {
                }

                // server
                try {
                    instance.allSetting.serverInfo = Boolean.parseBoolean(bean.server.get("info"));
                    instance.allSetting.serverError = Boolean.parseBoolean(bean.server.get("error"));
                    instance.allSetting.serverWarn = Boolean.parseBoolean(bean.server.get("warn"));
                    instance.allSetting.serverDebug = Boolean.parseBoolean(bean.server.get("debug"));
                    instance.allSetting.serverFatal = Boolean.parseBoolean(bean.server.get("fatal"));

                    instance.allSetting.startClient = Boolean.parseBoolean(bean.server.get("startClient"));
                    String a = bean.server.get("socketNumber");
                    if (a != null) {
                        instance.allSetting.socketNumber = Integer.parseInt(a.trim());
                    }
                    String b = bean.server.get("host");
                    if (b != null) {
                        instance.allSetting.host = b.trim();
                    }
                    String c = bean.server.get("packingFormat");
                    if (c != null) {
                        instance.allSetting.serverPackingFormat = c;
                    }
                } catch (NullPointerException ignored) {
                }
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

                // print
                try {
                    instance.allSetting.printInfo = Boolean.parseBoolean(bean.print.get("info"));
                    instance.allSetting.printError = Boolean.parseBoolean(bean.print.get("error"));
                    instance.allSetting.printWarn = Boolean.parseBoolean(bean.print.get("warn"));
                    instance.allSetting.printDebug = Boolean.parseBoolean(bean.print.get("debug"));
                    instance.allSetting.printFatal = Boolean.parseBoolean(bean.print.get("fatal"));
                    String a = bean.print.get("packingFormat");
                    if (a != null) {
                        instance.allSetting.defaultConsolePath = a.trim();
                    }
                } catch (NullPointerException ignored) {
                }

                // file
                try {
                    instance.allSetting.consoleInfo = Boolean.parseBoolean(bean.file.get("info"));
                    instance.allSetting.consoleError = Boolean.parseBoolean(bean.file.get("error"));
                    instance.allSetting.consoleWarn = Boolean.parseBoolean(bean.file.get("warn"));
                    instance.allSetting.consoleDebug = Boolean.parseBoolean(bean.file.get("debug"));
                    instance.allSetting.consoleFatal = Boolean.parseBoolean(bean.file.get("fatal"));
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
                    String f = bean.file.get("packingFormat");
                    if (f != null) {
                        instance.allSetting.consolePackingFormat = f;
                    }
                } catch (NullPointerException ignored) {
                }

                // server
                try {
                    instance.allSetting.serverInfo = Boolean.parseBoolean(bean.server.get("info"));
                    instance.allSetting.serverError = Boolean.parseBoolean(bean.server.get("error"));
                    instance.allSetting.serverWarn = Boolean.parseBoolean(bean.server.get("warn"));
                    instance.allSetting.serverDebug = Boolean.parseBoolean(bean.server.get("debug"));
                    instance.allSetting.serverFatal = Boolean.parseBoolean(bean.server.get("fatal"));

                    instance.allSetting.startClient = Boolean.parseBoolean(bean.server.get("startClient"));
                    String a = bean.server.get("socketNumber");
                    if (a != null) {
                        instance.allSetting.socketNumber = Integer.parseInt(a.trim());
                    }
                    String b = bean.server.get("host");
                    if (b != null) {
                        instance.allSetting.host = b.trim();
                    }
                    String c = bean.server.get("packingFormat");
                    if (c != null) {
                        instance.allSetting.serverPackingFormat = c;
                    }
                } catch (NullPointerException ignored) {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            instance.consoleFileMasterCaution = false;
        }
    }
}
