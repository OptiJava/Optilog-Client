package com.optilog.log;

public class LevelBuild {
    volatile String levelName;
    
    volatile Level levelTemplate;
    
    public LevelBuild(String levelName, Level levelTemplate) {
        this.levelName = levelName;
        this.levelTemplate = levelTemplate;
    }
}
