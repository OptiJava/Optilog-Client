package com.optilog.log;

import com.optilog.util.OnlyInLog;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.regex.Matcher;

public class Packing {
	private Packing() {
		super();
	}
	
	@OnlyInLog
	public static String packMessage(String msg, String level, Optilog instance) {
		StackTraceElement[] arr = Thread.currentThread().getStackTrace();
		String returnString = instance.allSetting.packingFormat;
		try {
			returnString = returnString.replaceAll("%thread", Matcher.quoteReplacement(getLocalThread()));
			
			returnString = returnString.replaceAll("%yyyy", DateTimeFormatter.ofPattern("yyyy").format(LocalDateTime.now()));
			returnString = returnString.replaceAll("%MM", DateTimeFormatter.ofPattern("MM").format(LocalDateTime.now()));
			returnString = returnString.replaceAll("%dd", DateTimeFormatter.ofPattern("dd").format(LocalDateTime.now()));
			returnString = returnString.replaceAll("%HH", DateTimeFormatter.ofPattern("HH").format(LocalDateTime.now()));
			returnString = returnString.replaceAll("%mm", DateTimeFormatter.ofPattern("mm").format(LocalDateTime.now()));
			returnString = returnString.replaceAll("%ss", DateTimeFormatter.ofPattern("ss").format(LocalDateTime.now()));
			returnString = returnString.replaceAll("%SS", DateTimeFormatter.ofPattern("SS").format(LocalDateTime.now()));
			
			returnString = returnString.replaceAll("%level", level);
			
			returnString = returnString.replaceAll("%class", Matcher.quoteReplacement(arr[5].getClassName()));
			returnString = returnString.replaceAll("%line", String.valueOf(arr[5].getLineNumber()));
			returnString = returnString.replaceAll("%file", Matcher.quoteReplacement(Objects.requireNonNull(arr[5].getFileName())));
			returnString = returnString.replaceAll("%msg", Matcher.quoteReplacement(msg));
			returnString = returnString.replaceAll("%method", Matcher.quoteReplacement(arr[5].getMethodName()));
		} catch (NullPointerException i) {
			i.getStackTrace();
		}
		return returnString + "\n";
	}
	
	@OnlyInLog
	private static String getLocalThread() {
		return Thread.currentThread().getName();
	}
}
