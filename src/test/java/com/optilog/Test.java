package com.optilog;

import com.optilog.log.Log;

public class Test {
    public static void main(String[] args) {
        Log log = Log.initLog("");
        log.startSendToJdbc("jdbc:mysql://localhost:3307", "Logs", "root", "");
        log.info("First JDBC Log!");
    }
}

