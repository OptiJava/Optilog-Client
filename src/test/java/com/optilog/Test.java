package com.optilog;

import com.optilog.log.Level;
import com.optilog.log.LevelBuild;
import com.optilog.log.Log;

public class Test {
    public static void main(String[] args) {
        //LevelBuild testLevel = new LevelBuild("test", Level.INFO);
        Log log = Log.initLog("%prop -cp /Settings.properties");
        
        log.log("test #1", new LevelBuild("test", Level.INFO));
    }
}

