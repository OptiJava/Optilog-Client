package com.optilog.setting;

import com.optilog.log.Optilog;
import com.optilog.util.OnlyInInit;
import com.optilog.util.exception.ConfigureException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropSettings {
	@OnlyInInit
	static void properties(InputStream content, Optilog instance) {
		final Properties p = new Properties();
		try {
			p.load(content);
			
			instance.allSetting.printInfo = Boolean.parseBoolean(p.getProperty("printInfo", "true"));
			instance.allSetting.printError = Boolean.parseBoolean(p.getProperty("printError", "true"));
			instance.allSetting.printWarn = Boolean.parseBoolean(p.getProperty("printWarn", "true"));
			instance.allSetting.printDebug = Boolean.parseBoolean(p.getProperty("printDebug", "true"));
			instance.allSetting.printFatal = Boolean.parseBoolean(p.getProperty("printFatal", "true"));
			
			instance.allSetting.consoleInfo = Boolean.parseBoolean(p.getProperty("consoleInfo", "false"));
			instance.allSetting.consoleError = Boolean.parseBoolean(p.getProperty("consoleError", "false"));
			instance.allSetting.consoleWarn = Boolean.parseBoolean(p.getProperty("consoleWarn", "false"));
			instance.allSetting.consoleDebug = Boolean.parseBoolean(p.getProperty("consoleDebug", "false"));
			instance.allSetting.consoleFatal = Boolean.parseBoolean(p.getProperty("consoleFatal", "false"));
			
			instance.allSetting.serverInfo = Boolean.parseBoolean(p.getProperty("infoSendToServer", "false"));
			instance.allSetting.serverError = Boolean.parseBoolean(p.getProperty("errorSendToServer", "false"));
			instance.allSetting.serverWarn = Boolean.parseBoolean(p.getProperty("warnSendToServer", "false"));
			instance.allSetting.serverDebug = Boolean.parseBoolean(p.getProperty("debugSendToServer", "false"));
			instance.allSetting.serverFatal = Boolean.parseBoolean(p.getProperty("fatalSendToServer", "false"));
			
			instance.allSetting.defaultConsolePath = p.getProperty("defaultConsolePath", "");
			instance.allSetting.Path1 = p.getProperty("Path1", "");
			instance.allSetting.Path2 = p.getProperty("Path2", "");
			instance.allSetting.Path3 = p.getProperty("Path3", "");
			instance.allSetting.Path4 = p.getProperty("Path4", "");
			instance.allSetting.Path5 = p.getProperty("Path5", "");
			
			instance.allSetting.infoPath = p.getProperty("infoPath", "");
			instance.allSetting.errorPath = p.getProperty("errorPath", "");
			instance.allSetting.warnPath = p.getProperty("warnPath", "");
			instance.allSetting.debugPath = p.getProperty("debugPath", "");
			instance.allSetting.fatalPath = p.getProperty("fatalPath", "");
			
			instance.allSetting.host = p.getProperty("host", "localhost");
			
			instance.allSetting.startClient = Boolean.parseBoolean(p.getProperty("startClient", "false"));
			
			instance.allSetting.packingFormat = p.getProperty("packingFormat", "[%yyyy-%MM-%dd|%HH:%mm:%ss(%SS)][%class %method(%file:%line)/%thread] %level:%msg");
			
			instance.allSetting.fileName = p.getProperty("fileName", "%time Log(Client).log");
		} catch (IOException e) {
			System.err.println("Optilog Note:Read file failed.");
			throw new ConfigureException("Can't find file.", e);
		}
	}
}
