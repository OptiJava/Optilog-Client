package com.optilog;

import com.optilog.log.Level;
import com.optilog.log.LevelBuild;
import com.optilog.log.Log;

public class Test {
    public static void main(String[] args) {
        LevelBuild test = new LevelBuild("Test", Level.DEBUG);
        Log log = Log.initLog("%prop -cp /Settings.properties");
        log.log("t!e!s!t!", test);
    }
}

