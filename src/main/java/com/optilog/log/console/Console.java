package com.optilog.log.console;

import com.optilog.log.Optilog;
import com.optilog.util.OnlyInInit;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;

public class Console {
	@OnlyInInit
	public static void initAppender(Optilog instance) {
		
		if (instance.consoleFileMasterCaution) {
			instance.allSetting.fileName = instance.allSetting.fileName.replace("%time", Matcher.quoteReplacement(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(LocalDateTime.now())));
			//System.out.println(instance + "" + instance.allSetting + instance.allSetting.defaultConsolePath);
			
			if (!instance.allSetting.defaultConsolePath.equals("") & instance.consoleFileMasterCaution) {
				final File f = new File(instance.allSetting.defaultConsolePath);
				if (Console.checkFile(f, instance)) {
					File defFile = new File(instance.allSetting.defaultConsolePath + "//" + instance.allSetting.fileName);
					try {
						if (!defFile.isFile()) {
							if (!defFile.createNewFile()) {
								instance.consoleFileMasterCaution = false;
								throw new IOException("Failed to create log file in default console path!");
							}
						}
						if (instance.consoleFileMasterCaution) {
							instance.info = defFile.getAbsolutePath();
							instance.error = defFile.getAbsolutePath();
							instance.warn = defFile.getAbsolutePath();
							instance.debug = defFile.getAbsolutePath();
							instance.fatal = defFile.getAbsolutePath();
						}
					} catch (IOException e) {
						System.err.println("Optilog Note: IOException in init default path log file!");
						instance.consoleFileMasterCaution = false;
					}
				} else {
					System.err.println("Optilog Note: ConsolePath maybe not correct or not exists");
					instance.consoleFileMasterCaution = false;
					return;
				}
			}
			
			if (!instance.allSetting.Path1.equals("") & instance.consoleFileMasterCaution) {
				File file = new File(instance.allSetting.Path1 + "//" + instance.allSetting.fileName);
				try {
					if (!file.isFile()) {
						if (!file.createNewFile()) {
							throw new IOException("Create new initAppender failed!");
						}
					}
					instance.allSetting.Path1 = file.getAbsolutePath();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			if (!instance.allSetting.Path2.equals("") & instance.consoleFileMasterCaution) {
				File file = new File(instance.allSetting.Path2 + "//" + instance.allSetting.fileName);
				try {
					if (!file.isFile()) {
						if (!file.createNewFile()) {
							throw new IOException("Create new initAppender failed!");
						}
					}
					instance.allSetting.Path2 = file.getAbsolutePath();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			if (!instance.allSetting.Path3.equals("") & instance.consoleFileMasterCaution) {
				File file = new File(instance.allSetting.Path3 + "//" + instance.allSetting.fileName);
				try {
					if (!file.isFile()) {
						if (!file.createNewFile()) {
							throw new IOException("Create new initAppender failed!");
						}
					}
					instance.allSetting.Path3 = file.getAbsolutePath();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			if (!instance.allSetting.Path4.equals("") & instance.consoleFileMasterCaution) {
				File file = new File(instance.allSetting.Path4 + "//" + instance.allSetting.fileName);
				try {
					if (!file.isFile()) {
						if (!file.createNewFile()) {
							throw new IOException("Create new initAppender failed!");
						}
					}
					instance.allSetting.Path4 = file.getAbsolutePath();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			if (!instance.allSetting.Path5.equals("") & instance.consoleFileMasterCaution) {
				File file = new File(instance.allSetting.Path5 + "//" + instance.allSetting.fileName);
				try {
					if (!file.isFile()) {
						if (!file.createNewFile()) {
							throw new IOException("Create new initAppender failed!");
						}
					}
					instance.allSetting.Path5 = file.getAbsolutePath();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
		
		if (instance.allSetting.infoPath.startsWith("%path") & instance.consoleFileMasterCaution) {
			try {
				if (instance.allSetting.infoPath.replace("%path", "").equals("1")) {
					instance.info = instance.allSetting.Path1;
				}
				if (instance.allSetting.infoPath.replace("%path", "").equals("2")) {
					instance.info = instance.allSetting.Path2;
				}
				if (instance.allSetting.infoPath.replace("%path", "").equals("3")) {
					instance.info = instance.allSetting.Path3;
				}
				if (instance.allSetting.infoPath.replace("%path", "").equals("4")) {
					instance.info = instance.allSetting.Path4;
				}
				if (instance.allSetting.infoPath.replace("%path", "").equals("5")) {
					instance.info = instance.allSetting.Path5;
				}
				if (instance.info.equals("")) {
					System.err.println("Optilog Note: Unexpected error occur when parse infoPath");
					instance.allSetting.consoleInfo = false;
				}
			} catch (NullPointerException e) {
				instance.consoleFileMasterCaution = false;
				System.err.println("Optilog Note: Unexpected error occur when parse infoPath");
				e.printStackTrace();
			}
		}
		if (instance.allSetting.errorPath.startsWith("%path") & instance.consoleFileMasterCaution) {
			try {
				if (instance.allSetting.errorPath.replace("%path", "").equals("1")) {
					instance.error = instance.allSetting.Path1;
				}
				if (instance.allSetting.errorPath.replace("%path", "").equals("2")) {
					instance.error = instance.allSetting.Path2;
				}
				if (instance.allSetting.errorPath.replace("%path", "").equals("3")) {
					instance.error = instance.allSetting.Path3;
				}
				if (instance.allSetting.errorPath.replace("%path", "").equals("4")) {
					instance.error = instance.allSetting.Path4;
				}
				if (instance.allSetting.errorPath.replace("%path", "").equals("5")) {
					instance.error = instance.allSetting.Path5;
				}
				if (instance.error.equals("")) {
					instance.allSetting.consoleError = false;
					System.err.println("Optilog Note: Unexpected error occur when parse errorPath");
				}
			} catch (NullPointerException e) {
				instance.consoleFileMasterCaution = false;
				System.err.println("Optilog Note: Unexpected error occur when parse errorPath");
				e.printStackTrace();
			}
		}
		if (instance.allSetting.warnPath.startsWith("%path") & instance.consoleFileMasterCaution) {
			try {
				if (instance.allSetting.warnPath.replace("%path", "").equals("1")) {
					instance.warn = instance.allSetting.Path1;
				}
				if (instance.allSetting.warnPath.replace("%path", "").equals("2")) {
					instance.warn = instance.allSetting.Path2;
				}
				if (instance.allSetting.warnPath.replace("%path", "").equals("3")) {
					instance.warn = instance.allSetting.Path3;
				}
				if (instance.allSetting.warnPath.replace("%path", "").equals("4")) {
					instance.warn = instance.allSetting.Path4;
				}
				if (instance.allSetting.warnPath.replace("%path", "").equals("5")) {
					instance.warn = instance.allSetting.Path5;
				}
				if (instance.warn.equals("")) {
					instance.allSetting.consoleWarn = false;
					System.err.println("Optilog Note: Unexpected error occur when parse warnPath");
				}
			} catch (NullPointerException e) {
				instance.consoleFileMasterCaution = false;
				System.err.println("Optilog Note: Unexpected error occur when parse warnPath");
			}
		}
		if (instance.allSetting.debugPath.startsWith("%path") & instance.consoleFileMasterCaution) {
			try {
				if (instance.allSetting.debugPath.replace("%path", "").equals("1")) {
					instance.debug = instance.allSetting.Path1;
				}
				if (instance.allSetting.debugPath.replace("%path", "").equals("2")) {
					instance.debug = instance.allSetting.Path2;
				}
				if (instance.allSetting.debugPath.replace("%path", "").equals("3")) {
					instance.debug = instance.allSetting.Path3;
				}
				if (instance.allSetting.debugPath.replace("%path", "").equals("4")) {
					instance.debug = instance.allSetting.Path4;
				}
				if (instance.allSetting.debugPath.replace("%path", "").equals("5")) {
					instance.debug = instance.allSetting.Path5;
				}
				if (instance.debug.equals("")) {
					instance.allSetting.consoleDebug = false;
					System.err.println("Optilog Note: Unexpected error occur when parse debugPath");
				}
			} catch (NullPointerException e) {
				instance.consoleFileMasterCaution = false;
				System.err.println("Optilog Note: Unexpected error occur when parse debugPath");
			}
		}
		if (instance.allSetting.fatalPath.startsWith("%path") & instance.consoleFileMasterCaution) {
			try {
				if (instance.allSetting.fatalPath.replace("%path", "").equals("1")) {
					instance.fatal = instance.allSetting.Path1;
				}
				if (instance.allSetting.fatalPath.replace("%path", "").equals("2")) {
					instance.fatal = instance.allSetting.Path2;
				}
				if (instance.allSetting.fatalPath.replace("%path", "").equals("3")) {
					instance.fatal = instance.allSetting.Path3;
				}
				if (instance.allSetting.fatalPath.replace("%path", "").equals("4")) {
					instance.fatal = instance.allSetting.Path4;
				}
				if (instance.allSetting.fatalPath.replace("%path", "").equals("5")) {
					instance.fatal = instance.allSetting.Path5;
				}
				if (instance.fatal.equals("")) {
					instance.allSetting.consoleFatal = false;
					System.err.println("Optilog Note: Unexpected error occur when parse fatalPath");
				}
			} catch (NullPointerException e) {
				instance.consoleFileMasterCaution = false;
				System.err.println("Optilog Note: Unexpected error occur when parse fatalPath");
			}
		}
		
	}
	
	@OnlyInInit
	private static boolean checkFile(File f, Optilog instance) {
		try {
			return f.isDirectory() & f.canRead() & f.canWrite() & instance.consoleFileMasterCaution;
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			return false;
		} catch (Exception e) {
			try {
				throw new RuntimeException(e);
			} catch (Exception ex) {
				ex.printStackTrace();
				return false;
			}
		}
	}
}
