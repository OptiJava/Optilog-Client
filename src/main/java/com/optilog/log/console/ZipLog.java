package com.optilog.log.console;

import com.optilog.log.LogInit;
import com.optilog.log.Optilog;
import com.optilog.util.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipLog {
    public static void zipAllLog(boolean delete, Optilog instance) {
        if (!instance.alreadyInit) {
            LogInit.initLog(instance.settingFilePath, instance);
        }
        String s = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss(SS)").format(LocalDateTime.now());
        File info = new File(instance.info.substring(0, instance.info.length() - (instance.allSetting.fileName.length() + 1)) + "//" + s + "LogPackage.zip");
        File error = new File(instance.error.substring(0, instance.error.length() - (instance.allSetting.fileName.length() + 1)) + "//" + s + "LogPackage.zip");
        File warn = new File(instance.warn.substring(0, instance.warn.length() - (instance.allSetting.fileName.length() + 1)) + "//" + s + "LogPackage.zip");
        File debug = new File(instance.debug.substring(0, instance.debug.length() - (instance.allSetting.fileName.length() + 1)) + "//" + s + "LogPackage.zip");
        File fatal = new File(instance.fatal.substring(0, instance.fatal.length() - (instance.allSetting.fileName.length() + 1)) + "//" + s + "LogPackage.zip");
        try {
            if (!info.isFile()) {
                if (!info.createNewFile()) {
                    Util.getOutput().println("Optilog Note:Failed to create zip file!");
                    return;
                }
            }
            if (!error.isFile()) {
                if (!error.createNewFile()) {
                    Util.getOutput().println("Optilog Note:Failed to create zip file!");
                    return;
                }
            }
            if (!warn.isFile()) {
                if (!warn.createNewFile()) {
                    Util.getOutput().println("Optilog Note:Failed to create zip file!");
                    return;
                }
            }
            if (!debug.isFile()) {
                if (!debug.createNewFile()) {
                    Util.getOutput().println("Optilog Note:Failed to create zip file!");
                    return;
                }
            }
            if (!fatal.isFile()) {
                if (!fatal.createNewFile()) {
                    Util.getOutput().println("Optilog Note:Failed to create zip file!");
                    return;
                }
            }
        } catch (IOException e) {
            Util.getOutput().println("Optilog Note:Failed to create zip file!");
            e.printStackTrace();
            return;
        }
        try (ZipOutputStream output = new ZipOutputStream(new FileOutputStream(info))) {
            File[] file = new File(instance.info.substring(0, instance.info.length() - (instance.allSetting.fileName.length() + 1))).listFiles();
            if (file != null) {
                for (File f : file) {
                    if (f.getName().endsWith(".log")) {
                        output.putNextEntry(new ZipEntry(f.getName()));
                        output.write(Files.readAllBytes(f.toPath()));
                        output.closeEntry();
                        if (delete) {
                            if (!f.delete()) {
                                instance.warn("Optilog Note:Delete #1 failed!", f.getName());
                            }
                        }
                    }
                }
            } else {
                instance.info("Optilog Note:No log file in info file path.");
            }
        } catch (IOException e) {
            instance.error("Optilog Note:Failed to pack log file.", e);
        }
        
        if (!error.isFile()) {
            try (ZipOutputStream output = new ZipOutputStream(new FileOutputStream(error))) {
                File[] file = new File(instance.error.substring(0, instance.error.length() - (instance.allSetting.fileName.length() + 1))).listFiles();
                if (file != null) {
                    for (File f : file) {
                        if (f.getName().endsWith(".log")) {
                            output.putNextEntry(new ZipEntry(f.getName()));
                            output.write(Files.readAllBytes(f.toPath()));
                            output.closeEntry();
                            if (delete) {
                                if (!f.delete()) {
                                    instance.warn("Optilog Note:Delete #1 failed!", f.getName());
                                }
                            }
                        }
                    }
                } else {
                    instance.info("Optilog Note:No log file in error file path.");
                }
            } catch (IOException e) {
                instance.error("Optilog Note:Failed to pack log file.", e);
            }
        }
        
        if (!warn.isFile()) {
            try (ZipOutputStream output = new ZipOutputStream(new FileOutputStream(warn))) {
                File[] file = new File(instance.warn.substring(0, instance.warn.length() - (instance.allSetting.fileName.length() + 1))).listFiles();
                if (file != null) {
                    for (File f : file) {
                        if (f.getName().endsWith(".log")) {
                            output.putNextEntry(new ZipEntry(f.getName()));
                            output.write(Files.readAllBytes(f.toPath()));
                            output.closeEntry();
                            if (delete) {
                                if (!f.delete()) {
                                    instance.warn("Optilog Note:Delete #1 failed!", f.getName());
                                }
                            }
                        }
                    }
                } else {
                    instance.info("Optilog Note:No log file in warn file path.");
                }
            } catch (IOException e) {
                instance.error("Optilog Note:Failed to pack log file.", e);
            }
        }
        
        if (!debug.isFile()) {
            try (ZipOutputStream output = new ZipOutputStream(new FileOutputStream(debug))) {
                File[] file = new File(instance.debug.substring(0, instance.debug.length() - (instance.allSetting.fileName.length() + 1))).listFiles();
                if (file != null) {
                    for (File f : file) {
                        if (f.getName().endsWith(".log")) {
                            output.putNextEntry(new ZipEntry(f.getName()));
                            output.write(Files.readAllBytes(f.toPath()));
                            output.closeEntry();
                            if (delete) {
                                if (!f.delete()) {
                                    instance.warn("Optilog Note:Delete #1 failed!", f.getName());
                                }
                            }
                        }
                    }
                } else {
                    instance.info("Optilog Note:No log file in debug file path.");
                }
            } catch (IOException e) {
                instance.error("Optilog Note:Failed to pack log file.", e);
            }
        }
        
        if (!fatal.isFile()) {
            try (ZipOutputStream output = new ZipOutputStream(new FileOutputStream(fatal))) {
                File[] file = new File(instance.fatal.substring(0, instance.fatal.length() - (instance.allSetting.fileName.length() + 1))).listFiles();
                if (file != null) {
                    for (File f : file) {
                        if (f.getName().endsWith(".log")) {
                            output.putNextEntry(new ZipEntry(f.getName()));
                            output.write(Files.readAllBytes(f.toPath()));
                            output.closeEntry();
                            if (delete) {
                                if (!f.delete()) {
                                    instance.warn("Optilog Note:Delete #1 failed!", f.getName());
                                }
                            }
                        }
                    }
                } else {
                    instance.info("Optilog Note:No log file in fatal file path.");
                }
            } catch (IOException e) {
                instance.error("Optilog Note:Failed to pack log file.", e);
            }
        }
    }
}
