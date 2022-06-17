package com.optilog;

import com.optilog.log.Log;

public class Profile {
    public static void main(String[] args) {
        Log log = Log.initLog("%prop -cp /Settings.properties");
        log.info();
    }
}
