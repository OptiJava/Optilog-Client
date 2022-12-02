package com.optilog.log.console;

import com.optilog.log.Optilog;
import com.optilog.util.OnlyInLog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipLog {
    @OnlyInLog
    public static void zipAllLog(boolean delete, Optilog instance, String path) {
        File f = new File(path + File.separator + DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss(SS)").format(LocalDateTime.now()) + "LogPackage.zip");
        try {
            if (!f.createNewFile()) {
                throw new IOException("Create file failed.");
            }
        } catch (IOException e) {
            instance.warn("Optilog Note: Failed to create log package zip.", e);
            return;
        }

        try (ZipOutputStream output = new ZipOutputStream(new FileOutputStream(f))) {
            File[] file = new File(path).listFiles();
            if (file != null) {
                for (File fff : file) {
                    if (fff.getName().endsWith(".log")) {
                        output.putNextEntry(new ZipEntry(fff.getName()));
                        output.write(Files.readAllBytes(fff.toPath()));
                        output.closeEntry();
                        if (delete) {
                            if (!fff.delete()) {
                                System.err.println("Delete file failed.");
                            }
                        }
                    }
                }
            } else {
                instance.info("Optilog Note:No log initAppender in fatal initAppender path.");
            }
        } catch (IOException e) {
            instance.error("Optilog Note:Failed to pack log initAppender.", e);
        }
    }
}
