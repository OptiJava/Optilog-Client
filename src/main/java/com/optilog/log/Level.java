package com.optilog.log;

import com.optilog.util.OnlyInLog;

public class Level {
	/* */
	public final static Level INFO = new Level("info");
	public final static Level ERROR = new Level("Error");
	public final static Level WARN = new Level("Warning");
	public final static Level DEBUG = new Level("debug");
	public final static Level FATAL = new Level("FATAL");
	
	@OnlyInLog
	Level(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	private final String name;
}
