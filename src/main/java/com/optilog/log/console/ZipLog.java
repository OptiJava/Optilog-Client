package com.optilog.log.console;

import com.optilog.log.Optilog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipLog {
    public static void zipAllLog(boolean delete, Optilog instance, String path) {
        File f = new File(path + "//" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss(SS)").format(LocalDateTime.now()) + "LogPackage.zip");
        try {
            f.createNewFile();
        } catch (IOException e) {
            instance.warn("Optilog Note: Failed to create log package zip.");
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
                            fff.delete();
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
