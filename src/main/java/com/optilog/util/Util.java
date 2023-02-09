package com.optilog.util;

import java.io.PrintStream;

public class Util {
    private static final PrintStream output = System.out;

    @OnlyInInit
    @OnlyInLog
    public static PrintStream getOutput() {
        return output;
    }
}
