package com.optilog.util;

import java.io.PrintStream;

public class Util {
    private static final PrintStream output = System.out;

    public static final String TRUE = "true";
    public static final String FALSE = "false";

    @OnlyInInit
    @OnlyInLog
    public static PrintStream getOutput() {
        return output;
    }
}
