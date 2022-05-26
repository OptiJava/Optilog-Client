package com.optilog.log.console;

import com.optilog.log.Optilog;
import com.optilog.util.OnlyInInit;
import com.optilog.util.Util;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Console {
    @OnlyInInit
    public static void file(Optilog instance) {
        if (instance.consoleFileMasterCaution) {
            
            if (instance.allSetting != null) {
                instance.allSetting.fileName = instance.allSetting.fileName.replace("%time", DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(LocalDateTime.now()));
            } else {
                instance.consoleFileMasterCaution = false;
                return;
            }
            
            if (!instance.allSetting.defaultConsolePath.equals("") && instance.consoleFileMasterCaution) {
                final File f = new File(instance.allSetting.defaultConsolePath);
                if (Console.checkFile(f, instance) && instance.consoleFileMasterCaution) {
                    File defFile = new File(instance.allSetting.defaultConsolePath + "//" + instance.allSetting.fileName);
                    try {
                        if (!defFile.isFile()) {
                            if (!defFile.createNewFile()) {
                                instance.consoleFileMasterCaution = false;
                            }
                        }
                        if (instance.consoleFileMasterCaution) {
                            instance.info = defFile.getAbsolutePath();
                            instance.error = defFile.getAbsolutePath();
                            instance.warn = defFile.getAbsolutePath();
                            instance.debug = defFile.getAbsolutePath();
                            instance.fatal = defFile.getAbsolutePath();
                        }
                        return;
                    } catch (IOException e) {
                        instance.consoleFileMasterCaution = false;
                    }
                } else {
                    instance.consoleFileMasterCaution = false;
                    return;
                }
            }
            
            if (!instance.allSetting.Path1.equals("") && instance.consoleFileMasterCaution) {
                File file = new File(instance.allSetting.Path1 + "//" + instance.allSetting.fileName);
                try {
                    if (!file.isFile()) {
                        if (!file.createNewFile()) {
                            throw new IOException("Create new file failed!");
                        }
                        
                    }
                    instance.allSetting.Path1 = file.getAbsolutePath();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (!instance.allSetting.Path2.equals("") && instance.consoleFileMasterCaution) {
                File file = new File(instance.allSetting.Path2 + "//" + instance.allSetting.fileName);
                try {
                    if (!file.isFile()) {
                        if (!file.createNewFile()) {
                            throw new IOException("Create new file failed!");
                        }
                    }
                    instance.allSetting.Path2 = file.getAbsolutePath();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (!instance.allSetting.Path3.equals("") && instance.consoleFileMasterCaution) {
                File file = new File(instance.allSetting.Path3 + "//" + instance.allSetting.fileName);
                try {
                    if (!file.isFile()) {
                        if (!file.createNewFile()) {
                            throw new IOException("Create new file failed!");
                        }
                    }
                    instance.allSetting.Path3 = file.getAbsolutePath();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (!instance.allSetting.Path4.equals("") && instance.consoleFileMasterCaution) {
                File file = new File(instance.allSetting.Path4 + "//" + instance.allSetting.fileName);
                try {
                    if (!file.isFile()) {
                        if (!file.createNewFile()) {
                            throw new IOException("Create new file failed!");
                        }
                    }
                    instance.allSetting.Path4 = file.getAbsolutePath();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (!instance.allSetting.Path5.equals("") && instance.consoleFileMasterCaution) {
                File file = new File(instance.allSetting.Path5 + "//" + instance.allSetting.fileName);
                try {
                    if (!file.isFile()) {
                        if (!file.createNewFile()) {
                            throw new IOException("Create new file failed!");
                        }
                    }
                    instance.allSetting.Path5 = file.getAbsolutePath();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            
            if (instance.allSetting.infoPath.startsWith("%path") && instance.consoleFileMasterCaution) {
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
                        instance.consoleFileMasterCaution = false;
                        Util.getOutput().println("Optilog Note:Init console failed.");
                    }
                } catch (NullPointerException e) {
                    instance.consoleFileMasterCaution = false;
                    Util.getOutput().println("Optilog Note:Init console failed.");
                }
            }
            if (instance.allSetting.errorPath.startsWith("%path") && instance.consoleFileMasterCaution) {
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
                        instance.consoleFileMasterCaution = false;
                        Util.getOutput().println("Optilog Note:Init console failed.");
                    }
                } catch (NullPointerException e) {
                    instance.consoleFileMasterCaution = false;
                    Util.getOutput().println("Optilog Note:Init console failed.");
                }
            }
            if (instance.allSetting.warnPath.startsWith("%path") && instance.consoleFileMasterCaution) {
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
                        instance.consoleFileMasterCaution = false;
                        Util.getOutput().println("Optilog Note:Init console failed.");
                    }
                } catch (NullPointerException e) {
                    instance.consoleFileMasterCaution = false;
                    Util.getOutput().println("Optilog Note:Init console failed.");
                }
            }
            if (instance.allSetting.debugPath.startsWith("%path") && instance.consoleFileMasterCaution) {
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
                        instance.consoleFileMasterCaution = false;
                        Util.getOutput().println("Optilog Note:Init console failed.");
                    }
                } catch (NullPointerException e) {
                    instance.consoleFileMasterCaution = false;
                    Util.getOutput().println("Optilog Note:Init console failed.");
                }
            }
            if (instance.allSetting.fatalPath.startsWith("%path") && instance.consoleFileMasterCaution) {
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
                        instance.consoleFileMasterCaution = false;
                        Util.getOutput().println("Optilog Note:Init console failed.");
                    }
                } catch (NullPointerException e) {
                    instance.consoleFileMasterCaution = false;
                    Util.getOutput().println("Optilog Note:Init console failed.");
                }
            }
        }
    }
    
    @OnlyInInit
    private static boolean checkFile(File f, Optilog instance) {
        try {
            return f.isDirectory() & f.canRead() & f.canWrite() && instance.consoleFileMasterCaution;
        } catch (NullPointerException npe) {
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}