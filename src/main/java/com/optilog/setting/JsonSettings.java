package com.optilog.setting;

import com.google.gson.Gson;
import com.optilog.log.Optilog;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonSettings {
    public static void getJsonSettings(String path, boolean isClasspath, Optilog instance) {
        try {
            if (!isClasspath) {
                JsonSettingBean bean = new Gson().fromJson(Files.readString(Path.of(path), StandardCharsets.UTF_8), JsonSettingBean.class);
                try {
                    instance.allSetting.printInfo = Boolean.parseBoolean(bean.print.get("info"));
                    instance.allSetting.printError = Boolean.parseBoolean(bean.print.get("error"));
                    instance.allSetting.printWarn = Boolean.parseBoolean(bean.print.get("warn"));
                    instance.allSetting.printDebug = Boolean.parseBoolean(bean.print.get("debug"));
                    instance.allSetting.printFatal = Boolean.parseBoolean(bean.print.get("fatal"));
                } catch (NullPointerException ignored) {
                }

                try {
                    instance.allSetting.consoleInfo = Boolean.parseBoolean(bean.file.get("info"));
                    instance.allSetting.consoleError = Boolean.parseBoolean(bean.file.get("error"));
                    instance.allSetting.consoleWarn = Boolean.parseBoolean(bean.file.get("warn"));
                    instance.allSetting.consoleDebug = Boolean.parseBoolean(bean.file.get("debug"));
                    instance.allSetting.consoleFatal = Boolean.parseBoolean(bean.file.get("fatal"));
                    String a = bean.file.get("defaultConsolePath");
                    if (a != null) {
                        instance.allSetting.defaultConsolePath = bean.file.get("defaultConsolePath").trim();
                    }
                } catch (NullPointerException ignored) {
                }

            } else {
                String content;
            }
        } catch (IOException e) {
            e.printStackTrace();
            instance.consoleFileMasterCaution = false;
        }
    }
}
