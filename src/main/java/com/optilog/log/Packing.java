package com.optilog.log;

import com.optilog.util.OnlyInLog;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.regex.Matcher;

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
            returnString = returnString.replaceAll("%thread", Matcher.quoteReplacement(getLocalThread()));
            returnString = returnString.replaceAll("%class", Matcher.quoteReplacement(arr[5].getClassName()));
            returnString = returnString.replaceAll("%line", String.valueOf(arr[5].getLineNumber()));
            returnString = returnString.replaceAll("%file", Matcher.quoteReplacement(Objects.requireNonNull(arr[5].getFileName())));
            returnString = returnString.replaceAll("%msg", Matcher.quoteReplacement(msg));
            returnString = returnString.replaceAll("%method", Matcher.quoteReplacement(arr[5].getMethodName()));
        } catch (NullPointerException ignored) {
        
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
