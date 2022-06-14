package com.optilog;

import com.optilog.log.Level;
import com.optilog.log.LevelBuild;
import com.optilog.log.Log;
import org.junit.jupiter.api.Test;

/**
 * Optilog测试类
 */
public class OptilogTest {
    @Test
    public void test() {
        Log log = Log.initLog("%xml -cp /Settings.xml");
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
        log.log("t!e!s!t！", new LevelBuild("test", Level.INFO));
        test(log);
        //打包日志
        //log.command("%zip -d D:\\Program\\Project\\resources\\app\\Git\\Projects\\Optilog-Client\\src\\test\\resources\\logs");
    }

    private static void test(Log log) {
        log.warn("---变化栈测试---");
        log.info("info(test)");
        new Thread(() -> log.info("hello")).start();
        log.info("$");
        System.out.println(log.getAllLogCount());

        //重新获得实例
        Log log2 = Log.initLog("");
        log2.info("log2");
    }
}
