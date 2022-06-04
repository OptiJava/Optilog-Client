package com.optilog.log;

import com.optilog.util.OnlyInLog;

public class LevelBuild {
	volatile String levelName;
	
	volatile Level levelTemplate;
	
	@OnlyInLog
	public LevelBuild(String levelName, Level levelTemplate) {
		this.levelName = levelName;
		this.levelTemplate = levelTemplate;
	}
}
