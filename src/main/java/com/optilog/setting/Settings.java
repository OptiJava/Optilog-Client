package com.optilog.setting;

import com.optilog.util.OnlyInInit;

import java.util.Map;

public class Settings {
    public Map<String, String> print;

    public Map<String, String> file;

    public Map<String, String> server;

    @OnlyInInit
    public Settings() {

    }
}

