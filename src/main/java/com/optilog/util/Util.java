package com.optilog.util;

import java.io.PrintStream;

public class Util {
    public static PrintStream output = System.out;

    @OnlyInInit
    @OnlyInLog
    public static PrintStream getOutput() {
        return output;
    }
}
