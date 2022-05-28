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
        previousMessage = previousMessage.replaceAll("%os.name", " " +  Matcher.quoteReplacement(System.getProperty("os.name") + " "));
        previousMessage = previousMessage.replaceAll("%java.version", " " +  Matcher.quoteReplacement(System.getProperty("java.version") + " "));
        previousMessage = previousMessage.replaceAll("%java.vendor", " " +  Matcher.quoteReplacement(System.getProperty("java.vendor") + " "));
        previousMessage = previousMessage.replaceAll("%java.vendor.url", " " +  Matcher.quoteReplacement(System.getProperty("java.vendor.url") + " "));
        previousMessage = previousMessage.replaceAll("%java.home", " " +  Matcher.quoteReplacement(System.getProperty("java.home") + " "));
        previousMessage = previousMessage.replaceAll("%java.vm.specification.version", " " +  Matcher.quoteReplacement(System.getProperty("java.vm.specification.version") + " "));
        previousMessage = previousMessage.replaceAll("%java.vm.name", " " +  Matcher.quoteReplacement(System.getProperty("java.vm.name") + " "));
        previousMessage = previousMessage.replaceAll("%java.vm.version", " " +  Matcher.quoteReplacement(System.getProperty("java.vm.version") + " "));
        previousMessage = previousMessage.replaceAll("%java.class.version", " " +  Matcher.quoteReplacement(System.getProperty("java.class.version") + " "));
        previousMessage = previousMessage.replaceAll("%java.class.path", " " +  Matcher.quoteReplacement(System.getProperty("java.class.path") + " "));
        previousMessage = previousMessage.replaceAll("%java.library.path", " " +  Matcher.quoteReplacement(System.getProperty("java.library.path") + " "));
        previousMessage = previousMessage.replaceAll("%os.arch", " " +  Matcher.quoteReplacement(System.getProperty("os.arch") + " "));
        previousMessage = previousMessage.replaceAll("%os.version", " " +  Matcher.quoteReplacement(System.getProperty("os.version") + " "));
        previousMessage = previousMessage.replaceAll("%user.name", " " +  Matcher.quoteReplacement(System.getProperty("user.name") + " "));
        previousMessage = previousMessage.replaceAll("%user.home", " " +  Matcher.quoteReplacement(System.getProperty("user.home") + " "));
        previousMessage = previousMessage.replaceAll("%user.dir", " " +  Matcher.quoteReplacement(System.getProperty("user.dir") + " "));
        previousMessage = previousMessage.replaceAll("%java.compiler", " " +  Matcher.quoteReplacement(System.getProperty("java.compiler") + " "));
        previousMessage = previousMessage.replaceAll("%file.separator", " " +  Matcher.quoteReplacement(System.getProperty("file.separator") + " "));
        previousMessage = previousMessage.replaceAll("%java.io.tmpdir", " " + Matcher.quoteReplacement(System.getProperty("java.io.tmpdir") + " "));
        return previousMessage;
    }
    
    @OnlyInLog
    private static String getLocalThread() {
        return Thread.currentThread().getName();
    }
}
