package com.optilog.log;

import com.optilog.util.OnlyInLog;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Packing {
    @OnlyInLog
    public static String packMessage(String msg, String level, Optilog instance) {
        StackTraceElement[] arr = Thread.currentThread().getStackTrace();
        String returnString = instance.allSetting.packingFormat;
        try {
            returnString = searchMessage(returnString);
            
            returnString = returnString.replaceAll("%yyyy", DateTimeFormatter.ofPattern("yyyy").format(LocalDateTime.now()));
            returnString = returnString.replaceAll("%MM", DateTimeFormatter.ofPattern("MM").format(LocalDateTime.now()));
            returnString = returnString.replaceAll("%dd", DateTimeFormatter.ofPattern("dd").format(LocalDateTime.now()));
            returnString = returnString.replaceAll("%HH", DateTimeFormatter.ofPattern("HH").format(LocalDateTime.now()));
            returnString = returnString.replaceAll("%mm", DateTimeFormatter.ofPattern("mm").format(LocalDateTime.now()));
            returnString = returnString.replaceAll("%ss", DateTimeFormatter.ofPattern("ss").format(LocalDateTime.now()));
            returnString = returnString.replaceAll("%SS", DateTimeFormatter.ofPattern("SS").format(LocalDateTime.now()));
            
            returnString = returnString.replaceAll("%level", level);
            returnString = returnString.replaceAll("%thread", getLocalThread().replaceAll("\\$", "\\&"));
            returnString = returnString.replaceAll("%class", arr[5].getClassName().replaceAll("\\$", "\\&"));
            returnString = returnString.replaceAll("%line", String.valueOf(arr[5].getLineNumber()).replaceAll("\\$", "\\&"));
            returnString = returnString.replaceAll("%file", Objects.requireNonNull(arr[5].getFileName()).replaceAll("\\$", "\\&"));
            returnString = returnString.replaceAll("%msg", msg.replaceAll("\\$", "\\&"));
            returnString = returnString.replaceAll("%method", arr[5].getMethodName().replaceAll("\\$", "\\&"));
        } catch (NullPointerException ignored) {
        
        } catch (IllegalArgumentException e) {
            try {
                throw new RuntimeException("Maybe you input illegal char in log,delete it and rerun.", e);
            } catch (RuntimeException ex) {
                ex.printStackTrace();
                return returnString + "\n";
            }
        }
        return returnString + "\n";
    }
    
    @OnlyInLog
    private static String searchMessage(String previousMessage) {
        previousMessage = previousMessage.replaceAll("%os.name", " " + System.getProperty("os.name") + " ");
        previousMessage = previousMessage.replaceAll("%java.version", " " + System.getProperty("java.version") + " ");
        previousMessage = previousMessage.replaceAll("%java.vendor", " " + System.getProperty("java.vendor") + " ");
        previousMessage = previousMessage.replaceAll("%java.vendor.url", " " + System.getProperty("java.vendor.url") + " ");
        previousMessage = previousMessage.replaceAll("%java.home", " " + System.getProperty("java.home") + " ");
        previousMessage = previousMessage.replaceAll("%java.vm.specification.version", " " + System.getProperty("java.vm.specification.version") + " ");
        previousMessage = previousMessage.replaceAll("%java.vm.name", " " + System.getProperty("java.vm.name") + " ");
        previousMessage = previousMessage.replaceAll("%java.vm.version", " " + System.getProperty("java.vm.version") + " ");
        previousMessage = previousMessage.replaceAll("%java.class.version", " " + System.getProperty("java.class.version") + " ");
        previousMessage = previousMessage.replaceAll("%java.class.path", " " + System.getProperty("java.class.path") + " ");
        previousMessage = previousMessage.replaceAll("%java.library.path", " " + System.getProperty("java.library.path") + " ");
        previousMessage = previousMessage.replaceAll("%os.arch", " " + System.getProperty("os.arch") + " ");
        previousMessage = previousMessage.replaceAll("%os.version", " " + System.getProperty("os.version") + " ");
        previousMessage = previousMessage.replaceAll("%user.name", " " + System.getProperty("user.name") + " ");
        previousMessage = previousMessage.replaceAll("%user.home", " " + System.getProperty("user.home") + " ");
        previousMessage = previousMessage.replaceAll("%user.dir", " " + System.getProperty("user.dir") + " ");
        previousMessage = previousMessage.replaceAll("%java.compiler", " " + System.getProperty("java.compiler") + " ");
        previousMessage = previousMessage.replaceAll("%file.separator", " " + System.getProperty("file.separator") + " ");
        previousMessage = previousMessage.replaceAll("%java.io.tmpdir", " " + System.getProperty("java.io.tmpdir") + " ");
        return previousMessage;
    }
    
    @OnlyInLog
    private static String getLocalThread() {
        return Thread.currentThread().getName();
    }
}
