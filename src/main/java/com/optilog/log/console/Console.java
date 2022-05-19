package com.optilog.log.console;

import com.optilog.log.Optilog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Console {
    public static void file(Optilog instance) {
        if (instance.allSetting.defaultConsolePath != null && !instance.allSetting.defaultConsolePath.equals("")) {
            File f = new File(instance.allSetting.defaultConsolePath);
            if (Console.checkFile(f) && instance.consoleFileMasterCaution) {
                File defFile = new File(instance.allSetting.defaultConsolePath + "//" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(LocalDateTime.now()) + "Log(Client).log");
                try {
                    if (!defFile.createNewFile()) {
                        instance.consoleFileMasterCaution = false;
                    }
                    if (instance.consoleFileMasterCaution) {
                        OutputStream defStream = new FileOutputStream(defFile);
                        instance.info = defStream;
                        instance.error = defStream;
                        instance.warn = defStream;
                        instance.debug = defStream;
                        instance.fatal = defStream;
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
        if (instance.allSetting.infoPath != null) {
            OutputStream stream1 = null;
            OutputStream stream2 = null;
            OutputStream stream3 = null;
            OutputStream stream4 = null;
            OutputStream stream5 = null;
            if (instance.allSetting.Path1 != null && !instance.allSetting.Path1.equals("")) {
                File file = new File(instance.allSetting.Path1 + "//" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(LocalDateTime.now()) + "Log(Client).log");
                try {
                    if (!file.createNewFile()) {
                        throw new IOException("Create new file failed!");
                    }
                    stream1 = new FileOutputStream(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (instance.allSetting.Path2 != null && !instance.allSetting.Path2.equals("")) {
                File file = new File(instance.allSetting.Path2 + "//" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(LocalDateTime.now()) + "Log(Client).log");
                try {
                    if (!file.createNewFile()) {
                        throw new IOException("Create new file failed!");
                    }
                    stream2 = new FileOutputStream(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (instance.allSetting.Path3 != null && !instance.allSetting.Path3.equals("")) {
                File file = new File(instance.allSetting.Path3 + "//" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(LocalDateTime.now()) + "Log(Client).log");
                try {
                    if (!file.createNewFile()) {
                        throw new IOException("Create new file failed!");
                    }
                    stream3 = new FileOutputStream(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (instance.allSetting.Path4 != null && !instance.allSetting.Path4.equals("")) {
                File file = new File(instance.allSetting.Path4 + "//" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(LocalDateTime.now()) + "Log(Client).log");
                try {
                    if (!file.createNewFile()) {
                        throw new IOException("Create new file failed!");
                    }
                    stream4 = new FileOutputStream(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (instance.allSetting.Path5 != null && !instance.allSetting.Path5.equals("")) {
                File file = new File(instance.allSetting.Path5 + "//" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(LocalDateTime.now()) + "Log(Client).log");
                try {
                    if (!file.createNewFile()) {
                        throw new IOException("Create new file failed!");
                    }
                    stream5 = new FileOutputStream(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            
            if (instance.allSetting.infoPath.startsWith("%path")) {
                try {
                    if (instance.allSetting.infoPath.replace("%path", "").equals("1")) {
                        instance.info = stream1;
                    }
                    if (instance.allSetting.infoPath.replace("%path", "").equals("2")) {
                        instance.info = stream2;
                    }
                    if (instance.allSetting.infoPath.replace("%path", "").equals("3")) {
                        instance.info = stream3;
                    }
                    if (instance.allSetting.infoPath.replace("%path", "").equals("4")) {
                        instance.info = stream4;
                    }
                    if (instance.allSetting.infoPath.replace("%path", "").equals("5")) {
                        instance.info = stream5;
                    }
                    if (instance.info == null) {
                        throw new NullPointerException();
                    }
                } catch (NullPointerException e) {
                    throw new RuntimeException(e);
                }
            }
            if (instance.allSetting.errorPath.startsWith("%path")) {
                try {
                    if (instance.allSetting.errorPath.replace("%path", "").equals("1")) {
                        instance.error = stream1;
                    }
                    if (instance.allSetting.errorPath.replace("%path", "").equals("2")) {
                        instance.error = stream2;
                    }
                    if (instance.allSetting.errorPath.replace("%path", "").equals("3")) {
                        instance.error = stream3;
                    }
                    if (instance.allSetting.errorPath.replace("%path", "").equals("4")) {
                        instance.error = stream4;
                    }
                    if (instance.allSetting.errorPath.replace("%path", "").equals("5")) {
                        instance.error = stream5;
                    }
                    if (instance.error == null) {
                        throw new NullPointerException();
                    }
                } catch (NullPointerException e) {
                    throw new RuntimeException(e);
                }
            }
            if (instance.allSetting.warnPath.startsWith("%path")) {
                try {
                    if (instance.allSetting.warnPath.replace("%path", "").equals("1")) {
                        instance.warn = stream1;
                    }
                    if (instance.allSetting.warnPath.replace("%path", "").equals("2")) {
                        instance.warn = stream2;
                    }
                    if (instance.allSetting.warnPath.replace("%path", "").equals("3")) {
                        instance.warn = stream3;
                    }
                    if (instance.allSetting.warnPath.replace("%path", "").equals("4")) {
                        instance.warn = stream4;
                    }
                    if (instance.allSetting.warnPath.replace("%path", "").equals("5")) {
                        instance.warn = stream5;
                    }
                    if (instance.warn == null) {
                        throw new NullPointerException();
                    }
                } catch (NullPointerException e) {
                    throw new RuntimeException(e);
                }
            }
            if (instance.allSetting.debugPath.startsWith("%path")) {
                try {
                    if (instance.allSetting.debugPath.replace("%path", "").equals("1")) {
                        instance.debug = stream1;
                    }
                    if (instance.allSetting.debugPath.replace("%path", "").equals("2")) {
                        instance.debug = stream2;
                    }
                    if (instance.allSetting.debugPath.replace("%path", "").equals("3")) {
                        instance.debug = stream3;
                    }
                    if (instance.allSetting.debugPath.replace("%path", "").equals("4")) {
                        instance.debug = stream4;
                    }
                    if (instance.allSetting.debugPath.replace("%path", "").equals("5")) {
                        instance.debug = stream5;
                    }
                    if (instance.debug == null) {
                        throw new NullPointerException();
                    }
                } catch (NullPointerException e) {
                    throw new RuntimeException(e);
                }
            }
            if (instance.allSetting.fatalPath.startsWith("%path")) {
                try {
                    if (instance.allSetting.fatalPath.replace("%path", "").equals("1")) {
                        instance.fatal = stream1;
                    }
                    if (instance.allSetting.fatalPath.replace("%path", "").equals("2")) {
                        instance.fatal = stream2;
                    }
                    if (instance.allSetting.fatalPath.replace("%path", "").equals("3")) {
                        instance.fatal = stream3;
                    }
                    if (instance.allSetting.fatalPath.replace("%path", "").equals("4")) {
                        instance.fatal = stream4;
                    }
                    if (instance.allSetting.fatalPath.replace("%path", "").equals("5")) {
                        instance.fatal = stream5;
                    }
                    if (instance.fatal == null) {
                        throw new NullPointerException();
                    }
                } catch (NullPointerException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        
        /*OutputStream defStream;
        
        File defFile = new File(instance.allSetting.defaultConsolePath);
        File infoFile = new File(instance.allSetting.infoSingleConsolePath);
        File errorFile = new File(instance.allSetting.errorSingleConsolePath);
        File warnFile = new File(instance.allSetting.warnSingleConsolePath);
        File debugFile = new File(instance.allSetting.debugSingleConsolePath);
        File fatalFile = new File(instance.allSetting.fatalSingleConsolePath);
        
        boolean isInfoAbsoluteSingle = Console.checkFile(infoFile);
        boolean isErrorAbsoluteSingle;
        boolean isDebugAbsoluteSingle;
        boolean isWarnAbsoluteSingle;
        boolean isFatalAbsoluteSingle;
        
        if (Console.checkFile(defFile)) {
            File f = new File(instance.allSetting.defaultConsolePath + "//" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(LocalDateTime.now()) + "Log(Client).log");
            try {
                if (!f.createNewFile()) {
                    throw new CreateFileErrorException("Create def log file failed.");
                }
                defStream = new FileOutputStream(f);
            } catch (IOException | CreateFileErrorException e) {
                instance.consoleFileMasterCaution = false;
                Util.getOutput().println("Optilog Note: IOException.");
                e.printStackTrace();
                return;
            }
        } else {
            instance.consoleFileMasterCaution = false;
            Util.getOutput().println("Optilog Note: def file path illegal!");
            return;
        }
        if (Console.checkFile(infoFile)) {
            File f = new File(instance.allSetting.infoSingleConsolePath + "//" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(LocalDateTime.now()) + "Log(Client).log");
            try {
                if (!f.createNewFile()) {
                    throw new CreateFileErrorException("Create info log file failed.");
                }
                instance.info = new FileOutputStream(f);
            } catch (IOException | CreateFileErrorException e) {
                instance.consoleFileMasterCaution = false;
                Util.getOutput().println("Optilog Note: IOException.");
                e.printStackTrace();
                return;
            }
        } else {
            instance.consoleFileMasterCaution = false;
            Util.getOutput().println("Optilog Note: info file path illegal!");
            return;
        }
        if (Console.checkFile(errorFile)) {
            File f = new File(instance.allSetting.errorSingleConsolePath + "//" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(LocalDateTime.now()) + "Log(Client).log");
            try {
                if (!f.createNewFile()) {
                    throw new CreateFileErrorException("Create error log file failed.");
                }
                instance.error = new FileOutputStream(f);
            } catch (IOException | CreateFileErrorException e) {
                instance.consoleFileMasterCaution = false;
                Util.getOutput().println("Optilog Note: IOException.");
                e.printStackTrace();
                return;
            }
        } else {
            instance.consoleFileMasterCaution = false;
            Util.getOutput().println("Optilog Note: error file path illegal!");
            return;
        }
        if (Console.checkFile(warnFile)) {
            File f = new File(instance.allSetting.warnSingleConsolePath + "//" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(LocalDateTime.now()) + "Log(Client).log");
            try {
                if (!f.createNewFile()) {
                    throw new CreateFileErrorException("Create warn log file failed.");
                }
                instance.warn = new FileOutputStream(f);
            } catch (IOException | CreateFileErrorException e) {
                instance.consoleFileMasterCaution = false;
                Util.getOutput().println("Optilog Note: IOException.");
                e.printStackTrace();
                return;
            }
        } else {
            instance.consoleFileMasterCaution = false;
            Util.getOutput().println("Optilog Note: warn file path illegal!");
            return;
        }
        if (Console.checkFile(debugFile)) {
            File f = new File(instance.allSetting.debugSingleConsolePath + "//" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(LocalDateTime.now()) + "Log(Client).log");
            try {
                if (!f.createNewFile()) {
                    throw new CreateFileErrorException("Create debug log file failed.");
                }
                instance.debug = new FileOutputStream(f);
            } catch (IOException | CreateFileErrorException e) {
                instance.consoleFileMasterCaution = false;
                Util.getOutput().println("Optilog Note: IOException.");
                e.printStackTrace();
                return;
            }
        } else {
            instance.consoleFileMasterCaution = false;
            Util.getOutput().println("Optilog Note: debug file path illegal!");
            return;
        }
        if (Console.checkFile(fatalFile)) {
            File f = new File(instance.allSetting.fatalSingleConsolePath + "//" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(LocalDateTime.now()) + "Log(Client).log");
            try {
                if (!f.createNewFile()) {
                    throw new CreateFileErrorException("Create fatal log file failed.");
                }
                instance.fatal = new FileOutputStream(f);
            } catch (IOException | CreateFileErrorException e) {
                instance.consoleFileMasterCaution = false;
                Util.getOutput().println("Optilog Note: IOException.");
                e.printStackTrace();
                return;
            }
        } else {
            instance.consoleFileMasterCaution = false;
            Util.getOutput().println("Optilog Note: fatal file path illegal!");
            return;
        }*/
    }
    
    private static boolean checkFile(File f) {
        try {
            return f.isDirectory() & f.canRead() & f.canWrite();
        } catch (NullPointerException npe) {
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}