package com.optilog.log;

import com.optilog.log.client.Client;
import com.optilog.log.console.Console;
import com.optilog.setting.SettingFiles;
import com.optilog.util.OnlyInInit;
import com.optilog.util.Util;
import com.optilog.util.exception.OptilogException;

import java.io.IOException;

public class LogInit {
	private LogInit() {
	}
	
	@OnlyInInit
	public static void initLog(String settingFilePath, Optilog instance) {
		if (settingFilePath.isBlank()) {
			instance.consoleFileMasterCaution = false;
			instance.allSetting = new SettingFiles();
		}
		
		try {
			SettingFiles.check(settingFilePath, instance);
			if (instance.consoleFileMasterCaution) {
				Console.initAppender(instance);
				Client.initAppender(instance);
			}
		} catch (RuntimeException | IOException e) {
			Util.getOutput().println("Optilog Note:An Exception was thrown when Optilog init logger");
			throw new OptilogException("An Exception was thrown when Optilog init logger", e);
		}
	}
}
