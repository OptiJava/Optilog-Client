package com.optilog;

import com.optilog.log.Log;

public class PerformanceTester {
    private static final Log LOGGER = Log.initLog("%yaml -cp /Settings.yaml");

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        LOGGER.info();
        long stopTime = System.currentTimeMillis();
        System.out.println(stopTime - startTime);
    }
}
