package com.optilog;

import com.optilog.log.Log;

public class Test {
    public static void main(String[] args) {
        Log log = Log.initLog("%prop -cp /Settings.properties");
        log.info("dddd");
        log.command("%zip");
    }
}
