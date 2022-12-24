package com.optilog;

import com.optilog.log.Log;
import org.junit.jupiter.api.Test;

import java.io.File;

public class XmlClassPathOptilogTest {
    @Test
    void test() {
        Log log = Log.initLog("%xml -cp /Settings.xml");

        log.info("========测试开始========");

        // info常规测试
        log.info("info常规测试：");
        log.info();
        log.info(new Object());
        log.info("String Test");
        log.info((char[]) null);
        log.info((Object) null);
        log.info((String) null);
        log.info(new char['a']);
        log.info(2324);
        log.info(382845 * (32 + 444));
        log.info(Float.MAX_VALUE);
        log.info(Double.MAX_VALUE);
        log.info(Long.MAX_VALUE);

        // error常规测试
        log.error("error常规测试：");
        log.error();
        log.error(new Object());
        log.error("String Test");
        log.error((char[]) null);
        log.error((Object) null);
        log.error((String) null);
        log.error(new char['a']);
        log.error(2324);
        log.error(6624224 * 42);
        log.error(Float.MAX_VALUE);
        log.error(Double.MAX_VALUE);
        log.error(Long.MAX_VALUE);

        // warn常规测试
        log.warn("warn常规测试：");
        log.warn();
        log.warn(new Object());
        log.warn("String Test");
        log.warn((char[]) null);
        log.warn((Object) null);
        log.warn((String) null);
        log.warn(new char['a']);
        log.warn(2324);
        log.warn(6624224 * 42);
        log.warn(Float.MAX_VALUE);
        log.warn(Double.MAX_VALUE);
        log.warn(Long.MAX_VALUE);

        // fatal常规测试
        log.fatal("fatal常规测试：");
        log.fatal();
        log.fatal(new Object());
        log.fatal("String Test");
        log.fatal((char[]) null);
        log.fatal((Object) null);
        log.fatal((String) null);
        log.fatal(new char['a']);
        log.fatal(2324);
        log.fatal(6624224 * 42);
        log.fatal(Float.MAX_VALUE);
        log.fatal(Double.MAX_VALUE);
        log.fatal(Long.MAX_VALUE);

        // debug常规测试
        log.debug("debug常规测试：");
        log.debug();
        log.debug(new Object());
        log.debug("String Test");
        log.debug((char[]) null);
        log.debug((Object) null);
        log.debug((String) null);
        log.debug(new char['a']);
        log.debug(2324);
        log.debug(6624224 * 42);
        log.debug(Float.MAX_VALUE);
        log.debug(Double.MAX_VALUE);
        log.debug(Long.MAX_VALUE);

        // 变化栈测试
        log.info("变化栈信息测试：");
        stackTest(log);

        // 变化线程测试
        log.info("变化线程测试：");
        new Thread(() -> {
            log.info("1");
            log.error("2");
            log.warn("3");
            log.debug("4");
            log.fatal("5");
            log.info("6");
            log.error("7");
            log.warn("8");
            log.debug("9");
            log.fatal("10");
        }).start();
        log.info("1(N)");
        log.error("2(N)");
        log.warn("3(N)");
        log.debug("4(N)");
        log.fatal("5(N)");
        log.info("6(N)");
        log.error("7(N)");
        log.warn("8(N)");
        log.debug("9(N)");
        log.fatal("10(N)");

        // 运行期配置变化测试
        log.info("运行期配置文件变化测试：");
        log.setPrintInfo(false);
        log.info("This log will not be print.");
        log.setPrintInfo(true);
        log.setConsoleInfo(false);
        log.info("This log will not be console.");
        log.setConsoleInfo(true);

        log.info(new File(".").getAbsolutePath());
    }

    public static void stackTest(Log log) {
        log.info("Stack Test");
        log.error("Stack Test");
        log.warn("Stack Test");
        log.debug("Stack Test");
        log.fatal("Stack Test");
    }
}
