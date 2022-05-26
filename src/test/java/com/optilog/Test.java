package com.optilog;

import com.optilog.log.Log;

public class Test {
    public static void main(String[] args) {
        Log log = Log.initLog("-cp /Settings.json");
        log.info("");
        log.getAllField(log);
    }
}

