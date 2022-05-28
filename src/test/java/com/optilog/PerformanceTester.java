package com.optilog;

import com.optilog.log.Log;

public class PerformanceTester {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        Log log = Log.initLog("%prop -cp /Settings.properties");
        log.info("");
        System.out.println(System.currentTimeMillis() - l);
    }
}
