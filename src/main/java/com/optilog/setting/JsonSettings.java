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
                
            } else {
                String content;
            }
        } catch (IOException e) {
            e.printStackTrace();
            instance.consoleFileMasterCaution = false;
        }
    }
}
