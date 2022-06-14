package com.optilog.setting;

import com.optilog.util.OnlyInInit;

import java.util.Map;

public class XmlSettingBean {
    public Map<String, String> print;

    public Map<String, String> file;

    public Map<String, String> server;

    @OnlyInInit
    public XmlSettingBean() {

    }
}

