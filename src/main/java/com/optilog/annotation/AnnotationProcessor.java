package com.optilog.annotation;

public class AnnotationProcessor {
    public static void process() {
        StackTraceElement[] arr = Thread.currentThread().getStackTrace();
        try {
            Class<?> clazz = Class.forName(arr[3].getClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
