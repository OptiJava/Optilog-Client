package com.optilog;

import com.optilog.log.Log;

public class PerformanceTester {
    public static void main(String[] args) {
        Log log = Log.initLog("%prop -cp /Settings.properties");

        long l = System.currentTimeMillis();
        log.info("");
        System.out.println(System.currentTimeMillis() - l);
    }
}
