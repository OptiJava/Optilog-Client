package com.optilog.util;

import java.io.PrintStream;

public class Util {
    @OnlyInInit
    @OnlyInLog
    public static PrintStream getOutput() {
        return System.out;
    }
}
