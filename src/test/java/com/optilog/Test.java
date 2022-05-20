package com.optilog;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("D://test.log");
        if (!file.isFile()) {
            if (!file.createNewFile()) {
                throw new RuntimeException();
            }
        }
        
        String s = Files.readString(Path.of(file.getPath()), StandardCharsets.UTF_8);
        Files.writeString(Path.of(file.getPath()), s + "hello,world", StandardCharsets.UTF_8);
    }
}
