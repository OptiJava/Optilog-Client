package com.optilog;

import com.optilog.log.Log;

public class Test {
    public static void main(String[] args) {
        Log log = Log.initLog("%xml -cp /Settings.xml");
        log.info("info-1");
        log.error("error-1");
        log.debug("debug-1");
        log.fatal("fatal-1");
    }
}

