package com.optilog;

import com.optilog.log.Log;

public class OptilogTest {
    public static void main(String[] args) {
        Log log = Log.initLog("%prop -cp /Settings.properties");
        log.info("---常规输出测试---");
        log.info("info" + new Object());
        log.error("error");
        log.debug("debug" + 32f);
        log.fatal((char[]) null);
        log.fatal((String) null);
        log.warn("warn" + null);
        log.info("---占位符---");
        log.info("#1 #2", "1", "2");
        log.error("#1 #1", "1", "2");
        log.warn(null, "(Object) null");
        log.debug("#1 #2 #3", "1", "2");
        log.fatal("#1 ##2", "1", "2");
        log.debug("#1", () -> "de");
        test(log);
        log.command("%zip D:\\Program\\Feishu\\app\\assets\\object\\apps\\Intellij-IDEA\\Project\\Optilog-Client\\src\\test\\resources\\logs");
    }
    
    private static void test(Log log) {
        log.warn("---变化栈测试---");
        log.info("info(test)");
        new Thread(() -> log.info("hello")).start();
        log.info("$");
        Log log2 = Log.initLog("");
        log2.info("log2");
    }
}
