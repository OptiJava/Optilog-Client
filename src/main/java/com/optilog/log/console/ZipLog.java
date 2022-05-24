package com.optilog.log.console;

import com.optilog.log.Optilog;
import com.optilog.util.Debugging;
import com.optilog.util.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Debugging   // TODO
public class ZipLog {
    public static void zipAllLog(boolean delete, Optilog instance) {
        String s = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss(SS)").format(LocalDateTime.now());
        File info = new File(instance.info + s + "LogPackage.zip");
        File error = new File(instance.error + s + "LogPackage.zip");
        File warn = new File(instance.warn + s + "LogPackage.zip");
        File debug = new File(instance.debug + s + "LogPackage.zip");
        File fatal = new File(instance.fatal + s + "LogPackage.zip");
        try {
            if (!info.createNewFile()) {
                Util.getOutput().println("Optilog Note:Failed to create zip file!");
                return;
            }
            if (!error.createNewFile()) {
                Util.getOutput().println("Optilog Note:Failed to create zip file!");
                return;
            }
            if (!warn.createNewFile()) {
                Util.getOutput().println("Optilog Note:Failed to create zip file!");
                return;
            }
            if (!debug.createNewFile()) {
                Util.getOutput().println("Optilog Note:Failed to create zip file!");
                return;
            }
            if (!fatal.createNewFile()) {
                Util.getOutput().println("Optilog Note:Failed to create zip file!");
                return;
            }
        } catch (IOException e) {
            Util.getOutput().println("Optilog Note:Failed to create zip file!");
            e.printStackTrace();
            return;
        }
        
        try (ZipOutputStream output = new ZipOutputStream(new FileOutputStream(info))) {
            File[] file = new File(instance.info).listFiles();
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
        
        try (ZipOutputStream output = new ZipOutputStream(new FileOutputStream(error))) {
            File[] file = new File(instance.error).listFiles();
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
        
        try (ZipOutputStream output = new ZipOutputStream(new FileOutputStream(warn))) {
            File[] file = new File(instance.warn).listFiles();
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
        
        try (ZipOutputStream output = new ZipOutputStream(new FileOutputStream(debug))) {
            File[] file = new File(instance.debug).listFiles();
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
        
        try (ZipOutputStream output = new ZipOutputStream(new FileOutputStream(fatal))) {
            File[] file = new File(instance.fatal).listFiles();
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
