package com.optilog.util;

import com.optilog.log.Log;

import java.io.PrintStream;

public class Util {
    @OnlyInInit
    @OnlyInLog
    public static PrintStream getOutput() {
        return System.out;
    }

    public static Log addon;
}
