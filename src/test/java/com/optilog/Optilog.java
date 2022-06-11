package com.optilog;

import com.optilog.log.Log;
import com.optilog.setting.SettingFiles;

public class Optilog {
    public static void main(String[] args) {
        // 先生成一个默认的properties的配置文件
        SettingFiles.generatePropertiesSettings("/Change/This/To/Your/Own/Path");
        // %prop代表你要使用properties格式，-cp表示再classpath中，所以^^^^这个路径要再你的classpath中，当然你也可以选择不在classpath中
        Log log = Log.initLog("%prop -cp /Settings.properties");
        log.info("Hello World!");
        System.out.println(log.getInfoLogCount());
        System.out.println(log.getDebugLogCount());
    }
}
